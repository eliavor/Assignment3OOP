package utilsGeneral;

import java.util.Dictionary;

public interface MessageCallBackToView {

    public void UpdateTile(char newSymbol, int x, int y);

    public void LoadMap(int width, int height);

    public void ShowBattleInfo(Dictionary<String, String> battleInfo, Dictionary<String, String> battleInfo2);

    public void ShowPlayerStats(Dictionary<String, String> playerStats);
}
