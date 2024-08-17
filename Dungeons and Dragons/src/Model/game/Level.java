package Model.game;

import Model.tiles.Tile;
import Model.tiles.units.Unit;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import utilsGeneral.MessageCallBackTileToLevel;
import utilsGeneral.MessageCallBackToView;

import java.util.List;

public class Level {


    private List<Tile> tiles;
    private List<Unit> enemies;
    private Player player;
    public Board board;
    private MessageCallBackToView messageCallBackToView;
    private MessageCallBackTileToLevel messageCallBackTileToLevel;

    public Level(List<Tile> tiles, List<Unit> enemies, Player player, MessageCallBackToView messageCallBackToView){
        messageCallBackTileToLevel = new MessageCallBackTileToLevel() {
            @Override
            public void enemyDead(Enemy enemy) {
                enemies.remove(enemy);
                board.unitDead(enemy.position, messageCallBackToView);
            }

            @Override
            public void playerDead(Player player) {
                board.unitDead(player.position, messageCallBackToView);
            }

            @Override
            public void swapPosition(Tile t1, Tile t2) {
                board.swapPosition(t1, t2);
            }
        };


        board = new Board(tiles, messageCallBackTileToLevel, messageCallBackToView);
        this.enemies = enemies;
        this.player = player;
        this.messageCallBackToView = messageCallBackToView;



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
                player.OnAbilityCastAttempt(enemies);
                break;
            case 'q':
                // do nothing
                break;
            default:
                break;
        }

        player.OnGameTick(  );
        for(Unit e: enemies){
            Position p = e.OnEnemyTurn(player);
            if(p!=null && p.compareTo(e.position) != 0){
                e.interact(board.getTile(p.getY(), p.getX()));
            }
        }
        messageCallBackToView.ShowPlayerStats(player.toDict());


    }

    public boolean isLevelOver() {
        return !player.isAlive() || enemies.isEmpty();
    }
}
