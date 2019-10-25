package unsw.dungeon;

public class UseInvincibility implements UsePropStrategy {

	@Override
	public void useProp(Player player, Entity entity){
		PotionThread p1 = new PotionThread(player, entity);
		PotionThread2 p2 = new PotionThread2(player, entity);
		p1.start();
		p2.start();
	}
}
