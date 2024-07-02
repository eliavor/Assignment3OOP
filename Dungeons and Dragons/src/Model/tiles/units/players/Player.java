package Model.tiles.units.players;

import Model.tiles.units.Unit;
import Model.tiles.units.enenies.Enemy;

public class Player extends Unit {

    public static final char SYMBOL = '@';

    protected static final int LEVEL_REQUIREMENT = 50;
    protected static final int HEALTH_GAIN = 10;
    protected static final int ATTACK_GAIN = 4;
    protected static final int DEFENSE_GAIN = 1;

    protected int level;

    protected int experience;

    public Player(String name, int hitPoint, int attack, int defense) {
        super(SYMBOL, name, hitPoint, attack, defense);
        level = 1;
        experience = 0;
    }


    public void addExperience(int experience){
        this.experience += experience;
        while(experience >= levelRequirement()){
            levelUp();
        }
    }
    public void levelUp(){
        this.experience -= 50*level;
        this.level++;
        int healthGain = healthGain();
        int attackGain = attackGain();
        int defenseGain = defenseGain();
        health.increaseMax(healthGain);
        health.heal();
        attack += attackGain;
        defense += defenseGain;
    }

    protected int levelRequirement(){
        return LEVEL_REQUIREMENT * level;
    }

    protected int healthGain(){
        return HEALTH_GAIN * level;
    }

    protected int attackGain(){
        return ATTACK_GAIN * level;
    }

    protected int defenseGain() {
        return DEFENSE_GAIN * level;
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);

    }

    public void visit(Player p){
        //DO NOTHING
    }

    public void visit(Enemy enemy){
        battle(enemy);
        if(!enemy.isAlive()){
            addExperience(enemy.getExperience());
            enemy.onDeath();
        }
    }

    @Override
    public void onDeath() {
        //TODO: implement onDeath
    }

}
