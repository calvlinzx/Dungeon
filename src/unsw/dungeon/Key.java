package unsw.dungeon;

public class Key extends Entity {
	
	private boolean canUse;
	
	public Key(int x, int y) {
		super(x, y);
		this.canUse = true;
	}
	
	public void use() {
		canUse = false;
	}
	
	public boolean getCanUse() {
		return this.canUse;
	}

}
