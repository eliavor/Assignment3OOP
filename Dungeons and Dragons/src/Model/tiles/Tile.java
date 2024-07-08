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
        messageCallBackToView.UpdateTile(this.symbol, this.position.getX(), this.position.getY());
    }

    public void setMessageCallBackTileToLevel(MessageCallBackTileToLevel messageCallBackTileToLevel) {
        this.messageCallBackTileToLevel = messageCallBackTileToLevel;
    }

    public void initialize(Position position) {
        this.position = position;
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

}
