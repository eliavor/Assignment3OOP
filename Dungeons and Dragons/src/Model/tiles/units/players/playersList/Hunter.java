package Model.tiles.units.players.playersList;

import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class Hunter extends Player {
    private int range;
    private int arrowCount;
    private int ticksCount;

    public Hunter(int x, int y, String name, int health, int attack, int defense, int range, int arrowCount) {
        super(x, y, name, health, attack, defense);
        this.range = range;
        this.arrowCount = arrowCount;
        this.ticksCount = 0;
    }


    @Override
    public void UponLevelUp() {
        super.UponLevelUp();
        this.arrowCount += 10 * level;
        this.attack += 2 * level;
        this.defense += level;
    }

    @Override
    public void OnGameTick() {
        if (ticksCount == 10) {
            arrowCount += level;
            ticksCount = 0;
        } else {
            ticksCount++;
        }
    }

    @Override
    public void OnAbilityCastAttempt(List<Enemy> enemies) {
        if (arrowCount == 0) {
            messageCallBackToView.abilityErrorMessage("Ability is not ready yet!");
        }
        List<Enemy> enemyInRange = enemies.stream()
                .filter(enemy -> position.distance(enemy.position) < range)
                .toList();

         if(enemyInRange.isEmpty()) {
             messageCallBackToView.abilityErrorMessage("No enemy in range!");
        }
        else {
            OnAbilityCast(enemyInRange);
        }
    }


    @Override
    public void OnAbilityCast(List<Enemy> enemyInRange) {


            Enemy closest = enemyInRange.getFirst();
            for (Enemy enemy : enemyInRange) {
                if (enemy.position.distance(this.position) < closest.position.distance(this.position)) {
                    closest = enemy;
                }
            }
            closest.health.takeDamage(attack );
            messageCallBackToView.ShowBattleInfo(toDict(), closest.toDict(),attack, 0);
            this.arrowCount--;
            if (!closest.isAlive()) {
                addExperience(closest.getExperience());
                closest.onDeath();
            }
    }
    @Override
    public Dictionary<String, String> toDict() {
        Dictionary<String, String> dict = super.toDict();
        dict.put("arrow count:", String.valueOf(arrowCount));
        return dict;
    }
}
