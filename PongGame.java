import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener{
	
	static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
	private Ball gameBall;
	private Paddle userPaddle, pcPaddle;
	
	private int userMouseY;
	
	public static void Paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public PongGame(){
		gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
		
		userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
		
		pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);
		
		userMouseY = 0;
		
		//listen for motion events on this object
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//draws the ball
		gameBall.paint(g);
		
		//draws the paddles
		userPaddle.colour_paddles(g);
		pcPaddle.colour_paddles(g);
	}
	
	public void gameLogic(){
		//moves the ball one frame
		gameBall.moveBall();
		
		//makes the ball bounce or pass through edges
		gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
		
		//moves the paddle towards where the mouse is
		userPaddle.moveTo(userMouseY);
		
		//moves the PC paddle towards the ball y position
		pcPaddle.moveTo(gameBall.getY());
		
		//checks if ball has collided with either paddle
		if(pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)){
			//reverses the ball if it collides with either paddlegame
			gameBall.reverseX();
			
		}
		
	}
	
	public void mouseDragged(MouseEvent e){
		
		
		
	}
	
	
	public void mouseMoved(MouseEvent e){
		userMouseY = e.getY();
	}
	
	

}