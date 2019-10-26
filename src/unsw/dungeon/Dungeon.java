/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon {

    private int width, height;
    private List<Entity> entities;
    private Player player;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    public void setEnemyObserver() {
    	for (Entity e : entities) {
    		if(e instanceof Enemy) {
    			player.registerEnemyObserver((Enemy) e);
    		}
    	}
    }
    
    public void setDoorObserver() {
    	for (Entity e : entities) {
    		if(e instanceof Door) {
    			player.registerDoorObserver((Door) e);
    		}
    	}
    }
    
    public Entity findEntity(int x, int y) {
    	for (Entity e : entities) {
    		if (e.getX() == x && e.getY() == y && !(e instanceof Player) && !(e instanceof FloorSwitch)) {
    			return e;
    		}
    	}
    	return null;
    }
    
    public Entity findSwitch(int x, int y) {
    	for(Entity e : entities) {
    		if (e.getX() == x && e.getY() == y && e instanceof FloorSwitch) {
    			return e;
    		}
    	}
    	return null;
    }
    
    public Entity findBoulder(int x, int y) {
    	for(Entity e : entities) {
    		if (e.getX() == x && e.getY() == y && e instanceof Boulder) {
    			return e;
    		}
    	}
    	return null;
    }
    
    public void turnSwitch() {
    	for(Entity e : entities) {
    		if(e instanceof FloorSwitch) {
    			if (findBoulder(e.getX(), e.getY()) instanceof Boulder) {
    				((FloorSwitch) e).update(true);
    				System.out.println(((FloorSwitch) e).checkIsOn());
    			}else {
    				((FloorSwitch) e).update(false);
    				System.out.println(((FloorSwitch) e).checkIsOn());
    			}
    		}
    	}
    }
    
    public void removeEntity(Entity entity) {
    	entities.remove(entity);
    }
    
    public boolean hasSwitch() {
    	for(Entity e : entities) {
    		if(e instanceof FloorSwitch) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean checkSwitch() {
    	for(Entity e : entities) {
    		if(e instanceof FloorSwitch) {
    			if(!((FloorSwitch) e).checkIsOn()){
    				return false;
    			}
    			
    		}
    	}
    	return hasSwitch();
    }
    
    public boolean canGoThere(int x1, int y1, int x2, int y2) {
    	Entity entity1 = findEntity(x1, y1);
    	Entity entity2 = findEntity(x2, y2);
		if(entity1 instanceof Wall) {
			return false;
		}else if (entity1 instanceof Door && ! player.hasKey()) {
			return false;
		}else if (entity1 instanceof Boulder && entity2 instanceof Boulder) {
			return false;
		}else if (entity1 instanceof Boulder && entity2 instanceof Wall) {
			return false;
		}
		return true;
	}

	public Entity findPortal(int x, int y) {
		for(Entity e : entities) {
			if ((e.getX() != x || e.getY() != y) && e instanceof Portal) {
				return e;
			}
		}
		return null;
	}
}
