package Model.game;

import Model.tiles.Tile;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import utilsGeneral.MessageCallBackToController;

import java.util.List;

public class Game {

    private List<Tile> tiles;
    private List<Enemy> enemies;
    private Player player;

    private Level level;
    private int currentLevel;
    private final int LEVELCOUNT = 4;


    //private MessageCallBackModelToController messageCallBackModelToController;

    public Game(List<Tile> tiles, List<Enemy> enemies, Player payer ){
        this.tiles = tiles;
        this.enemies = enemies;
        this.player = payer;
        currentLevel = 0;
        level = new Level(tiles, enemies, player);

    }

    public void nextTick(char c){
        if(!level.isLevelOver()){

        }
    }

    public void advanceLevel(){

    }

    public boolean isGameOver(){
        return player.isAlive();
    }

    public void nextLevel(List<Tile> tiles, List<Enemy> enemies, Player player){

    }
}
