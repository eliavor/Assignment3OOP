package Model.tiles.units.players.playersList;

import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

public class Rogue extends Player {

    int cost;
    int currentEnergy;

    public Rogue(int x, int y, String name, int health, int attackPoints, int defensePoints,int cost, MessageCallBackToView messageCallBackToView) {
        super(x, y, name, health, attackPoints, defensePoints, messageCallBackToView);
        this.cost = cost;
        this.currentEnergy = 100;
    }
}
