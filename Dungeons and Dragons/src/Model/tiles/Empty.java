package Model.tiles;

import Model.tiles.units.Unit;

public class Empty extends Tile{

    public static final char SYMBOL = '.';

    public Empty() {
        super(SYMBOL);
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);

    }
}
