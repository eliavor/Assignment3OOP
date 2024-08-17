//package Model.tiles.units.players.playersList;
//
//import Model.tiles.units.enemies.Enemy;
//import Model.tiles.units.players.Player;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Hunter extends Player {
//    private int range;
//    private int arrowCount;
//    private int ticksCount;
//
//    public Hunter(int x, int y, String name, int health, int attack, int defense, int range, int arrowCount) {
//        super(x, y, name, health, attack, defense);
//        this.range = range;
//        this.arrowCount = arrowCount;
//        this.ticksCount = 0;
//    }
//
//
//    @Override
//    public void UponLevelUp() {
//        super.UponLevelUp();
//        this.arrowCount += 10 * level;
//        this.attack += 2 * level;
//        this.defense += level;
//    }
//
//    @Override
//    public void OnGameTick() {
//        if (ticksCount == 10) {
//            arrowCount += level;
//            ticksCount = 0;
//        } else {
//            ticksCount++;
//        }
//    }
//
//    @Override
//    public void OnAbilityCastAttempt(List<Enemy> enemies) {
//        if (arrowCount == 0) {
//            messageCallBackToView.abilityErrorMessage("Ability is not ready yet!");
//        } else {
//            OnAbilityCast(enemies);
//        }
//    }
//
//
//    @Override
//    public void OnAbilityCast(List<Enemy> enemies) {
//        List<Enemy> enemyInRange = enemies.stream()
//                .filter(enemy -> position.distance(enemy.position) < range)
//                .toList();
//
//        if (!enemyInRange.isEmpty()) {
//
//            Enemy closest = enemyInRange.get(0);
//            for (Enemy enemy : enemyInRange) {
//                if (enemy.position.distance(this.position) < closest.position.distance(this.position)) {
//                    closest = enemy;
//                }
//            }
//            messageCallback.send(String.format("%s fired an arrow at %s", this.getName(), closest.getName()));
//            messageCallback.send(String.format("%s hit %s for %d ability damage.", this.getName(), closest.getName(), closest.health.takeDamage(this.attack - closest.defend())));
//            this.arrowCount--;
//            if (!closest.alive()) {
//                addExperience(closest.experienceValue());
//                closest.onDeath();
//            }
//        }
//        else {
//            messageCallback.send(String.format("%s tried to shoot an arrow but has no arrows.", this.getName()));
//
//        }
//
//
//    }
//}
