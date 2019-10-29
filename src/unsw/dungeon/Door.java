package unsw.dungeon;

public class Door extends Entity implements ObserverDoor{
	
	private StateCanOpen canOpen;
	private StateCanOpen cannotOpen;
	private StateCanOpen state;
	
	public Door(int x, int y) {
		super(x, y);
		this.canOpen = new CanOpenState(this);
		this.cannotOpen = new CannotOpenState(this);
		this.state = cannotOpen;
	}

	@Override
	public void update(boolean hasKey) {
		if(hasKey) {
			doorCanOpen();
		}else {
			doorCannotOpen();
		}
	}

	public StateCanOpen getState() {
		return state;
	}

	private void doorCannotOpen() {
		System.out.println("cannot open");
		state = cannotOpen;
	}

	private void doorCanOpen() {
		System.out.println("can open");
		state = canOpen;
	}
	
	public boolean open() {
		return state.openable();
	}

}
