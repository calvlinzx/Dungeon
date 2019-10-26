package unsw.dungeon;

public class CannotOpenState implements StateCanOpen {

	private Door door;
	
	public CannotOpenState(Door door) {
		this.door = door;
	}
	
	@Override
	public boolean openable() {
		System.out.println("no Open");
		return false;
	}

}
