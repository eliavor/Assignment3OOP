package utilsGeneral;

import Model.tiles.Tile;
import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;

public interface MessageCallBackTileToLevel {
    public void enemyDead(Enemy enemy);
    public void swapPosition(Tile t1, Tile t2);
    public void playerDead(Player player);
}
