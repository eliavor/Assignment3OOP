package Model.board;

import Model.tiles.units.enenies.Enemy;
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
    private Tile player;
    private MessageCallBackToView messageCallBackToView;

    public Board(String path, MessageCallBackToView messageCallBack) {
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the levels file: " + e.getMessage());
        }
        messageCallBackToView = messageCallBack;
        enemies = new ArrayList<>();
        this.playerChoice = playerChoice;

        // Start the game


    }
    public void startGame(int playerChoice){
        //TODO: Implement this method
        InitializeBoard();
    }

    public void InitializeBoard() {
        String[] rows = content.split("\n");
        int height = rows.length;
        int width = rows[0].length();

        board = new Tile[height][width];
        messageCallBackToView.LoadMap(height, width);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char tileChar = rows[i].charAt(j);
                Tile tile;
                if(tileChar == '@'){
                    tile = TileFactory.createPlayer(playerChoice, j, i, tileChar, messageCallBackToView);
                    player = tile;
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

                break;
            case 'q':
                enemiesTick();
                break;
            default:
                break;
        }
    }

    public void enemiesTick(){
        for(Enemy enemy : enemies){
            enemy.Move();
        }
    }

}
