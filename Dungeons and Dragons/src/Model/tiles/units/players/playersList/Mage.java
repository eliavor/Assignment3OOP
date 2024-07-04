package Model.tiles.units.players.playersList;

import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

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


}
