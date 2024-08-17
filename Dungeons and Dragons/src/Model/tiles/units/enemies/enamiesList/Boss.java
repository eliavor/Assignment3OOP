package Model.tiles.units.enemies.enamiesList;

import Model.tiles.units.HeroicUnit;
import Model.tiles.units.Unit;
import Model.tiles.units.enemies.enamiesList.Monster;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import Model.utils.generators.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Monster implements HeroicUnit{

    protected int abilityFrequency;
    protected int combatTicks;
    protected int visionRange;

    public Boss(int x, int y, String name, char symbol, int health, int attack, int defense, int visionRange, int experienceValue, int abilityFrequency) {
        super(x, y, name, symbol, health, attack, defense, visionRange,  experienceValue);

        this.combatTicks = 0;
        this.abilityFrequency = abilityFrequency;
        this.visionRange = visionRange;
    }

    @Override
    public Position OnEnemyTurn(Player player){
        if(isAlive()) {
            if (this.position.distance(player.position) < visionRange) {
                if(combatTicks ==abilityFrequency) {
                    combatTicks = 0;
                    List<Unit> list = new ArrayList<>();
                    list.add(player);
                    OnAbilityCastAttempt(list);
                    return position;
                }
                else {
                    int dx = this.position.getX() - player.position.getX();
                    int dy = this.position.getY() - player.position.getY();
                    if (Math.abs(dx) > Math.abs(dy)) {
                        if (dx > 0) {
                            return new Position(this.position.getX() - 1, this.position.getY());
                        } else {
                            return new Position(this.position.getX() + 1, this.position.getY());
                        }
                    } else {
                        if (dy > 0) {
                            return new Position(this.position.getX(), this.position.getY() - 1);
                        } else {
                            return new Position(this.position.getX(), this.position.getY() + 1);
                        }
                    }
                }
            } else {
                RandomGenerator RG = new RandomGenerator();
                int whereToGo = RG.generate(4);
                return switch (whereToGo) {
                    case (0) -> new Position(this.position.getX() - 1, this.position.getY());
                    case (1) -> new Position(this.position.getX() + 1, this.position.getY());
                    case (2) -> new Position(this.position.getX(), this.position.getY() - 1);
                    case (3) -> new Position(this.position.getX(), this.position.getY() + 1);
                    default -> null;
                };
            }
        }
        else{
            return position;
        }
    }

    public void OnAbilityCastAttempt(List<Unit> enemies){
        Unit Player = enemies.getFirst();
        int def = Player.defend();
        Player.health.takeDamage(attack - def);
        messageCallBackToView.ShowBattleInfo(toDict(), Player.toDict(),attack, def);
        if(!Player.isAlive()){
            Player.onDeath();
        }
    }

}
