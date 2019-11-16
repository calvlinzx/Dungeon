package unsw.dungeon;

public class GoalTreasure implements GoalComponent{
	
	private String goal;
	private Dungeon dungeon;
	
	public GoalTreasure(Dungeon dungeon) {
		this.goal = "treasure";
		this.dungeon = dungeon;
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
		return !dungeon.hasTreasure();
	}
}
