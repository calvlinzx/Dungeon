package unsw.dungeon;

public class GoalExit implements GoalComponent{
	
	private String goal;
	private Player player;
	private Exit exit;
	
	public GoalExit(Player player, Exit exit) {
		this.goal = "exit";
		this.player = player;
		this.exit = exit;
	}

	@Override
	public String getInfo() {
		return "(getting to exit)";
	}

	@Override
	public boolean checkgoals() {
		// to be changed later
		return player.getX() == exit.getX() && player.getY() == exit.getY();
	}

	@Override
	public void add(GoalComponent component) {
		// TODO Auto-generated method stub
		
	}

}
