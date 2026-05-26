public class Enemy extends Player
{
    
    private int health = 50;
    private String type = "";
    
    public Enemy(int hp, String enemyType)
    {
        health = hp;
        type = enemyType;
    }
    
}