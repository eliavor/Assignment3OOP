package Model.board;

import Controller.LevelManager;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.TileFactory;
import utilsGeneral.MessageCallBackToView;

import java.util.ArrayList;
import java.util.List;

import Model.tiles.Tile;

public class Board {

    private int playerChoice;
    private String content;
    private Tile[][] board;
    private List<Enemy> enemies;
    private Player player;
    private MessageCallBackToView messageCallBackToView;
    private LevelManager levelManager;

    public Board(String path, MessageCallBackToView messageCallBack) {
        this.levelManager = new LevelManager(path);
        this.messageCallBackToView = messageCallBack;
        this.enemies = new ArrayList<>();
        this.content = levelManager.getNextLevelContent();
        if (this.content == null) {
            throw new RuntimeException("No levels available to load.");
        }
    }

    public void startGame(int playerChoice) {
        this.playerChoice = playerChoice;
        initializeBoard();
    }

    private void initializeBoard() {
        String[] rows = content.split("\r\n");
        int height = rows.length;
        int width = rows[0].length();

        board = new Tile[height][width];
        messageCallBackToView.LoadMap(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char tileChar = rows[i].charAt(j);
                Tile tile;
                if (tileChar == '@') {
                    player = TileFactory.createPlayer(playerChoice, j, i, tileChar, messageCallBackToView);
                    tile = player;
                } else {
                    tile = TileFactory.createTile(j, i, tileChar, messageCallBackToView);
                    if (TileFactory.isEnemy(tileChar)) {
                        enemies.add((Enemy) tile);
                    }
                }
                board[i][j] = tile;
            }
        }
        messageCallBackToView.ShowPlayerStats(player.toDict());
    }

    private Tile searchPosition(int y, int x) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i].position.getX() == x && board[j][i].position.getY() == y) {
                    return board[j][i];
                }
            }
        }
        return null;
    }

    public void handleUserInput(char c) {
        int playerX = player.position.getX();
        int playerY = player.position.getY();
        switch (c) {
            case 'w':
                player.interact(searchPosition(playerY - 1, playerX));
                break;
            case 'a':
                player.interact(searchPosition(playerY, playerX - 1));
                break;
            case 's':
                player.interact(searchPosition(playerY + 1, playerX));
                break;
            case 'd':
                player.interact(searchPosition(playerY, playerX + 1));
                break;
            case 'e':
                player.OnAbilityCast(enemies);
                break;
            case 'q':
                // do nothing
                break;
            default:
                break;
        }
        enemiesTick();
        messageCallBackToView.ShowPlayerStats(player.toDict());

        // Check if all enemies are defeated to proceed to the next level
        if (enemies.isEmpty()) {
            content = levelManager.getNextLevelContent();
            if (content != null) {
                initializeBoard();
            } else {
                messageCallBackToView.abilityErrorMessage("Congratulations! You've completed all levels!");
            }
        }
    }

    public void enemiesTick() {
        for (Enemy enemy : enemies) {
            enemy.OnEnemyTurn(player);
        }
    }

    public void presentPlayerInfo() {
        messageCallBackToView.initiateGame(TileFactory.ChoosePlayer());
    }
}
