package unsw.dungeon;

public class PotionThread2 extends Thread {

	private Player player;
	private Entity entity;

	public PotionThread2(Player player, Entity entity) {
		this.player = player;
		this.entity = entity;
	}

	@Override
	public void run() {
		while(((Invincibility) entity).getIsValid()) {
			player.notifyEnemy();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		player.notifyEnemy();
	}
}