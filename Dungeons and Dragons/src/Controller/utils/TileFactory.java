package Controller.utils;

import Model.tiles.Empty;
import Model.tiles.Tile;
import Model.tiles.Wall;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.enemies.enamiesList.Boss;
import Model.tiles.units.enemies.enamiesList.Monster;
import Model.tiles.units.enemies.enamiesList.Trap;
import Model.tiles.units.players.playersList.Hunter;
import Model.tiles.units.players.playersList.Mage;
import Model.tiles.units.players.Player;
import Model.tiles.units.players.playersList.Rogue;
import Model.tiles.units.players.playersList.Warrior;
import Model.utils.Position;


import java.util.*;
import java.util.function.Supplier;

public class TileFactory {

    private static Player player;

    public static final List<Supplier<Player>> players = List.of(
            () -> new Warrior(0, 0, "Jon Snow", 300, 30, 4, 3),
            () -> new Warrior(0, 0, "The Hound", 400, 20, 6, 5),
            () -> new Mage(0, 0, "Melisandre", 100, 5, 1, 300, 30, 15, 5, 6),
            () -> new Mage(0, 0, "Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4),
            () -> new Rogue(0, 0, "Arya Stark", 150, 40, 2, 20),
            () -> new Rogue(0, 0, "Bronn", 250, 35, 3, 50),
            () -> new Hunter(0,0,"ygritte", 220,30,2,6,10)

    );

    public static final Map<Character, Supplier<Enemy>> enemies = Map.ofEntries(
            new AbstractMap.SimpleEntry<>('s', () -> new Monster(0, 0, "Lannister Solider", 's', 80, 8, 3, 3, 25)),
            new AbstractMap.SimpleEntry<>('k', () -> new Monster(0, 0, "Lannister Knight", 'k', 200, 14, 8, 3, 50)),
            new AbstractMap.SimpleEntry<>('q', () -> new Monster(0, 0, "Queen’s Guard", 'q', 400, 20, 15, 3, 100)),
            new AbstractMap.SimpleEntry<>('z', () -> new Monster(0, 0, "Wright", 'z', 600, 30, 15, 3, 100)),
            new AbstractMap.SimpleEntry<>('b', () -> new Monster(0, 0, "Bear-Wright", 'b', 1000, 75, 30, 3, 250)),
            new AbstractMap.SimpleEntry<>('g', () -> new Monster(0, 0, "Giant-Wright", 'g', 1500, 100, 40, 3, 500)),
            new AbstractMap.SimpleEntry<>('w', () -> new Monster(0, 0, "White Walker", 'w', 2000, 150, 50, 3, 1000)),
            new AbstractMap.SimpleEntry<>('M', () -> new Boss(0, 0, "The Mountain", 'M', 1000, 60, 25, 6, 500,5)),
            new AbstractMap.SimpleEntry<>('C', () -> new Boss(0, 0, "Queen Cersei", 'C', 100, 10, 10, 1, 1000,5)),
            new AbstractMap.SimpleEntry<>('K', () -> new Boss(0, 0, "Night’s King", 'K', 5000, 300, 150, 8, 5000,3)),
            new AbstractMap.SimpleEntry<>('B', () -> new Trap(0, 0, "Bonus Trap", 'B', 1, 1, 1, 1, 5, 250)),
            new AbstractMap.SimpleEntry<>('Q', () -> new Trap(0, 0, "Queen’s Trap", 'Q', 250, 50, 10, 3, 7, 100)),
            new AbstractMap.SimpleEntry<>('D', () -> new Trap(0, 0, "Death Trap", 'D', 500, 100, 20, 5, 10, 250))
    );




    private TileFactory() {}

    public static Player createPlayer(int playerID, int x, int y) {
        Supplier<Player> playerSupplier = players.get(playerID - 1);
        player = playerSupplier.get();
        player.setPosition(new Position(x, y));
        return player;
    }

    public static Player createPlayer(int x, int y) {
        player.setPosition(new Position(x,y));
        return player;
    }

    public static Enemy createEnemy(char c, int x, int y) {
        Supplier<Enemy> enemySupplier = enemies.get(c);
        if (enemySupplier != null) {
            Enemy enemy = enemySupplier.get();
            enemy.setPosition(new Position(x, y));
            return enemy;
        } else {
            throw new IllegalArgumentException("Unknown enemy type: " + c);
        }
    }

    public static Tile createWall(int x, int y) {
        return new Wall(x, y);
    }

    public static Tile createEmpty(int x, int y) {
        return new Empty(x, y);
    }

    public static List<Dictionary<String, String>> choosePlayer() {
        List<Dictionary<String, String>> playerDetails = new ArrayList<>();
        for (Supplier<Player> playerSupplier : players) {
            Player player = playerSupplier.get();
            playerDetails.add(player.toDict());
        }
        return playerDetails;
    }

}
