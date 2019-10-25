package unsw.dungeon;

public class CannotBeKilledState implements StateKillable {
	
	private Enemy enemy;
	
	public CannotBeKilledState(Enemy enemy) {
		this.enemy = enemy;
	}

	@Override
	public boolean meetPlayer() {
		System.out.println("player die");
		return false;
	}
	
}
