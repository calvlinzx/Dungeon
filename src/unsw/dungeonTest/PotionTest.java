package unsw.dungeonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

class PotionTest {

	Dungeon dungeon;
	Entity potion;
	
	@BeforeEach
	void init() {
		dungeon = new Dungeon(5, 5);
		potion = new Sword(1, 1);
		dungeon.addEntity(potion);
	}
	
	@Test
	void SwordCanBeStepOn() {
		assertTrue(potion.getX() == 1);
		assertTrue(potion.getY() == 1);
		assertTrue(dungeon.canGoThere(1, 1));
	}
	
	@Test
	void SwordHasFiveHits() {
		assertTrue(((Sword) potion).getHits() == 5);
	}
	
	@Test
	void PlayerCannotCarryMultipleSword() {
		Player player = new Player(dungeon, 0, 0);
		Sword sw2 = new Sword(2, 2);
		dungeon.setPlayer(player);
		dungeon.addEntity(player);
		dungeon.addEntity(sw2);
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertTrue(player.getPickups().size() == 1);
		assertTrue(player.hasSword());
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertTrue(player.getPickups().size() == 2);
	}
	
	@Test
	void SwordUselessAfterFiveHits() {
		assertTrue(((Sword) sword).getHits() == 5);
	}

}
