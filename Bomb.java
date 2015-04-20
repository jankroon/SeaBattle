import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author Jan Kroon 
 * @version 1
 */
public class Bomb extends Actor
{
    boolean pickedUp = false;
    Helicopter helicopter;
    
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (this.pickedUp == true) {
            // Follow movements of Helicopter
            this.setLocation(helicopter.getX(), helicopter.getY());
            this.setRotation(helicopter.getRotation()+90);
        }
    }    
}
