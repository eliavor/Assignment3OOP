package Tests;

import Model.tiles.units.enemies.enamiesList.Boss;
import Model.tiles.units.enemies.enamiesList.Monster;
import Model.tiles.units.enemies.enamiesList.Trap;
import Model.tiles.units.players.Player;
import Model.tiles.units.players.playersList.Hunter;
import Model.tiles.units.players.playersList.Mage;
import Model.tiles.units.players.playersList.Rogue;
import Model.tiles.units.players.playersList.Warrior;
import Model.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlayerTests {


    private Rogue rogue;
    private Mage mage;
    private Warrior warrior;
    private Hunter hunter;


    @BeforeEach
    void setUp() {
        mage = new Mage(0, 0, "Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4);
        warrior = new Warrior(0, 0, "The Hound", 400, 20, 6, 5);
        hunter = new Hunter(0,0,"ygritte", 220,30,2,6,10);
        rogue = new Rogue(0, 0, "Bronn", 250, 35, 3, 50);
    }

    @Test
    void testMageInitialization() {
        assertEquals(new Position(0,0), mage.position);
        assertEquals(250, mage.health.getCurrent());
    }

    @Test
    void testMageDeath() {
        mage.health.takeDamage(1500);
        assertFalse(mage.isAlive());
    }



    @Test
    void testRogueInitialization() {
        assertEquals(new Position(0,0), rogue.position);
        assertEquals(250, rogue.health.getCurrent());
    }

    @Test
    void testRogueDeath() {
        rogue.health.takeDamage(1500);
        assertFalse(rogue.isAlive());
    }



    @Test
    void testHunterInitialization() {
        assertEquals(new Position(0,0), hunter.position);
        assertEquals(220, hunter.health.getCurrent());
    }

    @Test
    void testHunterDeath() {
        hunter.health.takeDamage(1500);
        assertFalse(hunter.isAlive());
    }



    @Test
    void testWarriorInitialization() {
        assertEquals(new Position(0,0), warrior.position);
        assertEquals(400, warrior.health.getCurrent());
    }

    @Test
    void testWarriorDeath() {
        warrior.health.takeDamage(1500);
        assertFalse(warrior.isAlive());
    }





    private Monster monster;
    private Boss boss;
    private Trap trap;


    @BeforeEach
    void setUp2() {
        monster = new Monster(0, 0, "Giant-Wright", 'g', 1500, 100, 40, 3, 500);
        boss = new Boss(3, 5, "The Mountain", 'M', 1000, 60, 25, 6, 500,5);
        trap = new Trap(4, 10, "Death Trap", 'D', 500, 100, 20, 5, 10, 250);
    }

    @Test
    void testMonsterInitialization() {
        assertEquals(new Position(0,0), monster.position);
        assertEquals(1500, monster.health.getCurrent());
    }


    @Test
    void testMonsterDeath() {
        monster.health.takeDamage(1500);
        assertFalse(monster.isAlive());
    }




    @Test
    void testBossInitialization() {
        assertEquals(new Position(3,5), boss.position);
        assertEquals(1000, boss.health.getCurrent());
    }


    @Test
    void testBossDeath() {
        boss.health.takeDamage(1500);
        assertFalse(boss.isAlive());
    }





    @Test
    void testTrapInitialization() {
        assertEquals(new Position(4,10), trap.position);
        assertEquals(500, trap.health.getCurrent());
    }


    @Test
    void testTrapDeath() {
        trap.health.takeDamage(1500);
        assertFalse(trap.isAlive());
    }

}
