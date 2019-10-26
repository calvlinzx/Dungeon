package unsw.dungeon;

public class FloorSwitch extends Entity{
	private boolean fswitch;
	
	public FloorSwitch(int x, int y) {
		super(x, y);
		this.fswitch = false;
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

}
