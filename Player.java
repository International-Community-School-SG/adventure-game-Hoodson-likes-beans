public class Player extends ObjectWithInventory{
	
	/**
	 * The name of the player
	 */
	private String name; 
	
    private int health = 100;

    
    
    private int damage = 25;
    /**
	 * The room the player is currently in
	 */
    public Room room = new Room("VOID","Not a real room");
    /**
     * Is the player currently playing, set to false when the game is over.
     */
    private boolean playing = true; 
	
	/**
	 * initialization only takes the name of the player.
	 */
	public Player(String myName) {
		name = myName;
		
	}
	public int getHealth() {
		return health;
		
	}
	public int getDamage() {
		return damage;
		
	}
    
    public int damageTaken(int damage){
		health -= damage;
        
        if(health <= 0 )
        {
            System.out.println("You are dead, type respawn to start again");
            
            return 0;
            
        }
		 return health;
	}
    public void addDamage()
    {
        damage++;
    }
    
    public String toString() {
		return name;
	}
	
	
    /**
	 * Moves the player in the given direction if possible.
	 * 
	 * Sets the room of the player to the new room.
	 * 
	 * @param direction - the direction to try to move
	 * 
	 * @return true if the move was successful
	 */
	public boolean go(char direction) {
		if(room.go.get(direction) != null) {
			room = room.go.get(direction);
			return true;
		}
		return false;
	}
	
	/**
	 * attempts to take the given item from the room
	 * 
	 * Removes the item from current room and adds it to the inventory
	 * 
	 * @param name - the name of the item to attempt to take
	 * 
	 * @return true if successful
	 */
	public boolean take(String name) {
		
		Item item = room.removeItem(name);
		if(item != null) {
			addItem(item);
			return true;
		}
		return false;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	
}