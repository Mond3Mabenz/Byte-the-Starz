public class Ball{
	private int x, y, cx, cy, speed, size;
	private Color color;

        //this "Ball" method actually constructs the ball with established variables above.
	public Ball(int x, int y, int cx, int cy, int speed, Color color, int size){
		this.x = x;
		this.y = y;
		this.cx = cx;
		this.cy = cy;
		this.speed = speed;
		this.color = color;
		this.size = size;
		
	}
	
	public void paint(Graphics g){
                //sets the brush colour to the ball colour
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
		
		if(x < 0){
			reverseX();
		}
		else if(x > 640 - size){
			reverseX();
		}
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
}