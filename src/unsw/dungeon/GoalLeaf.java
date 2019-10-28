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

	@Override
	public String getInfo() {
		String ret = "";
		if(goal.equals("exit")) {
			ret += "(getting to exit)";
		}
		if(goal.equals("enemies")) {
			ret += "(kill all enemies)";
		}
		if (goal.equals("boulders")) {
			ret += "(turn on all the floor switches)";
		}
		if (goal.equals("treasure")) {
			ret += "(pick up all the treasure)";
		}
		return ret;
	}

}
