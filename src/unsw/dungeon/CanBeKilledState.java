package unsw.dungeon;

public class CanBeKilledState implements StateKillable {
	
	private Enemy enemy;
	
	public CanBeKilledState(Enemy enemy) {
		this.enemy = enemy;
	}

	@Override
	public boolean meetPlayer() {
		System.out.println("Enemy die");
		return true;
	}

}