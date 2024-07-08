package Model.game;
import java.util.TreeMap;
import Controller.initializers.LevelInitializer;
import Model.tiles.Empty;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import Controller.utils.TileFactory;
import utilsGeneral.MessageCallBackTileToLevel;
import utilsGeneral.MessageCallBackToView;

import java.util.ArrayList;
import java.util.List;

import Model.tiles.Tile;

public class Board {

    private TreeMap<Position, Tile> board;

    public Board(List<Tile> tiles, MessageCallBackTileToLevel messageCallBackTileToLevel, MessageCallBackToView messageCallBackToView) {
        board = new TreeMap<>();
        for (Tile tile : tiles) {
            tile.initialize(messageCallBackToView, messageCallBackTileToLevel);
            board.put(tile.position, tile);
        }
    }

    public void swapPosition(Tile tile1, Tile tile2){
        Position p1 = tile1.position;
        Position p2 = tile2.position;

        board.put(p1, tile2);
        board.put(p2, tile1);

        tile1.setPosition(p2);
        tile2.setPosition(p1);


    }

    public void unitDead(Position position, MessageCallBackToView messageCallBack){
        Tile tile = new Empty(position.getX(),position.getY());
        tile.setMessageCallBackToView(messageCallBack);
        board.put(position,tile);
    }

    public Tile getTile(int y, int x){
        return board.get(new Position(x, y));
    }
}
