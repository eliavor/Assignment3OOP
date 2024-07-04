package Model.tiles.units.players.playersList;

import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.Hashtable;

public class Rogue extends Player {

    int cost;
    int currentEnergy;

    public Rogue(int x, int y, String name, int health, int attackPoints, int defensePoints,int cost, MessageCallBackToView messageCallBackToView) {
        super(x, y, name, health, attackPoints, defensePoints, messageCallBackToView);
        this.cost = cost;
        this.currentEnergy = 100;
    }

    public Dictionary<String, String> toDict() {
        Hashtable<String,String> dict = new Hashtable<>();
        dict.put("name", this.name);
        dict.put("healthCapacity", this.health.getCapacity() + "");
        dict.put("healthCurrent", this.health.getCurrent() + "");
        dict.put("attack",attack +"");
        dict.put("defense",defense +"");
        dict.put("level",level +"");
        dict.put("experience", experience +"");


        return dict;
    }
}
