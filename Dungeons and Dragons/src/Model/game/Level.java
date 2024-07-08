package Model.game;

import Model.tiles.Tile;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;

import java.util.List;

public class Level {


    private List<Tile> tiles;
    private List<Enemy> enemies;
    private Player player;
    public Board board;


    public Level(List<Tile> tiles, List<Enemy> enemies, Player player){
        this.tiles = tiles;
        this.enemies = enemies;
        this.player = player;

        initLevel();
    }

    public void initLevel(){
        board = new Board(tiles);

    }

    public void nextTick(char c){

        int playerX = player.position.getX();
        int playerY = player.position.getY();
        switch (c) {
            case 'w':
                player.interact(board.getTile(playerY - 1, playerX));
                break;
            case 'a':
                player.interact(board.getTile(playerY, playerX-1));
                break;
            case 's':
                player.interact(board.getTile(playerY +1, playerX));
                break;
            case 'd':
                player.interact(board.getTile(playerY , playerX + 1));
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

        player.OnGameTick();
        for(Enemy e: enemies){
            e.OnEnemyTurn(player);
        }

    }
}
