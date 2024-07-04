package Model.tiles.units.players.playersList;

import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Warrior extends Player {

    private int abilityCoolDown;
    private int remainingCoolDown;

    public Warrior(int x, int y, String name, int health, int attack, int defense, int cooldown, MessageCallBackToView messageCallBackToView) {
        super(x, y, name, health, attack, defense, messageCallBackToView);
        this.abilityCoolDown = cooldown;
        this.remainingCoolDown = 0;
    }

    @Override
    public void OnAbilityCast(List<Enemy> enemies) {
        if (!isAbilityReady()) {
            messageCallBackToView.abilityErrorMessage("Ability is not ready yet!");
            return;
        }

        remainingCoolDown = abilityCoolDown;

        // Heal the warrior
        health.setCurrent(Math.min(health.getCurrent() + (10 * defense), health.getCapacity()));

        // Filter enemies within range < 3
        List<Enemy> enemiesInRange = enemies.stream()
                .filter(enemy -> position.distance(enemy.position) < 3)
                .collect(Collectors.toList());

        // If there are enemies within range
        if (!enemiesInRange.isEmpty()) {
            // Select a random enemy
            Random rand = new Random();
            Enemy target = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));

            // Calculate damage as 10% of the warrior's health pool
            int damage = (int) (0.1 * health.getCapacity());

            // Deal damage to the selected enemy
            target.health.takeDamage(damage);
        }
    }

    @Override
    protected void UponLevelUp() {
        super.UponLevelUp();
        remainingCoolDown = 0;
        health.increaseMax(5 * level);
        attack += 2 * level;
        defense += level;
    }

    @Override
    public void OnGameTick() {
        if (remainingCoolDown > 0) {
            remainingCoolDown--;
        }
    }

    @Override
    public void OnAbilityCastAttempt(List<Enemy> enemies) {
        if (!isAbilityReady()) {
            messageCallBackToView.abilityErrorMessage("Ability is not ready yet!");
        } else {
            OnAbilityCast(enemies);
        }
    }

    public boolean isAbilityReady() {
        return remainingCoolDown == 0;
    }
}
