import java.awt.*;

public class BallPaddle{
    
    //declare instance variables
    private int height, xdir, ydir, velocity;
    private Color paddcolor;

    private int x, y, cx, cy, speed, size;
	private Color color;

    static final int width = 15;

    /*The paddles are rectangles that moves vertaically.
    -The height parameter: height of the paddle
    -The velocity parameter: The speed at which tha paddles move
    -The xdir parameter: The x-position on which to start drawintg the paddle
    -The ydir parameter: The y-position on which to start drawing the paddle

    */
   public BallPaddle(int x, int y, int cx, int cy, int speed, Color color, int size){ //this is constructor for ball
		this.x = x;
		this.y = y;
		this.cx = cx;
		this.cy = cy;
		this.speed = speed;
		this.color = color;
		this.size = size;
		
	}
    public BallPaddle(int xdir,int ydir,int height,int velocity, Color paddcolor){ //this for the paddle
        this.xdir = xdir;
        this.ydir = ydir;
        this.height = height;
        this.velocity = velocity;
        this.paddcolor = paddcolor;
    }
    //paddle code
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
    public boolean checkCollision(BallPaddle b){
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

    //if
    //ball code
    public void paint(Graphics g){
		g.setColor(color);
		
		g.fillOval(x, y, size, size);
		
	}
	
	public void moveBall(){
		x += cx;
		y += cy;
	}
	
	public void bounceOffEdges(int top, int bottom){
		
		//if the y value is at the bottom of the screen
		if(y > bottom - size){
			reverseY();
		}
		//if y value is a the top of the screen
		else if(y < top){
			reverseY();
		}
		//ball wont need to bounce of the y-axis as it needs to go through
		
	}
	
	//Reverse's the ball's change in x value
	public void reverseX(){
		cx *= -1;
	}
	
	//Reverse's the ball's change in y value
	public void reverseY(){
		cy *= -1;
	}
	
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getSize(){
		return size;
	}

	public void setX(int n){
		this.x = n;
	}
	public void setY(int n){
		this.y = n;
	}
	public void setCx(int n){
		this.cx = n;
	}
	public void setCy(int n){
		this.cy = n;
	}
	public void setSpeed(int n){
		this.speed = n;
	}
}
