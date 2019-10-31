package unsw.dungeon;

public class Portal extends Entity{
	private int id;
	private Portal oppositePortal;

	public Portal(int x, int y, int id) {
		super(x, y);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean portalRun(Dungeon dungeon) {
		this.oppositePortal = dungeon.findPortal(getX(), getY(), id);
		for(Entity e : dungeon.getEntities()) {
    		if (e.getX() == getX() && e.getY() == getY() && !(e instanceof Portal)) {
    			transportEntity(e);
    			return true;
    		}
    	}
		return false;
	}
	
	
	public void transportEntity(Entity entity) {
		if(oppositePortal != null) {
			entity.x().set(oppositePortal.getX());
			entity.y().set(oppositePortal.getY());
		}
	}
}
