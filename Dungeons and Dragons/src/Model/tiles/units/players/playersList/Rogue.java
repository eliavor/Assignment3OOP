package Model.tiles.units.players.playersList;

import Model.tiles.units.Unit;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

import java.util.List;
import java.util.stream.Collectors;

public class Rogue extends Player {

    private int cost;
    private int currentEnergy;

    public Rogue(int x, int y, String name, int health, int attackPoints, int defensePoints, int cost) {
        super(x, y, name, health, attackPoints, defensePoints);
        this.cost = cost;
        this.currentEnergy = 100;
    }


    public void OnAbilityCast(List<Unit> enemies) {
        currentEnergy -= cost;

        List<Unit> enemiesInRange = enemies.stream()
                .filter(enemy -> position.distance(enemy.position) < 2)
                .collect(Collectors.toList());

        for (Unit enemy : enemiesInRange) {
            // Deal damage to the enemy
            enemy.health.takeDamage(attack);
            messageCallBackToView.ShowBattleInfo(toDict(), enemy.toDict(), attack, 0);
        }
    }

    public int getExperience(){
        return experience;
    }

    @Override
    public void UponLevelUp() {
        super.UponLevelUp();
        currentEnergy = 100;
        attack += 3 * level;
    }

    @Override
    public void OnGameTick() {
        currentEnergy = Math.min(currentEnergy + 10, 100);
    }


    public void OnAbilityCastAttempt(List<Unit> enemies) {
        if (currentEnergy < cost) {
            messageCallBackToView.abilityErrorMessage("Ability is not ready yet!");
        } else {
            OnAbilityCast(enemies);
        }
    }
}
