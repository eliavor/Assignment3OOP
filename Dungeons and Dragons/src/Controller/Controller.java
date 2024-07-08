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
                nextLevel();
             }
         };
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
        this.game = new Game(messageCallBackModelToController, view.getMessageCallBack());

        nextLevel();
    }

    public void nextLevel(){
        if(levelManager.getCurerntLevel() == 4){
            view.winGame();
        }
        levelManager.nextLevel();
        tiles = levelManager.CreateTileList(playerID);

        enemies = levelManager.GetEnenmyList();
        player = levelManager.GetPlayer();

        view.getMessageCallBack().LoadMap(levelManager.getWidth(), levelManager.getHeight());
        game.nextLevel(tiles,enemies, player);

    }

    public MessageCallBackToController getMessageCallback() {
        return messageCallBackToController;
    }


}
