package unsw.dungeon;

public class PotionThread extends Thread {

	private Player player;
	private Entity entity;

	public PotionThread(Player player, Entity entity) {
		this.player = player;
		this.entity = entity;
	}

	@Override
	public void run() {
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((Invincibility) entity).active();
	}
	

}
