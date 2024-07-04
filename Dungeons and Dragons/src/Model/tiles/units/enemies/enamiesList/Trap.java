package Model.tiles.units.enemies.enamiesList;

import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.Hashtable;

public class Trap extends Enemy {

    private int visibilityTime;
    private int invisibilityTime;
    private int tickCount;
    private boolean isVisible;

    public Trap(int x, int y, String name, char symbol, int health , int attack, int defense, int experienceValue, int visibilityTime, int invisibilityTime, MessageCallBackToView messageCallBackToView) {
        super( x, y, name, symbol, health, attack, defense, experienceValue,messageCallBackToView);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.tickCount = 0;//
        this.isVisible = true;
    }

    @Override
    public Position OnEnemyTurn(Player player) {
        tickCount++;
        if(isVisible && tickCount >= visibilityTime){
            isVisible = false;
            messageCallBackToView.UpdateTile('.',this.position.getX(), this.position.getY());
            tickCount = 0;
        }
        if(!isVisible && tickCount >= invisibilityTime){
            messageCallBackToView.UpdateTile(symbol,this.position.getX(), this.position.getY());
            isVisible = true;
            tickCount = 0;
        }
        if(this.position.distance(player.position) < 2){
            battle(player);
        }
        return null;
    }
    public Dictionary<String, String> toDict() {
        Hashtable<String,String> dict = new Hashtable<>();
        dict.put("name", this.name);
        dict.put("healthCapacity", this.health.getCapacity() + "");
        dict.put("healthCurrent", this.health.getCurrent() + "");
        dict.put("attack",attack +"");
        dict.put("defense",defense +"");


        return dict;
    }
}
