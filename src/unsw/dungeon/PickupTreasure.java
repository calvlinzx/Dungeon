package unsw.dungeon;

public class PickupTreasure implements PickupStrategy {

	@Override
	public boolean pickup(Player player, Entity entity) {
		if(entity instanceof Treasure) {
			((Treasure) entity).notifyGoal();
			player.addEntity(entity);
			return true;
		}
		return false;
	}

}
