package Model.game;

import Model.tiles.Tile;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import utilsGeneral.MessageCallBackModelToController;
import utilsGeneral.MessageCallBackToController;
import utilsGeneral.MessageCallBackToView;


import java.util.List;

public class Game {
    private Level level;
    private int currentLevel;
    private Player player;
    private MessageCallBackModelToController messageCallBackModelToController;
    private MessageCallBackToView messageCallBackToView;

    public Game(MessageCallBackModelToController messageCallBackModelToController, MessageCallBackToView messageCallBackToView) {
        currentLevel = 0;
        this.messageCallBackToView = messageCallBackToView;
        this.messageCallBackModelToController = messageCallBackModelToController;
    }

    public void firstTick(Player player){
        this.player = player;
        messageCallBackToView.ShowPlayerStats(player.toDict());
    }

    public void nextTick(Character c) {
        if (level.isLevelOver()) {
            currentLevel++;
            if (currentLevel == 6) {
                //end game
            } else {
                askNextLevel();
            }
        } else {
            level.nextTick(c);
        }
    }

    public void askNextLevel() {
        messageCallBackModelToController.askNextLevel();
    }

    public void nextLevel(List<Tile> tiles, List<Enemy> enemies, Player player) {
        this.player = player;
        level = new Level(tiles, enemies, player, messageCallBackToView);
        messageCallBackToView.ShowPlayerStats(player.toDict());
    }

    public boolean isGameOver(){
        if(currentLevel == 5 && level.isLevelOver()) return true;
        if(!player.isAlive()) return true;
        return false;
    }
}