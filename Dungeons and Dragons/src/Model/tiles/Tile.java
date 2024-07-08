package Model.tiles;

import Model.tiles.units.Unit;
import Model.utils.Position;
import utilsGeneral.MessageCallBackTileToLevel;
import utilsGeneral.MessageCallBackToView;

public abstract class Tile {

    public Position position;
    protected char symbol;
    protected MessageCallBackTileToLevel messageCallBackTileToLevel;

    protected MessageCallBackToView messageCallBackToView;

    public Tile(char symbol,int x, int y) {
        this.symbol = symbol;
        this.position = new Position(x, y);

    }



    public void setMessageCallBackTileToLevel(MessageCallBackTileToLevel messageCallBackTileToLevel) {
        this.messageCallBackTileToLevel = messageCallBackTileToLevel;
    }

    public void setMessageCallBackToView(MessageCallBackToView messageCallBackToView) {
        this.messageCallBackToView = messageCallBackToView;
    }

    public void initialize(MessageCallBackToView messageCallBackToView, MessageCallBackTileToLevel messageCallBackTileToLevel) {
        this.messageCallBackTileToLevel = messageCallBackTileToLevel;
        this.messageCallBackToView = messageCallBackToView;
        messageCallBackToView.UpdateTile(symbol, position.getX(), position.getY());
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    public abstract void accept(Unit unit);

    public void swapPosition(Tile tile) {
        messageCallBackTileToLevel.swapPosition(this, tile);


        messageCallBackToView.UpdateTile(this.symbol, this.position.getX(), this.position.getY());
        messageCallBackToView.UpdateTile('.', tile.position.getX(), tile.position.getY());
    }


    public abstract void interact(Tile tile);

    public void setPosition(Position p) {
        position = p;
        messageCallBackToView.UpdateTile(symbol, position.getX(), position.getY());
    }
}
