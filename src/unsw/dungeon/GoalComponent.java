package unsw.dungeon;

public interface GoalComponent {
	
	public void add(GoalComponent component);

    public void remove(GoalComponent component);
    
    public boolean checkgoals();
}
