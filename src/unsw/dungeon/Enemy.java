package unsw.dungeon;

public class Enemy extends Entity implements ObserverEnemy{
	
	private StateKillable canBeKilled;
	private StateKillable cannotBeKilled;
	private StateKillable state;

	public Enemy(int x, int y) {
		super(x, y);
		this.canBeKilled = new CanBeKilledState(this);
		this.cannotBeKilled = new CannotBeKilledState(this);
		this.state = cannotBeKilled;
	}

	@Override
	public void update(int x, int y, boolean hasSword) {
		approachPlayer(x, y);
		if (hasSword) {
			playerHasSword();
		}
	}
	
	private void approachPlayer(int x, int y) {
		
	}
	
	public void playerHasSword() {
		this.state = canBeKilled;
	}
	
	public void playerHasNoSword() {
		this.state = cannotBeKilled;
	}
	
	public boolean meetPlayer() {
		return state.meetPlayer();
	}
}