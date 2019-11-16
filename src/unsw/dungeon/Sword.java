package unsw.dungeon;

public class Sword extends Entity{
	
	private int hits;

	public Sword(int x, int y) {
		super(x, y);
		this.hits = 5;
	}
	
	public void hit() {
		if(hits != 0) {
			hits--;
		}
	}
	
	public int getHits() {
		return hits;
	}
	
	public void use(Player player) {
		this.hit();
		player.notifyEnemy();
	}
}

