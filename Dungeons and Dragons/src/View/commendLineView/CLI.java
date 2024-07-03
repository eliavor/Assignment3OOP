package View.commendLineView;

import utilsGeneral.MessageCallBackToController;
import View.utils.View;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;

public class CLI implements View{

    private  MessageCallBackToView messageCallBackToView;

    private MessageCallBackToController messageCallBackToController;

    public CLI(MessageCallBackToController messageCallBackToController){

        messageCallBackToView = new MessageCallBackToView() {

            @Override
            public void UpdateTile(char symbol, int x, int y) {
                updateTile(symbol, x, y);
            }

            @Override
            public void LoadMap(int width, int height) {
                loadMap(width, height);
            }

            @Override
            public void ShowBattleInfo(Dictionary<String, String> battleInfo) {
                battleInfo(battleInfo);
            }

            @Override
            public void ShowPlayerStats(Dictionary<String, String> playerStats) {
                playerStats(playerStats);
            }
        };

    }

    @Override
    public MessageCallBackToView getMessageCallBack(){
        return this.messageCallBackToView;
    }

    private void updateTile(char c, int x, int y){

    }
    private void loadMap(int width, int height){

    }

    private void battleInfo(Dictionary<String, String> battleInfo){

    }

    private void playerStats(Dictionary<String, String> playerStats){

    }


}
