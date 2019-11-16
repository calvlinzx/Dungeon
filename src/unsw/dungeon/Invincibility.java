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
	 
	// modified
	public void use(Player player) {
		PotionThread p1 = new PotionThread(player, this);
		PotionThread2 p2 = new PotionThread2(player, this);
		p1.start();
		p2.start();
	}

}
