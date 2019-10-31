package unsw.dungeon;

public class Key extends Entity {
	
	private boolean canUse;
	private int id;
	
	public Key(int x, int y, int id) {
		super(x, y);
		this.id = id;
		this.canUse = true;
	}
	
	public void use() {
		canUse = false;
	}
	
	public boolean getCanUse() {
		return this.canUse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
