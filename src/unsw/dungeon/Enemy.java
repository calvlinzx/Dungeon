package unsw.dungeon;

import java.util.ArrayList;

public class Enemy extends Entity implements ObserverEnemy, SubjectGoal{
	
	private StateKillable canBeKilled;
	private StateKillable cannotBeKilled;
	private StateKillable state;
	private Dungeon dungeon;
	private int lastx;
	private int lasty;
	private ArrayList<ObserverGoal> observers;

	public Enemy(Dungeon dungeon, int x, int y) {
		super(x, y);
		this.dungeon = dungeon;
		this.canBeKilled = new CanBeKilledState(this);
		this.cannotBeKilled = new CannotBeKilledState(this);
		this.state = cannotBeKilled;
		this.lastx = x;
		this.lasty = y;
		this.observers = new ArrayList<ObserverGoal>();
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
	
	public int getDistance(int x, int y, int px, int py) {
		return Math.abs(x - px) + Math.abs(y - py);
	}
	
	private void approachPlayer(int x, int y) {
		int distance = getlastDistance(x, y);
		if (getDistance(getX()-1, getY(), x, y) < distance && dungeon.enemyCanGoThere(getX()-1, getY()) && ! (dungeon.findEntity(getX()-1, getY()) instanceof Enemy)) {
			 x().set(getX() - 1);
			 setLast(getX(), getY());
			 return;
		}else if(getDistance(getX()+1, getY(), x, y) < distance && dungeon.enemyCanGoThere(getX()+1, getY()) && ! (dungeon.findEntity(getX()+1, getY()) instanceof Enemy)) {
			 x().set(getX() + 1);
			 setLast(getX(), getY());
			 return;
		}else if(getDistance(getX(), getY()-1, x ,y) < distance && dungeon.enemyCanGoThere(getX(), getY()-1) && ! (dungeon.findEntity(getX(), getY()-1) instanceof Enemy)) {
			 y().set(getY() - 1);
			 setLast(getX(), getY());
			 return;
		}else if(getDistance(getX(), getY()+1, x, y) < distance && dungeon.enemyCanGoThere(getX(), getY()+1) && ! (dungeon.findEntity(getX(), getY()+1) instanceof Enemy)) {
			 y().set(getY() + 1);
			 setLast(getX(), getY());
			 return;
		}
	}
	
	
	public void runAway(int x, int y) {
		if(getX() >= x) {
			if(getY() < y) {
				go2position(x+20, y-20);
			}else {
				go2position(x+20, y+20);
			}
		}
		if(getX() < x) {
			if(getY() < y) {
				go2position(x-20, y-20);
			}else {
				go2position(x-20, y+20);
			}
		}
	}
	
	public void go2position(int x, int y) {
		if (getX() < x && dungeon.enemyCanGoThere(getX()+1, getY()) && ! (dungeon.findEntity(getX()+1, getY()) instanceof Enemy)) {
			x().set(getX()+1);
			setLast(getX(), getY());
			return;
		}
		if (getX() > x && dungeon.enemyCanGoThere(getX()-1, getY()) && ! (dungeon.findEntity(getX()-1, getY()) instanceof Enemy)) {
			x().set(getX()-1);
			setLast(getX(), getY());
			return;
		}
		if (getY() < y && dungeon.enemyCanGoThere(getX(), getY()+1) && ! (dungeon.findEntity(getX(), getY()+1) instanceof Enemy)) {
			y().set(getY()+1);
			setLast(getX(), getY());
			return;
		}
		if (getY() > y && dungeon.enemyCanGoThere(getX(), getY()-1) && ! (dungeon.findEntity(getX(), getY()-1) instanceof Enemy)) {
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

	@Override
	public void registerGoalObserver(ObserverGoal o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeGoalObserver(ObserverGoal o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyGoal() {
		for (ObserverGoal o : observers) {
			o.update(this);
		}
	}
}