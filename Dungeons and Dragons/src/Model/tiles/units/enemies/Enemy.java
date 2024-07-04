package Model.tiles.units.enemies;

import Model.tiles.units.Unit;
import Model.tiles.units.players.Player;
import utilsGeneral.MessageCallBackToView;

public class Enemy extends Unit {

    protected int experienceValue;
    public Enemy(int x, int y, String name, char symbol, int health , int attack, int defense, int experienceValue, MessageCallBackToView messageCallBackToView) {
        super(x, y, symbol, name, health, attack, defense, messageCallBackToView);
        this.experienceValue = experienceValue;
    }

    public int getExperience(){
        return experienceValue;
    }

    public void onDeath(){
        //TODO: implement onDeath
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    public void visit(Player p){
        battle(p);
        if(!p.isAlive()){
            p.onDeath();
        }
    }

    public void visit(Enemy enemy){
        //DO NOTHING
    }

    public void Move(){

    }
}
