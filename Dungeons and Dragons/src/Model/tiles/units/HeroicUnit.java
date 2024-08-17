package Model.tiles.units;

import Model.tiles.units.enemies.Enemy;

import java.util.List;

public interface HeroicUnit {
    public void OnAbilityCastAttempt(List<Unit> enemies);
}
