package unsw.dungeon;

public class CannotOpenState implements StateCanOpen {

	private Door door;
	
	public CannotOpenState(Door door) {
		this.door = door;
	}
	
	@Override
	public boolean openable() {
		// TODO Auto-generated method stub
		return false;
	}

}
