package Model.game;

import Model.tiles.Tile;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import utilsGeneral.MessageCallBackToController;

import java.util.List;

public class Game {
    private Level level;
    private int currentLevel;
    private MessageCallBackModelToController messageCallBackModelToController;

    public Game(List<Tile> tiles, List<Enemy> enemies, Player player ){
        currentLevel = 0;
    }
    public void nextTick(){
        if(level.isLevelOver()){
            currentLevel++;
            if(currentLevel == 6){
                //end game
            }
            else{
                advanceLevel();
            }
        }
        else{
            level.nextTick();
        }
    }
    public void advanceLevel(){

    }
}
