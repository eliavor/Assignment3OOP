package Model.tiles;

import Model.tiles.units.Unit;
import Model.utils.Position;

public abstract class Tile {

    public Position position;
    protected char symbol;

    public Tile(char symbol) {
        this.symbol = symbol;
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
    }


    public abstract void interact(Tile tile);

}
