package Controller;

import Controller.utils.InputHandler;
import Controller.initializers.LevelInitializer;
import Controller.utils.TileFactory;
import Model.game.Game;
import utilsGeneral.MessageCallBackModelToController;
import utilsGeneral.MessageCallBackToController;
import View.utils.View;
import Model.tiles.*;

import java.util.List;
import Model.tiles.units.players.Player;
import Model.tiles.units.enemies.Enemy;



public class Controller {
    private final LevelInitializer levelManager;
    private final InputHandler inputHandler;
    private MessageCallBackToController messageCallBackToController;
    private MessageCallBackModelToController messageCallBackModelToController;
    private View view;
    private Game game;
    private int playerID;
    private List<Tile> tiles;
    private List<Enemy> enemies;
    private Player player;


    public Controller(String pathToLevels){

         levelManager = new LevelInitializer(pathToLevels);
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

         messageCallBackModelToController = new MessageCallBackModelToController() {
             @Override
             public void askNextLevel(){

             }
         };
    }

    public MessageCallBackToController getMessageCallback(){
        return  messageCallBackToController;
    }

    public void setView(View view){
        this.view = view;
        view.choosePlayer(TileFactory.choosePlayer());
    }

    public void nextTick(){
        char c = inputHandler.handleUserInput();
        if(!game.isGameOver()){
            game.nextTick(c);
        }
        //TODO: is it good?
    }

    public void startGame(){
        playerID = inputHandler.handleUserFirstInput();
        levelManager.StartGame(playerID);
        tiles = levelManager.CreateTileList(playerID);
        enemies = levelManager.GetEnenmyList();
        player = levelManager.GetPlayer();
        this.game = new Game(tiles, enemies,  player);
    }

    public void nextLevel(){
        levelManager.nextLevel();
        tiles = levelManager.CreateTileList(playerID);
        enemies = levelManager.GetEnenmyList();
        player = levelManager.GetPlayer();
        game.nextLevel(tiles,enemies, player);
    }

}
