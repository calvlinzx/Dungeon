package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity implements SubjectEnemy{

    private Dungeon dungeon;
    private List<Entity> pickups;
    private PickupStrategy pstrategy;
    private List<ObserverEnemy> enemyObservers;
    private UsePropStrategy useProp;
    

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.pickups = new ArrayList<>();
        this.enemyObservers = new ArrayList<>();
    }

    public void moveUp() {
        if (getY() > 0)
            y().set(getY() - 1);
    }

    public void moveDown() {
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
    }

    public void moveLeft() {
        if (getX() > 0)
            x().set(getX() - 1);
    }

    public void moveRight() {
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
    }
    
    public void setPickupStrategy(PickupStrategy pstrategy){
    	this.pstrategy = pstrategy;
    }
    
    public void setUsePropStrategy(UsePropStrategy useProp) {
    	this.useProp = useProp;
    }
    
    public List<Entity> getPickups(){
    	return pickups;
    }
    
    public Entity meetEntity() {
    	Entity entity = dungeon.findEntity(getX(), getY());
    	if(entity instanceof Key) {
    		setPickupStrategy(new PickupKey());
    	}else if(entity instanceof Sword) {
    		setPickupStrategy(new PickupSword());
    	}else if(entity instanceof Treasure) {
    		setPickupStrategy(new PickupTreasure());
    	}else if(entity instanceof Invincibility) {
    		setPickupStrategy(new PickupInvincibility());
    	}
    	return entity;
    }
    
    public void addEntity(Entity entity) {
    	this.pickups.add(entity);
    }
    
    public void removeEntity(Entity entity) {
    	this.pickups.remove(entity);
    }
    
    public void pickUp() {
    	Entity entity = meetEntity();
    	if(entity != null) {
	    	if(pstrategy != null)
	    		if(pstrategy.pickup(this, entity)) {
	    			dungeon.removeEntity(entity);
	    		}
    	}
    }
    
    public Entity findSword2use() {
    	for(Entity e : pickups) {
    		if (e instanceof Sword && ((Sword) e).getHits() > 0)
    			return e;
    	}
    	return null;
    }
    
    public boolean battleEnemy() {
    	Entity enemy = meetEntity();
    	if(enemy != null && enemy instanceof Enemy) {
	    	boolean ret =  ((Enemy) enemy).meetPlayer();
	    	if (ret) {
	    		if(! hasInvincibility()) {
		    		setUsePropStrategy(new UseSword());
		    		useProp.useProp(this, findSword2use());
	    		}
	    		dungeon.removeEntity(enemy);
	    		return ret;
	    	}else {
	    		return ret;
	    	}
    	}
    	return false;
    }
    
    public void useInvincibility() {
    	if(hasInvincibility()) {
    		Entity potion = findInvincibility2use();
    		setUsePropStrategy(new UseInvincibility());
    		useProp.useProp(this, potion);
    		dungeon.removeEntity(potion);
    	}
    }

	@Override
	public void registerEnemyObserver(ObserverEnemy o) {
		enemyObservers.add(o);
	}

	@Override
	public void removeEnemyObserver(ObserverEnemy o) {
		int i = enemyObservers.indexOf(o);
        if (i >= 0) {
            enemyObservers.remove(i);
        }
		
	}
	
	public Entity findInvincibility2use() {
		for (Entity e : pickups) {
			if (e instanceof Invincibility) {
				if(((Invincibility) e).getIsValid())
					return e;
			}
		}
		return null;
	}
	
	public boolean hasInvincibility() {
		if (findInvincibility2use() != null) {
			return true;
		}
		return false;
	}
	
	public boolean hasSword() {
		if(findSword2use() != null) {
			return true;
		}
		return false;
	}

	@Override
	public void notifyEnemy() {
		for (ObserverEnemy o : enemyObservers) {
            o.update(getX(), getY(), hasSword(), hasInvincibility());
        }
	}
}
