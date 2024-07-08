package View.commendLineView;

import utilsGeneral.MessageCallBackToController;
import View.utils.View;
import View.utils.ViewUtils;
import utilsGeneral.MessageCallBackToView;
import java.util.Dictionary;
import java.util.List;

public class CLI implements View{
    private Character[][] board;
    private String battleString;
    private String playerString;
    private String[] died;
    private String[] win;

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
            public void ShowBattleInfo(Dictionary<String, String> battleInfo, Dictionary<String, String> battleInfo2, int attacker, int defender) {
                battleInfo(battleInfo, battleInfo2, attacker, defender);
            }


            @Override
            public void abilityErrorMessage(String s) {
                System.out.println(s);
            }

            @Override
            public void playerDeath() {
                died = new String[]{
                        " __        __    _  _____ _____ _______ ______ ",
                        " \\ \\      / /__ | ||  ___|  __ \\_   _|  ____|",
                        "  \\ \\ /\\ / / _ \\| || |_  | |  | || | | |__   ",
                        "   \\ V  V /  __/| ||  _| | |  | || | |  __|  ",
                        "    \\_/\\_/ \\___||_||_|   |_|  |_||_| |_|     ",
                        "                                              "
                };

                // Print WASTED Art


            }

            @Override
            public void ShowPlayerStats(Dictionary<String, String> playerStats) {
                playerStats(playerStats);
            }
        };
        this.messageCallBackToController = messageCallBackToController;
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

    private void battleInfo(Dictionary<String, String> battleInfo1, Dictionary<String, String> battleInfo2, int attacker, int defender ){
        if(battleString == null){
            battleString = "";
        }
        battleString += ViewUtils.CreateBattleString(battleInfo1, battleInfo2, attacker, defender);
        battleString += "\n";
    }

    private void playerStats(Dictionary<String, String> playerStats){
        if(playerString == null){
            playerString = "";
        }
        playerString += ViewUtils.CreatePlayerString(playerStats);
        printTick();
    }

    private void printTick(){
        if(battleString == null){
            battleString = "";
        }
        String boardString = ViewUtils.CreateBoardString(board);
        String toPrint = battleString +"\n" + boardString + "\n" + playerString;
        System.out.println(toPrint);
        battleString = "";
        playerString = "";
        if(died != null){
            for (String line : died) {
                System.out.println(line);
            }
        }
        if(win != null){
            for (String line : win) {
                System.out.println(line);
            }
        }
        messageCallBackToController.nextTick();
    }


    public void choosePlayer(List<Dictionary<String, String>> availablePlayers){
        String toPrint = "";
        int i = 1;
        for(Dictionary<String, String> player : availablePlayers){
            toPrint = toPrint + i + ". "+ ViewUtils.CreatePlayerString(player) + "\n";
            i++;
        }
        System.out.println(toPrint);
        messageCallBackToController.startGame();
    }

    @Override
    public void winGame() {
        String[] win = new String[]{
                "       _______  ",
                "    .-'       `-.",
                "  .'             '.",
                " /                 \\",
                " |   GAME OVER!    |",
                " |    _     _      |",
                "  \\  (o)___(o)   /",
                "   '.  \\_/ \\_/  .'",
                "     '-._____.-'",
                "         / / /",
                "       _/ / /",
                "      / _/ /",
                "     / / _/",
                "    /_/ /_/"
        };


    }


}
