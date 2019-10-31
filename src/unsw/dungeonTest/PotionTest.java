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
		potion = new Invincibility(1, 1);
		dungeon.addEntity(potion);
	}
	
	@Test
	void PotionCanBeStepOn() {
		assertTrue(potion.getX() == 1);
		assertTrue(potion.getY() == 1);
		assertTrue(dungeon.canGoThere(1, 1));
	}
	
	@Test
	void EnemyRunAwayWhenInvincible() {
		assertTrue(((Sword) potion).getHits() == 5);
		//
		//
	}
	
	
	@Test
	void PotionUselessAfterFiveSeconds() {
		//
		//
		//
	}

}
