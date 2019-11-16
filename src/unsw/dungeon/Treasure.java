package unsw.dungeon;

import java.util.ArrayList;

public class Treasure extends Entity implements SubjectGoal{
	
	private ArrayList<ObserverGoal> observers;
	
	public Treasure(int x, int y) {
		super(x, y);
		this.observers = new ArrayList<ObserverGoal>();
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
		// TODO Auto-generated method stub
		for (ObserverGoal o : observers) {
			o.update(this);
		}
	}

}
