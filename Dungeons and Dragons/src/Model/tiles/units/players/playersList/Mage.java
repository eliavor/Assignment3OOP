package Model.tiles.units.players.playersList;

import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.Hashtable;

public class Mage extends Player {


    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitCount;
    private int abilityRange;

    public Mage (int x, int y, String name, int health, int attackPoints, int defensePoints, int manaPool, int manaCost, int spellPower, int hitCount, int abilityRange, MessageCallBackToView messageCallBackToView){
        super(x, y, name, health, attackPoints, defensePoints, messageCallBackToView);
        this.manaPool = manaPool;
        this.manaCost = manaCost;
        this.currentMana = manaPool;
        this.spellPower = spellPower;
        this.hitCount = hitCount;
        this.abilityRange = abilityRange;
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
