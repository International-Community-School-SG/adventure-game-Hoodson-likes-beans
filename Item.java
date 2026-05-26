public class Item{
    
    /**
     * The name of the Item (should be in all CAPS to match rest of code)
     */
    private String name;  
    /**
     * The description of the item
     */
    private String description;  
    
     
    /**
     * Creates an item with the given information
     * 
     * @param myName - the name
     * @param myDescription - the description
     * 
     */
    public Item(String myName, String myDescription){
        name = myName;
        description = myDescription;
    }
    
    private boolean isWeapon(Item item)
    {
       //change ts later
        if (item == item)
        {
            return true;
        }
        return false;
    }
    
    /**
     * The string is the name and description.
     */
    public String toString(){
        return name + "\n" + description;
    }
    
    
    public String getName() {
    	return name;
    }
    
}