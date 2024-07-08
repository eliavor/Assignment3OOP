package utilsGeneral;

import java.util.Dictionary;
import java.util.List;

public interface MessageCallBackToView {

    void UpdateTile(char newSymbol, int x, int y);

    void LoadMap(int width, int height);

    void ShowBattleInfo(Dictionary<String, String> battleInfo, Dictionary<String, String> battleInfo2, int attacker , int defender);

    void ShowPlayerStats(Dictionary<String, String> playerStats);

    void abilityErrorMessage(String s);

    void playerDeath();
}
