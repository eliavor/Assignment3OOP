package Model.tiles.units.players.playersList;

import Model.tiles.units.Unit;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Mage extends Player {

    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitCount;
    private int abilityRange;

    public Mage(int x, int y, String name, int health, int attackPoints, int defensePoints, int manaPool, int manaCost, int spellPower, int hitCount, int abilityRange) {
        super(x, y, name, health, attackPoints, defensePoints);
        this.manaPool = manaPool;
        this.manaCost = manaCost;
        this.currentMana = manaPool / 4;
        this.spellPower = spellPower;
        this.hitCount = hitCount;
        this.abilityRange = abilityRange;
    }


    public void OnAbilityCast(List<Unit> enemies) {
        currentMana -= manaCost;
        int hits = 0;
        Random rand = new Random();

        List<Unit> enemiesInRange = enemies.stream()
                .filter(enemy -> position.distance(enemy.position) < abilityRange)
                .collect(Collectors.toList());

        while (hits < hitCount && !enemiesInRange.isEmpty()) {
            Unit target = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));
            int damage = spellPower;

            // Deal damage to the selected enemy
            target.health.takeDamage(damage);
            messageCallBackToView.ShowBattleInfo(toDict(), target.toDict(), damage, 0);
            // Remove dead enemies from the list
            enemiesInRange = enemiesInRange.stream()
                    .filter(Unit::isAlive)
                    .collect(Collectors.toList());

            hits++;
        }
    }
    public int getExperience(){
        return experience;
    }

    @Override
    public void UponLevelUp() {
        super.UponLevelUp();
        manaPool += 25 * level;
        currentMana = Math.min(currentMana + manaPool / 4, manaPool);
        spellPower += 10 * level;
    }

    @Override
    public void OnGameTick() {
        currentMana = Math.min(currentMana + level, manaPool);
    }


    public void OnAbilityCastAttempt(List<Unit> enemies) {
        if (currentMana < manaCost) {
            messageCallBackToView.abilityErrorMessage("Ability is not ready yet!");
        } else {
            OnAbilityCast(enemies);
        }
    }
}
