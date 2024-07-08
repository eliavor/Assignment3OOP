package Model.tiles.units.players;

import Model.tiles.units.Unit;
import Model.tiles.units.enemies.Enemy;
import Model.utils.Position;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public abstract class Player extends Unit {

    public static final char SYMBOL = '@';

    protected static final int LEVEL_REQUIREMENT = 50;
    protected static final int HEALTH_GAIN = 10;
    protected static final int ATTACK_GAIN = 4;
    protected static final int DEFENSE_GAIN = 1;

    protected int level;
    protected int experience;

    public Player(int x, int y, String name, int health, int attack, int defense) {
        super(x, y, SYMBOL, name, health, attack, defense);
        level = 1;
        experience = 0;
    }

    public void addExperience(int experience){
        this.experience += experience;
        while(experience >= levelRequirement()){
            UponLevelUp();
        }
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
        // DO NOTHING
    }

    public void visit(Enemy enemy){
        if(enemy.isAlive()) battle(enemy);
    }


    public void battle(Enemy enemy) {
        super.battle(enemy);
        if(!enemy.isAlive()){
            addExperience(enemy.getExperience());
            enemy.onDeath();
        }
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

    @Override
    public void onDeath() {
        messageCallBackToView.UpdateTile('.', position.getX(), position.getY());
    }

    public abstract void OnAbilityCast(List<Enemy> enemies);

    protected void UponLevelUp(){
        this.experience -= levelRequirement();
        this.level++;
        int healthGain = healthGain();
        int attackGain = attackGain();
        int defenseGain = defenseGain();
        health.increaseMax(healthGain);
        health.heal();
        attack += attackGain;
        defense += defenseGain;
    }

    public abstract void OnGameTick();

    public abstract void OnAbilityCastAttempt(List<Enemy> enemies);

}
