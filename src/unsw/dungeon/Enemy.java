package unsw.dungeon;

public class Enemy extends Entity implements ObserverEnemy{
	
	private StateKillable canBeKilled;
	private StateKillable cannotBeKilled;
	private StateKillable state;
	private Dungeon dungeon;
	private int lastx;
	private int lasty;

	public Enemy(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		this.canBeKilled = new CanBeKilledState(this);
		this.cannotBeKilled = new CannotBeKilledState(this);
		this.state = cannotBeKilled;
		this.lastx = x;
		this.lasty = y;
	}

	@Override
	public void update(int x, int y, boolean hasSword, boolean hasInvincibility) {
		if (hasSword && !hasInvincibility) {
			approachPlayer(x, y);
			playerHasSword();
		}
		if(hasInvincibility) {
			runAway(x, y);
			playerHasInvincibility();
		}
		if(!hasSword && !hasInvincibility) {
			approachPlayer(x, y);
			playerHasNoSword();
		}
	}
	
	private int getlastDistance(int x, int y) {
		return Math.abs(lastx - x) + Math.abs(lasty - y);
	}
	
	private void setLast(int x, int y) {
		this.lastx = x;
		this.lasty = y;
	}
	
	private int getDistance(int x, int y, int px, int py) {
		return Math.abs(x - px) + Math.abs(y - py);
	}
	
	private void approachPlayer(int x, int y) {
		int distance = getlastDistance(x, y);
		if (getDistance(getX()-1, getY(), x, y) < distance && dungeon.canGoThere(getX()-1, getY())) {
			 x().set(getX() - 1);
			 setLast(getX(), getY());
			 return;
		}else if(getDistance(getX()+1, getY(), x, y) < distance && dungeon.canGoThere(getX()+1, getY())) {
			 x().set(getX() + 1);
			 setLast(getX(), getY());
			 return;
		}else if(getDistance(getX(), getY()-1, x ,y) < distance && dungeon.canGoThere(getX(), getY()-1)) {
			 y().set(getY() - 1);
			 setLast(getX(), getY());
			 return;
		}else if(getDistance(getX(), getY()+1, x, y) < distance && dungeon.canGoThere(getX(), getY()+1)) {
			 y().set(getY() + 1);
			 setLast(getX(), getY());
			 return;
		}
	}
	
	
	public void runAway(int x, int y) {
		if(getX() >= x) {
			if(getY() < y) {
				go2position(x+10, y-10);
			}else {
				go2position(x+10, y+10);
			}
		}
		if(getX() < x) {
			if(getY() < y) {
				go2position(x-10, y-10);
			}else {
				go2position(x-10, y+10);
			}
		}
	}
	
	public void go2position(int x, int y) {
		if (getX() < x && dungeon.canGoThere(getX()+1, getY())) {
			x().set(getX()+1);
			setLast(getX(), getY());
			return;
		}
		if (getX() > x && dungeon.canGoThere(getX()-1, getY())) {
			x().set(getX()-1);
			setLast(getX(), getY());
			return;
		}
		if (getY() < y && dungeon.canGoThere(getX(), getY()+1)) {
			y().set(getY()+1);
			setLast(getX(), getY());
			return;
		}
		if (getY() > y && dungeon.canGoThere(getX(), getY()-1)) {
			y().set(getY()-1);
			setLast(getX(), getY());
			return;
		}
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
	
	public boolean meetPlayer(Entity player) {
		return state.meetPlayer(dungeon.getPlayer());
	}
}