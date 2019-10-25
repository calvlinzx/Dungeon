package unsw.dungeon;

public class PickupKey implements PickupStrategy {

	@Override
	public boolean pickup(Player player, Entity entity) {
		if(entity instanceof Key) {
			player.addEntity(entity);
			return true;
		}
		return false;
	}

}
