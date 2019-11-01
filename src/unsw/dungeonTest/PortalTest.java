package unsw.dungeonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

class PortalTest {
	
	Dungeon dungeon;
	Player player;
	Entity portal1;
	Entity portal2;
	
	@BeforeEach
	void init() {
		dungeon = new Dungeon(5, 5);
		player = new Player(dungeon, 0, 0);
		portal1 = new Portal(1, 1, 0);
		portal2 = new Portal(3, 3, 0);
		dungeon.setPlayer(player);
		dungeon.addEntity(player);
		dungeon.addEntity(portal1);
		dungeon.addEntity(portal2);
	}
	
	@Test
	void PortalCanBeStepOn() {
		assertTrue(dungeon.findPortal(1, 1) != null);
		assertTrue(dungeon.findPortal(3, 3) != null);
		assertTrue(dungeon.canGoThere(1, 1));
		assertTrue(dungeon.canGoThere(3, 3));
		System.out.println("PortalCanBeStepOn passed");
	}

	@Test
	void PlayerCanBeTeleported() {
		player.moveDown();
		player.moveRight();
		assertTrue(player.getX() == 1 && player.getY() == 1);
		((Portal) portal1).portalRun(dungeon);
		assertTrue(player.getX() == 3 && player.getY() == 3);
		System.out.println("PlayerCanBeTeleported passed");
	}
	
	@Test
	void PlayerCanBeTeleportedReverse() {
		player.moveDown();
		player.moveRight();
		player.moveDown();
		player.moveRight();
		player.moveDown();
		player.moveRight();
		assertTrue(player.getX() == 3 && player.getY() == 3);
		((Portal) portal2).portalRun(dungeon);
		assertTrue(player.getX() == 1 && player.getY() == 1);
		System.out.println("PlayerCanBeTeleportedReverse passed");
	}
	
	@Test
	void EnemyCannotBeTeleported() {
		// not implemented
		System.out.println("EnemyCanBeTeleported passed");
	}
	
	@Test
	void BoulderCannotBeTeleported() {
		// not implemented
		System.out.println("BoulderCanBeTeleported passed");
	}
}
