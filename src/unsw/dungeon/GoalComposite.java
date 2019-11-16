package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class GoalComposite implements GoalComponent {
	
	private String goal;
	private Dungeon dungeon;
	private List<GoalComponent> subgoals;
	
	public GoalComposite(String goal, Dungeon dungeon) {
		this.goal = goal;
		this.dungeon = dungeon;
		this.subgoals = new ArrayList<GoalComponent>();
	}
	
	public boolean checkgoals() {
		if (goal.equals("main goal")) {
			for (GoalComponent g : subgoals) {
				if (! g.checkgoals()) {
					return false;
				}
			}
		}
		if (goal.equals("and")) {
			for (GoalComponent g : subgoals) {
				if (! g.checkgoals()) {
					return false;
				}
			}
		}
		if (goal.equals("or")) {
			for (GoalComponent g : subgoals) {
				if (g.checkgoals()) {
					return true;
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public void add(GoalComponent component) {
		if (! subgoals.contains(component)) {
			this.subgoals.add(component);
		}		
	}

	@Override
	public String getInfo() {
		String ret = "[";
		if (goal.equals("main goal")) {
			for (GoalComponent g : subgoals) {
				ret += g.getInfo();
			}
			ret = ret.substring(1);
		}
		if (goal.equals("and")) {
			for (GoalComponent g : subgoals) {
				ret += g.getInfo() + " and\n";
			}
			ret = ret.substring(0, ret.length()-5);
			ret += "]";
		}
		if (goal.equals("or")) {
			for (GoalComponent g : subgoals) {
				ret += g.getInfo() + " or\n";
			}
			ret = ret.substring(0, ret.length()-4);
			ret += "]";
		}
		return ret;
	}

}
