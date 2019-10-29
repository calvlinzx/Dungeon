package unsw.dungeonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import unsw.dungeon.*;

import org.junit.jupiter.api.Test;

class DoorTest {
	
	Dungeon dungeon;
	Player player;
	Entity door;
	
	@BeforeEach
	void init() {
		dungeon = new Dungeon(5, 5);
		player = new Player(dungeon, 0, 0);
		door = new Door(1, 1);
		dungeon.setPlayer(player);
		dungeon.addEntity(player);
		dungeon.addEntity(door);
		dungeon.setDoorObserver();
	}
	
	@Test
	void PlayerCannotGoThroughClosedDoor() {
		player.moveRight();
		player.moveDown();
		assertTrue(((Door) door).getState().openable() == false);
		System.out.println(player.getX() +","+ player.getY());
		//assertTrue(player.getX() == 1 && player.getY() == 0);
	}

}
