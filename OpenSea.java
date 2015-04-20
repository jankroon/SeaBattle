import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpenSea here.
 * 
 * @author Jan Kroon 
 * @version 1
 */
public class OpenSea extends World
{
    private final int DBB = 1; // Distance Between Bombs
    //int[] locations;
    //private ArrayList<Ship> fleet = new ArrayList<Ship>();
    
    /**
     * Constructor for objects of class OpenSea.
     */
    public OpenSea()
    {    
        // Create a new world with 10x11 cells with a cell size of 50x50 pixels.
        super(10, 11, 50);
        
        // Position bombs
        for(int i=0; i<10; i++){
                Bomb b = new Bomb();
                this.addObject(b, DBB*i, 10);
        }
            
        // Position helicopter
        Helicopter h = new Helicopter();
        this.addObject(h, 5, 5);
        
        //TODO Make random lay-out of ships (like setUpGame() in chapters 5 and 6 of Head First Java)
    }
    
    
    public String bombingResult(int row, int col) {
    
    //TODO Returns either "miss", "hit" or "Ouch! You sunk a .... kill" 
    return "test";
    }
}
