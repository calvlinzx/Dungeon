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
	public void update(int x, int y, boolean hasSword, boolean hasInvincibility) {
		if (hasSword && !hasInvincibility) {
			approachPlayer(x, y);
			playerHasSword();
		}
		if(hasInvincibility) {
			runAway();
			playerHasInvincibility();
		}
		if(!hasSword && !hasInvincibility) {
			approachPlayer(x, y);
			playerHasNoSword();
		}
	}
	
	private void approachPlayer(int x, int y) {
		System.out.println("approaching player");
	}
	
	public void runAway() {
		System.out.println("run away from player");
	}
	
	public void playerHasSword() {
		this.state = canBeKilled;
	}
	
	public void playerHasNoSword() {
		this.state = cannotBeKilled;
	}
	
	public void playerHasInvincibility() {
		this.state = canBeKilled;
	}
	
	public boolean meetPlayer() {
		return state.meetPlayer();
	}
}