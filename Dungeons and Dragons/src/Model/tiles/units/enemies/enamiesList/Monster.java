package Model.tiles.units.enemies.enamiesList;

import Model.tiles.units.enemies.Enemy;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import Model.utils.generators.RandomGenerator;
import utilsGeneral.MessageCallBackToView;

import java.util.Dictionary;
import java.util.Hashtable;

public class Monster extends Enemy {

    private int visionRange;

    public Monster(int x, int y, String name, char symbol, int health, int attack, int defense, int visionRange, int experienceValue, MessageCallBackToView messageCallBackToView) {
        super(x, y, name, symbol, health, attack, defense, experienceValue, messageCallBackToView);
        this.visionRange = visionRange;
    }

    @Override
    public Position OnEnemyTurn(Player player) {

        if(isAlive()) {
            if (this.position.distance(player.position) < visionRange) {
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

    @Override
    public Dictionary<String, String> toDict() {
        Hashtable<String,String> dict = new Hashtable<>();
        dict.put("name", this.name);
        dict.put("healthCapacity", this.health.getCapacity() + "");
        dict.put("healthCurrent", this.health.getCurrent() + "");
        dict.put("attack",attack +"");
        dict.put("defense",defense +"");
        dict.put("experienceValue",experienceValue +"");
        dict.put("visionRange", visionRange +"");

        return dict;
    }
}
