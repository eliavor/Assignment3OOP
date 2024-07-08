package Controller.initializers;

import Controller.utils.TileFactory;
import Model.tiles.Empty;
import Model.tiles.Tile;
import Model.tiles.Wall;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelInitializer {

    private List<String> levelPaths;
    private int currentLevel;
    private final String directoryPath;

    private List<Tile> tiles;
    private List<Enemy> enemies;
    private Player player;
    private int playerID;

    private  int width;
    private  int height;

    public LevelInitializer(String directoryPath) {
        this.directoryPath = directoryPath;
        currentLevel = 0;
        player = null;
        loadAllLevels();
    }

    public void loadAllLevels(){
        File levelsDir = new File(directoryPath);
        if (!levelsDir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path.");
        }

        File[] levelFiles = levelsDir.listFiles((dir, name) -> name.endsWith(".txt"));
        if (levelFiles == null || levelFiles.length == 0) {
            throw new IllegalArgumentException("No level files found in the directory.");
        }

        Arrays.sort(levelFiles, (f1, f2) -> {
            String name1 = f1.getName().replaceAll("\\D+", "");
            String name2 = f2.getName().replaceAll("\\D+", "");
            return Integer.parseInt(name1) - Integer.parseInt(name2);
        });

        levelPaths = new ArrayList<>();
        for (File file : levelFiles) {
            levelPaths.add(file.getAbsolutePath());
        }
    }

    public void initializeLevel() {
        tiles = new ArrayList<>();
        enemies = new ArrayList<>();
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(levelPaths.get(currentLevel-1)));
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the levels file: " + e.getMessage());
        }
        width = lines.get(0).length();
        height = lines.size();
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                char c = lines.get(i).charAt(j);
                Tile tile;
                switch (c) {
                    case '#':
                        tile = TileFactory.createWall(j, i);
                        break;
                    case '.':
                        tile = TileFactory.createEmpty(j, i);
                        break;
                    case '@':
                        if(player == null){
                            player = TileFactory.createPlayer(playerID, j, i);
                            tile = player;
                        }
                        else{
                            player = TileFactory.createPlayer(j, i);
                            tile = player;
                        }
                        break;

                    default:
                        Enemy enemy = TileFactory.createEnemy(c, j, i);
                        tile = enemy;
                        enemies.add(enemy);
                        break;
                }
                tiles.add(tile);
            }
        }
    }

    public  void StartGame(int playerID) {
        this.playerID = playerID;
    }

    public List<Tile> CreateTileList(int playerID) {
        return tiles;
    }

    public List<Enemy> GetEnenmyList() {
        return enemies;
    }

    public Player GetPlayer() {
        return player;
    }

    public void nextLevel() {
        if (currentLevel < levelPaths.size()) {
            currentLevel++;
            initializeLevel();
        } else {
            System.out.println("No more levels.");

        }
    }


    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public int getCurerntLevel(){
        return currentLevel;
    }

}
