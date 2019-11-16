package unsw.dungeon;

public class GoalEnemy implements GoalComponent{
	
	private String goal;
	private Dungeon dungeon;
	
	public GoalEnemy(Dungeon dungeon) {
		this.goal = "enemies";
		this.dungeon = dungeon;
	}
	
	@Override
	public void add(GoalComponent component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInfo() {
		return "(kill all enemies)";
	}

	@Override
	public boolean checkgoals() {
		// to be changed later
		return !dungeon.hasEnemy();
	}

}
