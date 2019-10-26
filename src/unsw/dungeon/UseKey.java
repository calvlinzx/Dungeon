package unsw.dungeon;

public class UseKey implements UsePropStrategy {

	@Override
	public void useProp(Player player, Entity entity) {
		if(entity != null) {
			player.notifyDoor();
			((Key) entity).use();
			player.notifyDoor();
		}
	}

}
