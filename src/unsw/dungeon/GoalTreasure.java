package unsw.dungeon;

public class GoalTreasure implements GoalComponent, ObserverGoal{
	
	private String goal;
	private int total;
	private int collected;
	
	public GoalTreasure(int total) {
		this.goal = "treasure";
		this.total = total;
		this.collected = 0;
	}
	
	@Override
	public void add(GoalComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInfo() {
		return "(pick up all treasure)";
	}

	@Override
	public boolean checkgoals() {
		// to be changed later
		return this.total == this.collected;
	}

	@Override
	public void update(Entity entity) {
		if (entity instanceof Treasure) {
			this.collected++;
		}
	}
}
