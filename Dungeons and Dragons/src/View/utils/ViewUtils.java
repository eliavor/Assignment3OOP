package View.utils;
import java.util.Dictionary;
import java.util.Enumeration;

public class ViewUtils {

    public static String CreateBattleString(Dictionary<String, String> battleInfo1, Dictionary<String, String> battleInfo2, int attacker, int defender){
        int damageInflicted = Math.max(attacker-defender, 0);
        String ans = battleInfo1.get("Unit") + " is attacking " + battleInfo2.get("Unit") +
        "\n" + CreatePlayerString(battleInfo1) +"\n" + CreatePlayerString(battleInfo2) + "\n" +
        battleInfo1.get("Unit") + " rolled " + attacker + " damage points." + "\n"
        + battleInfo2.get("Unit") + " rolled " + defender + " defense points." + "\n"
        + "in total " + battleInfo1.get("Unit") +"dealt " + damageInflicted +" damage points.";
        return ans;

    }
    public static String CreatePlayerString(Dictionary<String, String> playerStats){
        String ans = playerStats.get("Unit");
        Enumeration<String> keys = playerStats.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if(!key.equals("Unit")){
                ans = ans + key + ": " + playerStats.get(key) + ", ";
            }
        }
        return ans;
    }
    public static String CreateBoardString(Character[][] board){
        String ans = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                ans += board[i][j];
            }
            ans = ans + "\n";
        }
        return ans;
    }
}
