package Model.tiles;

import Model.tiles.units.Unit;
import utilsGeneral.MessageCallBackToView;

public class Empty extends Tile{

    public static final char SYMBOL = '.';

    public Empty(int x, int y, MessageCallBackToView messageCallBackToView) {
        super(SYMBOL, x, y, messageCallBackToView);
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);

    }

    @Override
    public void interact(Tile tile) {

    }
}
