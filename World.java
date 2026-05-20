import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class World{
	
	/**
	 * A Map is a fancy form of ArrayList where the indexes are not integers, but rather any datatype you choose
	 * 
	 * In this case, rooms is a mapping from a String to a Room object
	 * 
	 * This will store all of the rooms in your world.
	 */
	public Map<String,Room> rooms = new HashMap<String,Room>();
	
	/**
	 * The room that the player will start in.
	 */
	public Room start;
    
	/**
	 * Upon initialization of the class, all the Rooms are created.
	 */
	public World() {
		initializeRooms();
	}

    /**
     * The whole world is created here.
     * 
     * If the world is complicated enough, it might be reasonable to have different methods for different levels
     */
	public void initializeRooms() {
		/**
		 * An arraylist of items that will be added to each room, needs to be reset for each room.
		 */
		ArrayList<Item> stuff = new ArrayList<Item>();
		
		/**
		 * Room 1 - This is a basic starter room
		 * 
		 * Contains two items, THING1 & THING2
		 */
		 
		//Creates level 1 rooms
        stuff.add(new Item("Chest","add later"));
        String name = "L1.1.1";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        name = "L1.1.2";
		rooms.put(name,new Room(name,"This is the next room."));
        
        name = "L1.1.3";
		rooms.put(name,new Room(name,"This is the next room."));
        
        stuff.add(new Item("Enemies","add later"));
        name = "L1.1.4";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        name = "L1.1.5";
		rooms.put(name,new Room(name,"This is the next room."));
        
        name = "L1.2.1";
		rooms.put(name,new Room(name,"This is the next room."));
		
        stuff.add(new Item("Enemies","add later"));
        name = "L1.2.2";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Enemies","add later"));
        name = "L1.2.3";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        name = "L1.2.4";
		rooms.put(name,new Room(name,"This is the next room."));
        
        stuff.add(new Item("Chest","add later"));
        name = "L1.2.5";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Enemy","add later"));
        name = "L1.3.1";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        name = "L1.3.2";
		rooms.put(name,new Room(name,"This is the next room."));
        
        stuff.add(new Item("Start","add later"));
        name = "L1.3.3";
		rooms.put(name,new Room(name,"This is the next room."));
        stuff.clear();
        
        name = "L1.3.4";
		rooms.put(name,new Room(name,"This is the next room."));
        
        stuff.add(new Item("Enemy","add later"));
        name = "L1.3.5";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Chest","add later"));
        name = "L1.4.1";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Enemy","add later"));
        name = "L1.4.2";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        name = "L1.4.3";
		rooms.put(name,new Room(name,"This is the next room."));
        
        stuff.add(new Item("Enemy","add later"));
        name = "L1.4.4";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Enemy","add later"));
        name = "L1.4.5";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Key","add later"));
        name = "L1.5.1";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Enemy","add later"));
        name = "L1.5.2";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        stuff.add(new Item("Enemy","add later"));
        name = "L1.5.3";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        name = "L1.5.4";
		rooms.put(name,new Room(name,"This is the next room."));
        
        stuff.add(new Item("Chest","add later"));
        name = "L1.5.5";
		rooms.put(name,new Room(name,"This is where it starts.",new Inventory(stuff)));
		stuff.clear();
        
        //Creates level 2 rooms
		
	 // This is important to reset the items for each room.
		stuff.add(new Item("ROCK","Pretty hard."));
		
		rooms.put("ROOM4",new Room("ROOM4","This is the next room.",new Inventory(stuff)));
	
		addConnections("ROOM1","ROOM2",'N');  // by default this will add a connection both ways
		addConnections("ROOM2","ROOM3",'N',false);  // now the player will be stuck in room 3
		addConnections("ROOM1","ROOM4",'E');
		
		
		
		// Be sure to set the start room!  Replace ROOM1 with your room names.
		start = rooms.get("ROOM1");
	}
	
	/**
	 * Adds a connection between two rooms.
	 * 
	 * @param from  the name of the first room
	 * @param to    the name of the second room
	 * @param dir   the direction traveled to get from the first room to the second room
	 * @param both  should the connection also be created in the other direction?
	 */
	public void addConnections(String from, String to, char dir, boolean both) {
		Room From = rooms.get(from);
		Room To = rooms.get(to);
		
		From.addConnection(dir,To);
		
		/**
		 * A map to find the opposite direction for a given direction
		 * 
		 * Needs to be COMPLETED with the other directions
		 */
		Map<Character,Character> opposite = new HashMap<Character,Character>();
		
		opposite.put('N', 'S');
		opposite.put('S', 'N');
		opposite.put('E', 'W');
		opposite.put('W', 'E');
		//Need to complete opposite for other directions
		
		if(both) {
			To.addConnection(opposite.get(dir),From);
		}
		
	}
	
	/**
	 * If the boolean is not given, the connection will be made in both directions.
	 */
	public void addConnections(String from, String to, char dir) {
		// Allows a default of true for both directions connection
		
		addConnections(from, to, dir, true);
	}
	
	
	
}