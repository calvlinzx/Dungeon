package unsw.dungeon;


public class Invincibility extends Entity{
	private boolean isValid;
	
	public Invincibility(int x, int y) {
		super(x, y);
		isValid = true;
	}
	
	public void active() {
		this.isValid = false;
	}
	
	public boolean getIsValid() {
		return isValid;
	}

}
