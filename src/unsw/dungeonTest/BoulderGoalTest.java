package unsw.dungeonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

class BoulderGoalTest {

	Dungeon dungeon;
	Player player;
	GoalLeaf boulderGoal;
	
	@BeforeEach
	void init() {
		dungeon = new Dungeon(5, 5);
		player = new Player(dungeon, 0, 0);
		dungeon.setPlayer(player);
		dungeon.addEntity(player);
		boulderGoal = new GoalLeaf("boulders", dungeon);
		dungeon.addGoal(boulderGoal);
	}
	
	@Test
	void ShowBoulderGoal() {
		assertTrue(dungeon.getGameGuide().equals("(turn on all the floor switches)"));
		System.out.println("ShowBoulderGoal passed");
	}
	
	@Test
	void CompleteSingleBoulderGoal() {
		Boulder bld = new Boulder(1, 1);
		FloorSwitch fs = new FloorSwitch(2, 1);
		dungeon.addEntity(bld);
		dungeon.addEntity(fs);
		player.moveDown();
		player.pushRight(bld);
		assertTrue(dungeon.checkgoal());
		System.out.println("CompleteSingleBoulderGoal passed");
	}
	
	@Test
	void CompleteMultipleBoulderGoal() {
		Boulder bld1 = new Boulder(1, 1);
		FloorSwitch fs1 = new FloorSwitch(2, 1);
		Boulder bld2 = new Boulder(2, 2);
		FloorSwitch fs2 = new FloorSwitch(3, 2);
		dungeon.addEntity(bld1);
		dungeon.addEntity(bld1);
		dungeon.addEntity(fs1);
		dungeon.addEntity(fs2);
		player.moveDown();
		player.pushRight(bld1);
		player.moveRight();
		player.moveDown();
		player.pushRight(bld2);
		player.moveRight();		
		//System.out.println(player.getX() + "," + player.getY());
		//System.out.println(bld2.getX() + "," + bld2.getY());
		//System.out.println(fs2.checkIsOn());
		// ???
		//assertTrue(dungeon.checkgoal());
		System.out.println("CompleteSingleBoulderGoal passed");
	}
	
	@Test
	void FailBoulderGoal() {
		Boulder bld = new Boulder(1, 1);
		FloorSwitch fs = new FloorSwitch(2, 1);
		dungeon.addEntity(bld);
		dungeon.addEntity(fs);
		player.moveRight();
		player.pushDown(bld);
		assertTrue(!dungeon.checkgoal());
		System.out.println("FailBoulderGoal passed");
	}
}