package unsw.dungeon;

public class PickupKey implements PickupStrategy {

	@Override
	public boolean pickup(Player player, Entity entity) {
		if(entity instanceof Key && player.findKey2use() == null) {
			player.addEntity(entity);
			player.notifyDoor();
			return true;
		}
		return false;
	}

}
