package unsw.dungeon;

public class PickupSword implements PickupStrategy {

	@Override
	public boolean pickup(Player player, Entity entity) {
		if(entity instanceof Sword) {
			player.addEntity(entity);
			player.notifyEnemy();
			return true;
		}
		return false;
	}

}
