import java.awt.*;

public class Paddle{
    
    //declare instance variables
    private int height, xdir, ydir, velocity;
    private Color paddcolor;

    static final int width = 15;

    /*The paddles are rectangles that moves vertaically.
    -The height parameter: height of the paddle
    -The velocity parameter: The speed at which tha paddles move
    -The xdir parameter: The x-position on which to start drawintg the paddle
    -The ydir parameter: The y-position on which to start drawing the paddle

    */

    public Paddle(int xdir,int ydir,int height,int velocity, Color paddcolor){
        this.xdir = xdir;
        this.ydir = ydir;
        this.height = height;
        this.velocity = velocity;
        this.paddcolor = paddcolor;
    }
    //colour in the paddles
    //g- garaphics object
    public void colour_paddles(Graphics g){
        g.setColor(paddcolor);
        g.fillRect(xdir,ydir,width,height);
    }

    // The paddles move towards a y center position
    // The orig_center parameter: the position the paddle is centered on and also 

    public void moveTo(int orig_center){
        
        int padd_center = ydir + height/2;  //The y-positin of the paddles center

        //Check if the paddle needs to move more than the speed-value away from current position
        if(Math.abs(padd_center - orig_center)> velocity){

            //f the center of the paddle is too low, move paddle up by the speed
            if(padd_center > orig_center){ 
                ydir -= velocity;
            }

            //If the center of the paddle is higher than the original center of the paddle, move paddle down by speed
            if(padd_center < orig_center){ 
                ydir += velocity; 
            }
        }
    }
    /* Need to determine collision of the ball on the paddle
    -Determine the posiotion of the ball against the paddle position.
    -The ball is colliding with the paddle if its  x-position lies between the right and left side and the y-position lies between top and bottom of paddle
    -The parameter b - the ball we're checking for collisions
    -Return true if the ball collides
    */
    public boolean checkCollision(Ball b){
        int right = xdir + width;
        int bottom = ydir + height;

        //Check if ball is between the right and left values
        if(b.getX()>(xdir - b.getSize()) && b.getX()< right){

            // Check if ball is between top andf bottom
            if(b.getY() > ydir && b.getY()< bottom){
                return true;
            }
        }
        return false;
    }
	
	
}
