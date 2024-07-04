package Model.tiles.units.enemies.enamiesList;

import Model.tiles.units.enemies.Enemy;
import utilsGeneral.MessageCallBackToView;

public class Monster extends Enemy {

    private int visionRange;

    public Monster(int x, int y, String name, char symbol, int health, int attack, int defense, int visionRange, int experienceValue, MessageCallBackToView messageCallBackToView) {
        super(x, y, name, symbol, health, attack, defense, experienceValue, messageCallBackToView);
        this.visionRange = visionRange;
    }


}
