package Model.tiles.units.players;

import utilsGeneral.MessageCallBackToView;

public class Warrior extends Player{

    private int abilityCoolDown;
    private int remainingCoolDown;

    public Warrior(int x, int y, String name, int health, int attack, int defense,int cooldown, MessageCallBackToView messageCallBackToView) {
        super(x, y, name, health, attack, defense, messageCallBackToView);
        this.abilityCoolDown = cooldown;
    }

}
