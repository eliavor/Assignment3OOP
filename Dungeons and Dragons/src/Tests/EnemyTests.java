package Tests;

import Model.tiles.units.enemies.enamiesList.Boss;
import Model.tiles.units.enemies.enamiesList.Trap;
import Model.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;
import Model.tiles.units.enemies.enamiesList.Monster;


public class EnemyTests {



    private Monster monster;
    private Boss boss;
    private Trap trap;


    @BeforeEach
    void setUp() {
        monster = new Monster(0, 0, "Giant-Wright", 'g', 1500, 100, 40, 3, 500);
        boss = new Boss(3, 5, "The Mountain", 'M', 1000, 60, 25, 6, 500,5);
        trap = new Trap(4, 10, "Death Trap", 'D', 500, 100, 20, 5, 10, 250);
    }

    @Test
    void testMonsterInitialization() {
        assertEquals(new Position(0,0), monster.position);
        assertEquals(200, monster.health.getCurrent());
    }


    @Test
    void testMonsterDeath() {
        monster.health.takeDamage(1500);
        assertFalse(monster.isAlive());
    }




    @Test
    void testBossInitialization() {
        assertEquals(new Position(3,5), boss.position);
        assertEquals(200, boss.health.getCurrent());
    }


    @Test
    void testBossDeath() {
        boss.health.takeDamage(1500);
        assertFalse(boss.isAlive());
    }





    @Test
    void testTrapInitialization() {
        assertEquals(new Position(4,10), trap.position);
        assertEquals(200, trap.health.getCurrent());
    }


    @Test
    void testTrapDeath() {
        trap.health.takeDamage(1500);
        assertFalse(trap.isAlive());
    }









}
