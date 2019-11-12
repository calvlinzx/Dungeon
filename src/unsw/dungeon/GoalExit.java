package unsw.dungeon;

public class GoalExit implements GoalComponent{
	
	private String goal;
	private Dungeon dungeon;
	
	public GoalExit(Dungeon dungeon) {
		this.goal = "exit";
		this.dungeon = dungeon;
	}

	@Override
	public String getInfo() {
		return "(get to exit)";
	}

	@Override
	public boolean checkgoals() {
		// to be changed later
		return dungeon.checkExit();
	}

	@Override
	public void add(GoalComponent component) {
		// TODO Auto-generated method stub
		
	}

}
