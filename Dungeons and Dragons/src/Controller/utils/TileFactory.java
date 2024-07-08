package Controller.utils;

import Model.tiles.Empty;
import Model.tiles.Tile;
import Model.tiles.Wall;
import Model.tiles.units.enemies.enamiesList.Monster;
import Model.tiles.units.enemies.enamiesList.Trap;
import Model.tiles.units.players.playersList.Mage;
import Model.tiles.units.players.Player;
import Model.tiles.units.players.playersList.Rogue;
import Model.tiles.units.players.playersList.Warrior;
import utilsGeneral.MessageCallBackToView;


import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class TileFactory {

    public static final char[] Enemies = {'s', 'k', 'q', 'z', 'b', 'g', 'w', 'M', 'C', 'K', 'B', 'Q', 'D'};

    public static final List<Dictionary<String, String>> players = List.of(
            new Hashtable<>() {{
                put("name", "Jon Snow");
                put("health", "300");
                put("attack", "30");
                put("defense", "4");
                put("energy", "3");
            }},
            new Hashtable<>() {{
                put("name", "The Hound");
                put("health", "400");
                put("attack", "20");
                put("defense", "6");
                put("energy", "5");
            }},
            new Hashtable<>() {{
                put("name", "Melisandre");
                put("health", "100");
                put("attack", "5");
                put("defense", "1");
                put("mana", "300");
                put("manaCost", "30");
                put("spellPower", "15");
                put("hitCount", "5");
                put("abilityRange", "6");
            }},
            new Hashtable<>() {{
                put("name", "Thoros of Myr");
                put("health", "250");
                put("attack", "25");
                put("defense", "4");
                put("mana", "150");
                put("manaCost", "20");
                put("spellPower", "20");
                put("hitCount", "3");
                put("abilityRange", "4");
            }},
            new Hashtable<>() {{
                put("name", "Arya Stark");
                put("health", "150");
                put("attack", "40");
                put("defense", "2");
                put("energy", "20");
            }},
            new Hashtable<>() {{
                put("name", "Bronn");
                put("health", "250");
                put("attack", "35");
                put("defense", "3");
                put("energy", "50");
            }}
    );

    public static final List<Dictionary<String, String>> enemies = List.of(
            new Hashtable<>() {{
                put("name", "Lannister Solider");
                put("health", "80");
                put("attack", "8");
                put("defense", "3");
                put("experience", "25");
            }},
            new Hashtable<>() {{
                put("name", "Lannister Knight");
                put("health", "200");
                put("attack", "14");
                put("defense", "8");
                put("experience", "50");
            }},
            new Hashtable<>() {{
                put("name", "Queen’s Guard");
                put("health", "400");
                put("attack", "20");
                put("defense", "15");
                put("experience", "100");
            }},
            new Hashtable<>() {{
                put("name", "Wright");
                put("health", "600");
                put("attack", "30");
                put("defense", "15");
                put("experience", "100");
            }},
            new Hashtable<>() {{
                put("name", "Bear-Wright");
                put("health", "1000");
                put("attack", "75");
                put("defense", "30");
                put("experience", "250");
            }},
            new Hashtable<>() {{
                put("name", "Giant-Wright");
                put("health", "1500");
                put("attack", "100");
                put("defense", "40");
                put("experience", "500");
            }},
            new Hashtable<>() {{
                put("name", "White Walker");
                put("health", "2000");
                put("attack", "150");
                put("defense", "50");
                put("experience", "1000");
            }},
            new Hashtable<>() {{
                put("name", "The Mountain");
                put("health", "1000");
                put("attack", "60");
                put("defense", "25");
                put("experience", "500");
            }},
            new Hashtable<>() {{
                put("name", "Queen Cersei");
                put("health", "100");
                put("attack", "10");
                put("defense", "10");
                put("experience", "1000");
            }},
            new Hashtable<>() {{
                put("name", "Night’s King");
                put("health", "5000");
                put("attack", "300");
                put("defense", "150");
                put("experience", "5000");
            }},
            new Hashtable<>() {{
                put("name", "Bonus Trap");
                put("health", "1");
                put("attack", "1");
                put("defense", "1");
                put("experience", "250");
                put("damage", "1");
                put("cooldown", "5");
            }},
            new Hashtable<>() {{
                put("name", "Queen’s Trap");
                put("health", "250");
                put("attack", "50");
                put("defense", "10");
                put("experience", "100");
                put("damage", "3");
                put("cooldown", "7");
            }},
            new Hashtable<>() {{
                put("name", "Death Trap");
                put("health", "500");
                put("attack", "100");
                put("defense", "20");
                put("experience", "250");
                put("damage", "5");
                put("cooldown", "10");
            }}
    );

    private TileFactory() {}

    public static boolean isEnemy(char tileChar) {
        for (char c : Enemies) {
            if (c == tileChar) {
                return true;
            }
        }
        return false;
    }

    public static Tile createTile(int x, int y, char tileChar, MessageCallBackToView messageCallBackToView) {
        Tile tile;
        switch (tileChar) {
            case '#':
                tile = new Wall(x, y, messageCallBackToView);
                break;
            case '.':
                tile = new Empty(x, y, messageCallBackToView);
                break;
            case 's':
                tile = createMonster(x, y, messageCallBackToView, 0);
                break;
            case 'k':
                tile = createMonster(x, y, messageCallBackToView, 1);
                break;
            case 'q':
                tile = createMonster(x, y, messageCallBackToView, 2);
                break;
            case 'z':
                tile = createMonster(x, y, messageCallBackToView, 3);
                break;
            case 'b':
                tile = createMonster(x, y, messageCallBackToView, 4);
                break;
            case 'g':
                tile = createMonster(x, y, messageCallBackToView, 5);
                break;
            case 'w':
                tile = createMonster(x, y, messageCallBackToView, 6);
                break;
            case 'M':
                tile = createMonster(x, y, messageCallBackToView, 7);
                break;
            case 'C':
                tile = createMonster(x, y, messageCallBackToView, 8);
                break;
            case 'K':
                tile = createMonster(x, y, messageCallBackToView, 9);
                break;
            case 'B':
                tile = createTrap(x, y, messageCallBackToView, 10);
                break;
            case 'Q':
                tile = createTrap(x, y, messageCallBackToView, 11);
                break;
            case 'D':
                tile = createTrap(x, y, messageCallBackToView, 12);
                break;

            default:
                throw new IllegalArgumentException("Unknown tile character: " + tileChar+ ".");
        }
        return tile;
    }

    private static Monster createMonster(int x, int y, MessageCallBackToView messageCallBackToView, int index) {
        Dictionary<String, String> enemyData = enemies.get(index);
        return new Monster(
                x, y,
                enemyData.get("name"),
                Enemies[index],
                Integer.parseInt(enemyData.get("health")),
                Integer.parseInt(enemyData.get("attack")),
                Integer.parseInt(enemyData.get("defense")),
                3, // Assuming vision range as 3, can be customized if needed
                Integer.parseInt(enemyData.get("experience")),
                messageCallBackToView
        );
    }

    private static Trap createTrap(int x, int y, MessageCallBackToView messageCallBackToView, int index) {
        Dictionary<String, String> trapData = enemies.get(index);
        return new Trap(
                x, y,
                trapData.get("name"),
                Enemies[index],
                Integer.parseInt(trapData.get("health")),
                Integer.parseInt(trapData.get("attack")),
                Integer.parseInt(trapData.get("defense")),
                Integer.parseInt(trapData.get("damage")),
                Integer.parseInt(trapData.get("cooldown")),
                Integer.parseInt(trapData.get("experience")),
                messageCallBackToView
        );
    }

    public static Player createPlayer(int playerChoice, int x, int y, char tileChar, MessageCallBackToView messageCallBackToView) {
        if (playerChoice < 1 || playerChoice > players.size()) {
            throw new IllegalArgumentException("Invalid player choice: " + playerChoice);
        }

        Dictionary<String, String> playerData = players.get(playerChoice - 1);

        return switch (playerChoice) {
            case 1, 2 -> new Warrior(
                    x, y,
                    playerData.get("name"),
                    Integer.parseInt(playerData.get("health")),
                    Integer.parseInt(playerData.get("attack")),
                    Integer.parseInt(playerData.get("defense")),
                    Integer.parseInt(playerData.get("energy")),
                    messageCallBackToView
            );
            case 3, 4 -> new Mage(
                    x, y,
                    playerData.get("name"),
                    Integer.parseInt(playerData.get("health")),
                    Integer.parseInt(playerData.get("attack")),
                    Integer.parseInt(playerData.get("defense")),
                    Integer.parseInt(playerData.get("mana")),
                    Integer.parseInt(playerData.get("manaCost")),
                    Integer.parseInt(playerData.get("spellPower")),
                    Integer.parseInt(playerData.get("hitCount")),
                    Integer.parseInt(playerData.get("abilityRange")),
                    messageCallBackToView
            );
            case 5, 6 -> new Rogue(
                    x, y,
                    playerData.get("name"),
                    Integer.parseInt(playerData.get("health")),
                    Integer.parseInt(playerData.get("attack")),
                    Integer.parseInt(playerData.get("defense")),
                    Integer.parseInt(playerData.get("energy")),
                    messageCallBackToView
            );
            default -> throw new IllegalStateException("Unexpected value: " + playerChoice);
        };
    }

    public static List<Dictionary<String, String>> ChoosePlayer() {
        return players;
    }
}
