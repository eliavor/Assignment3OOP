package Controller;

import Controller.utils.InputHandler;
import Controller.utils.LevelManager;
import Controller.utils.TileFactory;
import Model.game.Game;
import utilsGeneral.MessageCallBackToController;
import View.utils.View;
import Model.tiles.*;

import java.util.List;
import Model.tiles.units.players.Player;
import Model.tiles.units.enemies.Enemy;



public class Controller {
    private final LevelManager levelManager;
    private final InputHandler inputHandler;
    private MessageCallBackToController messageCallBackToController;
    private View view;
    private Game game;
    private int playerID;
    private List<Tile> tiles;
    private List<Enemy> enemies;
    private Player player;


    public Controller(String pathToLevels){

         levelManager = new LevelManager(pathToLevels);
         view = null;
         inputHandler = new InputHandler();


         messageCallBackToController = new MessageCallBackToController() {
             @Override
             public void nextTick() {
                 Controller.this.nextTick();
             }

             @Override
             public void startGame() {
                 Controller.this.startGame();
             }
         };
    }

    public void setView(View view){
        this.view = view;
        choosePlayer();

    }

    public void choosePlayer(){
        view.choosePlayer(TileFactory.ChoosePlayer());
        playerID = inputHandler.handleUserFirstInput();
        tiles = LevelManager.CreateTileList(playerID);
        enemies = LevelManager.GetEnenmyList();
        player = LevelManager.GetPlayer();
    }




    public void nextTick(){
        inputHandler.handleUserInput();
    }
    public MessageCallBackToController getMessageCallback(){
        return  messageCallBackToController;
    }


    public void startGame(){

        this.game = new Game( );
        nextLevel();
    }
    public void nextLevel(){
        game.nextLevel(tiles,enemies, player.position);
    }

}
