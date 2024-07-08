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
    private MessageCallBackModelToController messageCallBackModelToController;
    private MessageCallBackToView messageCallBackToView;

    public Game(MessageCallBackModelToController messageCallBackModelToController, MessageCallBackToView messageCallBackToView) {
        currentLevel = 0;
        this.messageCallBackToView = messageCallBackToView;
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
    public void advanceLevel(){

    public void nextLevel(List<Tile> tiles, List<Enemy> enemies, Player player) {
        level = new Level(tiles, enemies, player, messageCallBackToView);
    }
}
