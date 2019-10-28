package unsw.dungeonTest;

import unsw.dungeon.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;


public class PickUpStrategyTest {

	Dungeon dungeon;
	Player player;
	
	@BeforeEach
	void init() {
		dungeon = new Dungeon(5, 5);
		player = new Player(dungeon, 0, 0);
		dungeon.setPlayer(player);
		dungeon.addEntity(player);
	}
	
	@Test
	void PickUpTreasureTest() {
		List<Entity> pickUps = player.getPickups();
		assertEquals(0, pickUps.size());
		Entity treasure = new Treasure(1, 1);
		dungeon.addEntity(treasure);
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(1, pickUps.size());
	}
	
	@Test
	void PickUpSwordTest() {
		List<Entity> pickUps = player.getPickups();
		assertEquals(0, pickUps.size());
		Entity sword = new Sword(1, 1);
		dungeon.addEntity(sword);
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(1, pickUps.size());
	}
	
	@Test
	void PickUpKeyTest() {
		List<Entity> pickUps = player.getPickups();
		assertEquals(0, pickUps.size());
		Entity key = new Key(1, 1);
		dungeon.addEntity(key);
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(1, pickUps.size());
	}
	
	@Test
	void PickUpPotionTest() {
		List<Entity> pickUps = player.getPickups();
		assertEquals(0, pickUps.size());
		Entity potion = new Invincibility(1, 1);
		dungeon.addEntity(potion);
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(1, pickUps.size());
	}
	
	
	
	
}
