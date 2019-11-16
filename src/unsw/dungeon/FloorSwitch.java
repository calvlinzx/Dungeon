package unsw.dungeon;

import java.util.ArrayList;

public class FloorSwitch extends Entity implements SubjectGoal{
	private boolean fswitch;
	private ArrayList<ObserverGoal> observers;

	public FloorSwitch(int x, int y) {
		super(x, y);
		this.fswitch = false;
		this.observers = new ArrayList<ObserverGoal>();
	}
	
	public void turnOn() {
		this.fswitch = true;
	}
	
	public void turnOff() {
		this.fswitch = false;
	}
	
	public boolean checkIsOn() {
		return fswitch;
	}

	public void update(boolean ison) {
		if(ison) {
			turnOn();
		}else {
			turnOff();
		}
	}
	
	@Override
	public void registerGoalObserver(ObserverGoal o) {
		observers.add(o);
	}

	@Override
	public void removeGoalObserver(ObserverGoal o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void notifyGoal() {
		//System.out.println("!!!");
		for (ObserverGoal o : observers) {
			o.update(this);
		}
	}
}
