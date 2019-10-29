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
		assertTrue(door.getX() == 1 && door.getY() == 1);
		assertTrue(((Door) door).getState().openable() == false);
		assertTrue(dungeon.canGoThere(1, 1) == false);
	}
	
	@Test
	void PlayerCanGoThroughOpenDoor() {
		
	}
	
	@Test
	void PlayerCanDoorWithRightKey() {
		
	}
	
	@Test
	void PlayerCannotOpenDoorWithWrongKey() {
		
	}
}
