package Model.tiles.units;

import Model.tiles.Empty;
import Model.tiles.Tile;
import Model.tiles.Wall;
import Model.tiles.units.enenies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Health;
import Model.utils.Position;
import Model.utils.generators.Generator;

public abstract class Unit extends Tile {

    protected String name;
    protected Health health;
    protected int attack;
    protected int defense;

    protected Generator generator;


    public Unit(char symbol, String name, int hitPoint, int attack, int defense) {
        super(symbol);

        this.name = name;
        this.health = new Health(hitPoint);
        this.attack = attack;
        this.defense = defense;
    }

    public void initialize(Position p ,Generator generator) {
        super.initialize(p);
        this.generator = generator;
    }

    public int attack(){
        return generator.generate(attack);
    }

    public int defend(){
        return generator.generate(defense);
    }

    public boolean isAlive() {
        return health.getCurrent() > 0;
    }

    public void battle(Unit enemy) {
        int attack = this.attack();
        int defense = enemy.defend();
        int damageTaken = enemy.health.takeDamage(attack - defense);

    }

    public void interact(Tile tile) {
        tile.accept(this);
    }

    public void visit(Empty e){
        swapPosition(e);
    }

    public void visit(Wall W){
        //DO NOTHING
    }

    public abstract void visit(Player p);

    public abstract void visit(Enemy e);

    public abstract void onDeath();

}
