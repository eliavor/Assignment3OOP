package Model.utils;

import Model.tiles.Empty;
import Model.tiles.Tile;
import Model.tiles.Wall;
import Model.tiles.units.enenies.Monster;
import Model.tiles.units.enenies.Trap;
import Model.tiles.units.players.Mage;
import Model.tiles.units.players.Player;
import Model.tiles.units.players.Rogue;
import Model.tiles.units.players.Warrior;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.Hashtable;

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

    public static Tile createTile(int x, int y,char tileChar, MessageCallBackToView messageCallBackToView) {
        return switch (tileChar) {
            case '#' -> new Wall();
            case '.' -> new Empty();
            case 's' -> new Monster(x, y, "Lannister Solider", 's', 80, 8, 3, 3, 25, messageCallBackToView);
            case 'k' -> new Monster(x, y,"Lannister Knight", 'k', 200, 14, 8, 4, 50, messageCallBackToView);
            case 'q' -> new Monster(x, y,"Queen’s Guard", 'q', 400, 20, 15, 5, 100, messageCallBackToView);
            case 'z' -> new Monster(x, y,"Wright", 'z', 600, 30, 15, 3, 100, messageCallBackToView);
            case 'b' -> new Monster(x, y,"Bear-Wright", 'b', 1000, 75, 30, 4, 250, messageCallBackToView);
            case 'g' -> new Monster(x, y,"Giant-Wright", 'g', 1500, 100, 40, 5, 500, messageCallBackToView);
            case 'w' -> new Monster(x, y,"White Walker", 'w', 2000, 150, 50, 6, 1000, messageCallBackToView);
            case 'M' -> new Monster(x, y,"The Mountain", 'M', 1000, 60, 25, 6, 500, messageCallBackToView);
            case 'C' -> new Monster(x, y,"Queen Cersei", 'C', 100, 10, 10, 1, 1000, messageCallBackToView);
            case 'K' -> new Monster(x, y,"Night’s King", 'K', 5000, 300, 150, 8, 5000, messageCallBackToView);
            case 'B' -> new Trap(x, y,"Bonus Trap", 'B', 1, 1, 1, 250, 1, 5, messageCallBackToView);
            case 'Q' -> new Trap(x, y,"Queen’s Trap", 'Q', 250, 50, 10, 100, 3, 7, messageCallBackToView);
            case 'D' -> new Trap(x, y,"Death Trap", 'D', 500, 100, 20, 250, 5, 10, messageCallBackToView);
            default -> throw new IllegalArgumentException("Unknown tile character: " + tileChar);
        };
    }

    public static Tile createPlayer(int playerChoice, int x, int y,char tileChar, MessageCallBackToView messageCallBackToView){
        return switch (playerChoice){
            case 1 -> new Warrior(x, y, "Jon Snow", 300, 30, 4,3,  messageCallBackToView);
            case 2 -> new Warrior(x, y, "The Hound", 400, 20, 6,5,  messageCallBackToView);
            case 3 -> new Mage(x, y, "Melisandre", 100, 5, 1,300, 30, 15, 5, 6, messageCallBackToView);
            case 4 -> new Mage(x, y, "Thoros of Myr", 250, 25, 4,150, 20, 20, 3, 4, messageCallBackToView);
            case 5 -> new Rogue(x, y, "Arya Stark", 150, 40, 2,20,  messageCallBackToView);
            case 6 -> new Rogue(x, y, "Bronn", 250, 35, 3,50,  messageCallBackToView);

            default -> throw new IllegalStateException("Unexpected value: " + playerChoice);
        };

    }
    
}
