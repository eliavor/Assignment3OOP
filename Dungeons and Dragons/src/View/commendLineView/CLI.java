package View.commendLineView;

import utilsGeneral.MessageCallBackToController;
import View.utils.View;
import View.utils.ViewUtils;
import utilsGeneral.MessageCallBackToView;
import java.util.Dictionary;

public class CLI implements View{
    private Character[][] board;
    private String battleString;
    private String playerString;

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
        board[y][x] = c;
    }
    private void loadMap(int width, int height){
        board = new Character[height][width];
    }

    private void battleInfo(Dictionary<String, String> battleInfo1, Dictionary<String, String> battleInfo2 ){
        if(battleString == null){
            battleString = "";
        }
        battleString += ViewUtils.CreateBattleString(battleInfo1, battleInfo2);
    }

    private void playerStats(Dictionary<String, String> playerStats){
        if(playerString == null){
            battleString = "";
        }
        playerString += ViewUtils.CreatePlayerString(playerStats);
        printTick();
    }

    private void printTick(){
        String boardString = ViewUtils.CreateBoardString(board);
        String toPrint = battleString +"/n" + boardString + "/n" + playerString;
        System.out.println(toPrint);
        messageCallBackToController.nextTick();
    }


}
