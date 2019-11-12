package unsw.dungeon;

public class GoalBoulder implements GoalComponent{
	
	private String goal;
	private Dungeon dungeon;
	
	public GoalBoulder(Dungeon dungeon) {
		this.goal = "boulders";
		this.dungeon = dungeon;
	}
	
	@Override
	public void add(GoalComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInfo() {
		return "(turn on all the floor switches)";
	}

	@Override
	public boolean checkgoals() {
		// to be changed later
		return dungeon.checkSwitch();
	}
}
