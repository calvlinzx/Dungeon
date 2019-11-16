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
    private GoalComponent goal;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
    }
    
    public void addGoal(GoalComponent goal) {
    	this.goal = goal;
    }
    
    public boolean checkgoal() {
    	return goal.checkgoals();
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
    				//((FloorSwitch) e).notifyGoal();
    			}else {
    				((FloorSwitch) e).update(false);
    			}
    			((FloorSwitch) e).notifyGoal();
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
    
    public Entity findPlayer(int x, int y) {
    	for(Entity e : entities) {
    		if (e.getX() == x && e.getY() == y && e instanceof Player) {
    			return e;
    		}
    	}
    	return null;
    }
    
    public boolean checkExit() {
    	for(Entity e : entities) {
    		if (e instanceof Exit) {
    			if(findPlayer(e.getX(), e.getY()) instanceof Player) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public boolean canGoThere(int x1, int y1, int x2, int y2) {
    	Entity entity1 = findEntity(x1, y1);
    	Entity entity2 = findEntity(x2, y2);
		if(entity1 instanceof Wall) {
			return false;
		}else if (entity1 instanceof Door && !((Door) entity1).open()) {
			return false;
		}else if (entity1 instanceof Boulder && entity2 instanceof Boulder) {
			return false;
		}else if (entity1 instanceof Boulder && entity2 instanceof Wall) {
			return false;
		}
		return true;
	}
    
    
    public void checkPortal() {
    	for(Entity e : entities) {
    		if(e instanceof Portal) {
    			if(((Portal) e).portalRun(this))
    				break;
    		}
    	}
    }
    
    public Portal findPortal(int x, int y, int id) {
    	for(Entity e : entities) {
    		if(e instanceof Portal) {
	    		if ((e.getX() != x || e.getY() != y) && ((Portal) e).getId() == id) {
	    			return (Portal) e;
	    		}
    		}
    	}
    	return null;
    }
    
    public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	public boolean canGoThere(int x, int y) {
    	Entity entity1 = findEntity(x, y);
    	if(entity1 instanceof Wall) {
			return false;
		}else if (entity1 instanceof Door && !((Door) entity1).open()) {
			return false;
		}else if (entity1 instanceof Boulder) {
			return false;
		}
    	return true;
    }
	

    public boolean hasEnemy() {
    	for(Entity e : entities) {
    		if (e instanceof Enemy) {
    			return true;
    		}
    	}
    	return false;
    }
	public Entity findPortal(int x, int y) {
		for(Entity e : entities) {
			if ((e.getX() != x || e.getY() != y) && e instanceof Portal) {
				return e;
			}
		}
		return null;
	}

	public boolean hasTreasure() {
		for(Entity e : entities) {
			if ( e instanceof Treasure) {
				return true;
			}
		}
		return false;
	}
	
	public Exit getExit() {
		for(Entity e : this.entities) {
			if (e instanceof Exit) {
				return (Exit) e;
			}
		}
		return null;
	}
	
	public int getEnemyCount() {
		int count = 0;
		for(Entity e : this.entities) {
			if (e instanceof Enemy) {
				count++;
			}
		}
		return count;
	}
	
	public int getTreasureCount() {
		int count = 0;
		for(Entity e : this.entities) {
			if (e instanceof Treasure) {
				count++;
			}
		}
		return count;
	}
	
	public int getBoulderCount() {
		int count = 0;
		for(Entity e : this.entities) {
			if (e instanceof Boulder) {
				count++;
			}
		}
		return count;
	}
	
	public void setObserverEnemyGoal(GoalEnemy goal) {
		for (Entity e : entities) {
			if (e instanceof Enemy) {
				Enemy enemy = (Enemy) e;
				enemy.registerGoalObserver(goal);
			}
		}
		
	}
	
	public void setObserverTreasureGoal(GoalTreasure goal) {
		for (Entity e : entities) {
			if (e instanceof Treasure) {
				((Treasure) e).registerGoalObserver(goal);
			}
		}
		
	}
	
	public void setObserverBoulderGoal(GoalBoulder goal) {
		for (Entity e : entities) {
			if (e instanceof FloorSwitch) {
				((FloorSwitch) e).registerGoalObserver(goal);
			}
		}
		
	}
	
	public String getGameGuide() {
		return goal.getInfo();
	}

}
