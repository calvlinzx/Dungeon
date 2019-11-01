package unsw.dungeonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

class EnemyTest {
	
	Dungeon dungeon;
	Player player;
	Enemy enemy;
	
	@BeforeEach
	void init() {
		dungeon = new Dungeon(5, 5);
		Player player = new Player(dungeon, 0, 0);
		dungeon.addEntity(player);
		dungeon.setPlayer(player);
		Enemy enemy = new Enemy(dungeon, 4, 4);
		dungeon.addEntity(enemy);
		dungeon.setEnemyObserver();
	}
	
	@Test
	void ApproachPlayerOneSqrPerMove() {
		fail("Not yet implemented");
	}
	
	@Test
	void KillPlayerWithoutWeapon() {
		fail("Not yet implemented");
	}
	
	@Test
	void KilledByPlayerWithSword() {
		fail("Not yet implemented");
	}@Test
	
	void KilledByPlayerWithPotionp() {
		fail("Not yet implemented");
	}


}
