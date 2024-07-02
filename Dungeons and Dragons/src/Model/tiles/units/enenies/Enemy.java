package Model.tiles.units.enenies;

import Model.tiles.units.Unit;
import Model.tiles.units.players.Player;

public class Enemy extends Unit {

    protected int experienceVlaue;
    public Enemy(char symbol, String name, int hitPoint, int attack, int defense, int experienceVlaue) {
        super(symbol, name, hitPoint, attack, defense);
        this.experienceVlaue = experienceVlaue;
    }

    public int getExperience(){
        return experienceVlaue;
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
}
