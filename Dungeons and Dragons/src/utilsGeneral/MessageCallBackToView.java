package utilsGeneral;

import java.util.Dictionary;
import java.util.List;

public interface MessageCallBackToView {

    public void UpdateTile(char newSymbol, int x, int y);

    public void LoadMap(int width, int height);

    public void ShowBattleInfo(Dictionary<String, String> battleInfo, Dictionary<String, String> battleInfo2, int attacker , int defender);

    public void ShowPlayerStats(Dictionary<String, String> playerStats);
    public void initiateGame(List<Dictionary<String, String>> availablePlayers);
}
