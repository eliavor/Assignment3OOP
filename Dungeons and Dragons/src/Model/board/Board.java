package Model.board;

import Model.tiles.units.enenies.Enemy;
import Model.utils.TileFactory;
import utilsGeneral.MessageCallBackToView;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Model.tiles.Tile;

public class Board {

    private String content;
    private Tile[][] board;
    private List<Enemy> enemies;
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
                Tile tile = TileFactory.createTile(tileChar, messageCallBackToView);
                board[i][j] = tile;
                if (TileFactory.isEnemy(tileChar)) {
                    enemies.add((Enemy) tile);
                }
            }
        }
    }

    public void handleUserInput(char c) {

    }
}
