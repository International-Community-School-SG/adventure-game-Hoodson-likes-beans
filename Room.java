import java.util.HashMap;
import java.util.Map;

public class Room extends ObjectWithInventory{
    
    /**
     * The name of the room.
     */
	private String name; // all caps that is the name of the room
	/**
	 * The description of the room.  This will be used when the player looks around.
	 */
    private String description; // describes the room
    private Enemy enemy;
    
    /**
     * A mapping between directions and the room that is in that direction.
     */
    public Map<Character,Room> go = new HashMap<Character,Room>();
    
    /**
     * Initializes the room object.  
     * By default all directions are set to null.
     * 
     * @param myName - the name of the room
     * @param myDescription - the description of the room
     * @param inv - the items that are in the room
     */
    
     public Room(String myName, String myDescription, Inventory inv, Enemy enemy){
        name = myName;
        this.enemy = enemy;
    	description = myDescription;
    	setInventory(inv);
    	go.put('N', null);
    	go.put('S', null);
    	go.put('W', null);
    	go.put('E', null);
    	go.put('U', null);
    	go.put('D', null);
    	
    }
    
    public Room(String myName, String myDescription, Enemy enemy){
    	name = myName;
        this.enemy = enemy;
    	description = myDescription;
    	go.put('N', null);
    	go.put('S', null);
    	go.put('W', null);
    	go.put('E', null);
    	go.put('U', null);
    	go.put('D', null);
    	
    }
    
     public Room(String myName, String myDescription, Inventory inv){
    	name = myName;
    	description = myDescription;
    	setInventory(inv);
    	go.put('N', null);
    	go.put('S', null);
    	go.put('W', null);
    	go.put('E', null);
    	go.put('U', null);
    	go.put('D', null);
    	
    }

    public Room(String myName, String myDescription){
    	name = myName;
    	description = myDescription;
    	go.put('N', null);
    	go.put('S', null);
    	go.put('W', null);
    	go.put('E', null);
    	go.put('U', null);
    	go.put('D', null);
    }
    
    /**
     * A simple string of the room the player is in.  Could be used for displaying what is in the room.
     * 
     * Would be good to UPDATE this with the directions that have exits.
     */
    public String toString() {
    	return name + "\n" + description + "\n" + inventory.toString();
    }
    
    public Enemy getEnemy()
    {
        return enemy;
    }
    public void removeEnemy()
    {
        this.enemy = null;
    }
    
    /**
     * Adds a connection to the given room in the given direction
     * DOES NOT add the return connection
     */
    public void addConnection(char direction, Room room) {
    	go.put(direction, room);
    }
}