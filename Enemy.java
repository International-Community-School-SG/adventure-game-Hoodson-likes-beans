public class Enemy extends Player
{
    private int damage  = 0;
    private int health = 50;
    private String name = "";
    private String description = "";
    
    public Enemy(String nm, String desc, int hp, int dm)
    {
        health = hp;
        name = nm;
        description = desc;
        damage = dm;
    }
    public boolean isDead()
    {
        if(health <=0)
        return true;
            
    }
        else{
            return false
        }
}
