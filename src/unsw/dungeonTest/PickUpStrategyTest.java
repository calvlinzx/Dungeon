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
		assertTrue(dungeon.findEntity(1, 1) == null);
		assertTrue(player.meetEntity() == null);
		System.out.println("PickUpTreasureTest passed");
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
		assertTrue(dungeon.findEntity(1, 1) == null);
		assertTrue(player.meetEntity() == null);
		System.out.println("PickUpSwordTest passed");
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
		assertTrue(dungeon.findEntity(1, 1) == null);
		assertTrue(player.meetEntity() == null);
		System.out.println("PickUpKeyTest passed");
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
		assertTrue(dungeon.findEntity(1, 1) == null);
		assertTrue(player.meetEntity() == null);
		System.out.println("PickUpPotionTest passed");
	}
	
	@Test
	void PickUpAllTest() {
		List<Entity> pickUps = player.getPickups();
		assertEquals(0, pickUps.size());
		Entity treasure = new Treasure(1, 1);
		Entity sword = new Sword(2, 2);
		Entity key = new Key(3, 3);
		Entity potion = new Invincibility(4, 4);
		dungeon.addEntity(sword);
		dungeon.addEntity(key);
		dungeon.addEntity(treasure);
		dungeon.addEntity(potion);
		// picking up treasure
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(1, pickUps.size());
		
		// picking up sword
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(2, pickUps.size());
		
		// picking up key
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(3, pickUps.size());
		
		// picking up potion
		player.moveDown();
		player.moveRight();
		player.pickUp();
		assertEquals(4, pickUps.size());
		
		assertTrue(dungeon.findEntity(1, 1) == null);
		assertTrue(dungeon.findEntity(2, 2) == null);
		assertTrue(dungeon.findEntity(3, 3) == null);
		assertTrue(dungeon.findEntity(4, 4) == null);
		System.out.println("PickUpAllTest passed");
	}
	
	
}
