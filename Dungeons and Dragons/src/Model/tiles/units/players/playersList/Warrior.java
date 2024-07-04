package Model.tiles.units.players.playersList;

import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.Hashtable;

public class Warrior extends Player {

    private int abilityCoolDown;
    private int remainingCoolDown;

    public Warrior(int x, int y, String name, int health, int attack, int defense,int cooldown, MessageCallBackToView messageCallBackToView) {
        super(x, y, name, health, attack, defense, messageCallBackToView);
        this.abilityCoolDown = cooldown;
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
