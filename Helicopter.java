import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Helicopter here.
 * 
 * @author Jan Kroon 
 * @version 1
 */
public class Helicopter extends Actor
{
    private boolean isArmed = false;
    private Bomb currentBomb;
    private final int SENSITIVITY_LIMIT = 5;
    private int sensitivityCount = 0;
    
    /**
     * Constructor method
     */
    public void Helicopter() {
        setRotation(90);    
    }
    
    /**
     * Act - do whatever the Helicopter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Respond to arrow keystrokes with movements of Helicopter
        if (this.sensitivityCount == 0) {
            if (Greenfoot.isKeyDown("right")) { 
                setRotation(0); 
                move(1); 
            } 
            if (Greenfoot.isKeyDown("down")) { 
                setRotation(90); 
                move(1);
                System.out.println("CHECK Detected a key press");
            } 
            if (Greenfoot.isKeyDown("left")) { 
                setRotation(180); 
                move(1); 
            } 
            if (Greenfoot.isKeyDown("up")) { 
                setRotation(270); 
                move(1); 
            }
            if (this.isArmed == true && Greenfoot.isKeyDown("d")) { // drop bomb
               //TODO Logic for hits.
                
               // In caseMiss
               getWorld().removeObject(this.currentBomb);
               Greenfoot.playSound("Splat And Squirt-SoundBible.com-2136633229.wav");
               this.isArmed = false;
            }
            
        }
        
        //TODO Think about a nicer way to do this
        this.sensitivityCount++;
        if (sensitivityCount == SENSITIVITY_LIMIT) {
                sensitivityCount = 0;
        }
        
        /*
        if (Greenfoot.isKeyDown("A")) {
          //shipPosition = shipPosition.sub(Game.Vector2.UnitX.mul(dt).mul(300.0f));
          this.setLocation(this.getX() - delta, this.getY());
        }
        if (Greenfoot.isKeyDown("D")) {
          //shipPosition = shipPosition.add(Game.Vector2.UnitX.mul(dt).mul(300));
          this.setLocation(this.getX() + delta, this.getY());
        }
        if (Greenfoot.isKeyDown("W")) {
          //shipPosition = shipPosition.sub(Game.Vector2.UnitY.mul(dt).mul(300.0f));
          this.setLocation(this.getX(), this.getY()-delta);
        }
        if (Greenfoot.isKeyDown("S")) {
          //shipPosition = shipPosition.add(Game.Vector2.UnitY.mul(dt).mul(300.0f));
          this.setLocation(this.getX(), this.getY()+delta);
        }
        */
       // Pick up bomb, in case helicopter has no bomb yet
        Bomb b = (Bomb)this.getOneIntersectingObject(Bomb.class);
        if (this.isArmed == false && b != null) {
            b.pickedUp = true;
            b.helicopter = this;
            this.isArmed = true;
            this.currentBomb = b;
        }
        
    } 
}
