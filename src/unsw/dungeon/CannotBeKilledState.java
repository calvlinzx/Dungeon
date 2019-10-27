package unsw.dungeon;

public class CannotBeKilledState implements StateKillable {
	
	private Enemy enemy;
	
	public CannotBeKilledState(Enemy enemy) {
		this.enemy = enemy;
	}

	@Override
	public boolean meetPlayer(Entity player) {
		((Player) player).beKilled();
		return false;
	}
	
}
