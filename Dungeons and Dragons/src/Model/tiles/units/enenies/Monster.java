package Model.tiles.units.enenies;

import utilsGeneral.MessageCallBackToView;

public class Monster extends Enemy{

    private int visionRange;
    public Monster(String name, char symbol, int health, int attack, int defense, int visionRange, int experienceValue, MessageCallBackToView messageCallBackToView) {
        super(name, symbol, health, attack, defense, experienceValue, messageCallBackToView);
        this.visionRange = visionRange;
    }


}
