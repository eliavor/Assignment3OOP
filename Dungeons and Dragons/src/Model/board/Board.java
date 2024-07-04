package Model.board;

import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.TileFactory;
import utilsGeneral.MessageCallBackToView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Model.tiles.Tile;

public class Board {

    private  int playerChoice;
    private String content;
    private Tile[][] board;
    private List<Enemy> enemies;
    private Player player;
    private MessageCallBackToView messageCallBackToView;

    public Board(String path, MessageCallBackToView messageCallBack) {
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the levels file: " + e.getMessage());
        }
        messageCallBackToView = messageCallBack;
        enemies = new ArrayList<>();


        // Start the game


    }
    public void startGame(int playerChoice){
        this.playerChoice = playerChoice;
        InitializeBoard();

    }

    public void presentPlayerInfo(){

    }

    public void InitializeBoard() {
        String[] rows = content.split("\r\n");
        int height = rows.length;
        int width = rows[0].length();

        board = new Tile[height][width];
        messageCallBackToView.LoadMap(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char tileChar = rows[i].charAt(j);
                Tile tile;
                if(tileChar == '@'){
                    player = TileFactory.createPlayer(playerChoice, j, i, tileChar, messageCallBackToView);
                    tile = player;
                }

                else {
                    tile = TileFactory.createTile(j, i, tileChar, messageCallBackToView);

                    if (TileFactory.isEnemy(tileChar)) {
                        enemies.add((Enemy) tile);
                    }
                }

                board[i][j] = tile;
            }
        }
        messageCallBackToView.ShowPlayerStats(TileFactory.players.get(playerChoice));
    }

    public void handleUserInput(char c) {
        int playerX = player.position.getX();
        int playerY = player.position.getY();
        switch (c) {

            case 'w':
                player.interact(board[playerY - 1][playerX]);
                break;
            case 'a':
                player.interact(board[playerY][playerX - 1]);
                break;
            case 's':
                player.interact(board[playerY + 1][playerX]);
                break;
            case 'd':
                player.interact(board[playerY][playerX + 1]);
                break;
            case 'e':
                player.specialAbility();
                break;
            case 'q':
                enemiesTick();
                break;
            default:
                break;
        }
        enemiesTick();
        messageCallBackToView.ShowPlayerStats(TileFactory.players.get(playerChoice));
    }

    public void enemiesTick(){
        for(Enemy enemy : enemies){
            enemy.Move();
        }
    }

    public void presentPlayerInfo() {
        messageCallBackToView.initiateGame(TileFactory.ChoosePlayer());
    }
}
