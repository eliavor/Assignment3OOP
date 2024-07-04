package Model.tiles;

import Model.tiles.units.Unit;
import Model.utils.Position;
import utilsGeneral.MessageCallBackToView;

public abstract class Tile {

    public Position position;
    protected char symbol;

    protected MessageCallBackToView messageCallBackToView;

    public Tile(char symbol,int x, int y, MessageCallBackToView messageCallBackToView) {
        this.symbol = symbol;
        this.messageCallBackToView = messageCallBackToView;
        this.position = new Position(x, y);
        messageCallBackToView.UpdateTile(this.symbol, this.position.getX(), this.position.getY());

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
        Position temp = this.position;
        this.position = tile.position;
        tile.position = temp;


        symbol = '.';
        tile.symbol = '@';


        messageCallBackToView.UpdateTile('@', this.position.getX(), this.position.getY());
        messageCallBackToView.UpdateTile('.', tile.position.getX(), tile.position.getY());
    }


    public abstract void interact(Tile tile);

}
