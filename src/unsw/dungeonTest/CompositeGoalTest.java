package unsw.dungeonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

class CompositeGoalTest {

	Dungeon dungeon;
	Player player;
	GoalComponent treasureGoal;
	GoalComponent boulderGoal;
	GoalComponent exitGoal;
	GoalComponent enemyGoal;
	GoalComponent goals;
	
	@BeforeEach
	void init() {
		dungeon = new Dungeon(5, 5);
		player = new Player(dungeon, 0, 0);
		dungeon.setPlayer(player);
		dungeon.addEntity(player);
		
		enemyGoal = new GoalLeaf("enemies", dungeon);
		dungeon.addGoal(enemyGoal);
	}
	
	@Test
	void ShowEnemyGoal() {
		assertTrue(dungeon.getGameGuide().equals("(kill all enemies)"));
		System.out.println("ShowEnemyGoal passed");
	}

}
