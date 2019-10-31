package unsw.dungeon;

public class CanOpenState implements StateCanOpen {
		
	private Door door;
	
	public CanOpenState(Door door) {
		this.door = door;
	}

	@Override
	public boolean openable() {
		return true;
	}

}
