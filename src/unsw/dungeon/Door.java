package unsw.dungeon;

public class Door extends Entity implements ObserverDoor{
	
	private StateCanOpen canOpen;
	private StateCanOpen cannotOpen;
	private StateCanOpen state;
	private int id;
	
	public Door(int x, int y, int id) {
		super(x, y);
		this.canOpen = new CanOpenState(this);
		this.cannotOpen = new CannotOpenState(this);
		this.state = cannotOpen;
		this.id = id;
	}

	@Override
	public void update(boolean hasKey) {
		if(hasKey) {
			doorCanOpen();
		}else {
			doorCannotOpen();
		}
	}

	private void doorCannotOpen() {
		System.out.println("cannot open");
		state = cannotOpen;
	}

	public void doorCanOpen() {
		System.out.println("can open");
		state = canOpen;
	}
	
	public boolean open() {
		return state.openable();
	}

}
