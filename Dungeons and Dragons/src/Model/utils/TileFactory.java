package Model.utils;

import Model.tiles.Empty;
import Model.tiles.Tile;
import Model.tiles.Wall;
import Model.tiles.units.enenies.Monster;
import Model.tiles.units.enenies.Trap;
import utilsGeneral.MessageCallBackToView;

public class TileFactory {

    public static final char[] Enemies = {'s', 'k', 'q', 'z', 'b', 'g', 'w', 'M', 'C', 'K', 'B', 'Q', 'D'};

    public TileFactory() {
    }

    public static boolean isEnemy(char tileChar) {
        for (char c : Enemies) {
            if (c == tileChar) {
                return true;
            }
        }
        return false;
    }

    public static Tile createTile(char tileChar, MessageCallBackToView messageCallBackToView) {
        return switch (tileChar) {
            case '#' -> new Wall();
            case '.' -> new Empty();
            case 's' -> new Monster("Lannister Solider", 's', 80, 8, 3, 3, 25, messageCallBackToView);
            case 'k' -> new Monster("Lannister Knight", 'k', 200, 14, 8, 4, 50, messageCallBackToView);
            case 'q' -> new Monster("Queen’s Guard", 'q', 400, 20, 15, 5, 100, messageCallBackToView);
            case 'z' -> new Monster("Wright", 'z', 600, 30, 15, 3, 100, messageCallBackToView);
            case 'b' -> new Monster("Bear-Wright", 'b', 1000, 75, 30, 4, 250, messageCallBackToView);
            case 'g' -> new Monster("Giant-Wright", 'g', 1500, 100, 40, 5, 500, messageCallBackToView);
            case 'w' -> new Monster("White Walker", 'w', 2000, 150, 50, 6, 1000, messageCallBackToView);
            case 'M' -> new Monster("The Mountain", 'M', 1000, 60, 25, 6, 500, messageCallBackToView);
            case 'C' -> new Monster("Queen Cersei", 'C', 100, 10, 10, 1, 1000, messageCallBackToView);
            case 'K' -> new Monster("Night’s King", 'K', 5000, 300, 150, 8, 5000, messageCallBackToView);
            case 'B' -> new Trap("Bonus Trap", 'B', 1, 1, 1, 250, 1, 5, messageCallBackToView);
            case 'Q' -> new Trap("Queen’s Trap", 'Q', 250, 50, 10, 100, 3, 7, messageCallBackToView);
            case 'D' -> new Trap("Death Trap", 'D', 500, 100, 20, 250, 5, 10, messageCallBackToView);
            default -> throw new IllegalArgumentException("Unknown tile character: " + tileChar);
        };
    }
}
