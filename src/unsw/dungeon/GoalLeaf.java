package unsw.dungeon;

public class GoalLeaf implements GoalComponent {
	
	private String goal;
	private Dungeon dungeon;
	
	public GoalLeaf(String goal, Dungeon dungeon) {
		this.goal = goal;
		this.dungeon = dungeon;
	}

	@Override
	public void add(GoalComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(GoalComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkgoals() {
		if(goal.equals("exit")) {
			return dungeon.checkExit();
		}
		if(goal.equals("enemies")) {
			return (! dungeon.hasEnemy());
		}
		if (goal.equals("boulders")) {
			return dungeon.checkSwitch();
		}
		if (goal.equals("treasure")) {
			return (! dungeon.hasTreasure());
		}
		return false;
	}

}
