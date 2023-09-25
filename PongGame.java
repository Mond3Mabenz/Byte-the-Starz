import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener{
	//Extends? 
	//implements
	
	static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 512;
	private Ball gameBall;
	private Paddle userPaddle , pcPaddle;
    
	private int userScore , pcScore  ;//this will be the initialiser
	private int userMouseY;
	
	//addMouseMotionListener(this);

	
	public PongGame(){
		gameBall = new Ball(300, 200, 3, 3, 200, Color.BLACK, 25);
		userPaddle = new Paddle(10, 200, 75, 3, Color.CYAN);
		pcPaddle = new Paddle(765, 200, 75, 3, Color.MAGENTA);

		userMouseY = 0;
		//listen for motion event on this object(the mouse)
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g){
		
		g.setColor(Color.PINK);
		g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//draws the ball
		gameBall.paint(g);
		
		//draws the paddles
		userPaddle.colour_paddles(g);
		pcPaddle.colour_paddles(g);

		//updates the score
		//Under Scoring at Kevin guides for simple 2d game for java
		//DRAWSTRING METHOD NEEDS A STRING TO PRINT AND LOCATION TO PRINT AT
		//SORTA LIKE HOW TURLE WORKED BY REPOSITIONING IT THEN SETTING IT DOWN AND DRAWING
		
		g.setColor(Color.BLACK);
		g.drawString("Score - USER [ " + userScore + " ] PC [ " + pcScore + " ] ", 250, 20);
		//checks if player lost a point? checks if  paddle failed to collide with the ball
			if(gameBall.getX() < 0){
				//the player has lost a point
				pcScore++;
				resetz();
			}
			else if(gameBall.getX() > WINDOW_WIDTH){
				//THE PC HAS LOST
				userScore++;
				resetz();
			}
	}
	
	public void gameLogic(){
		//moves the ball one frame
		gameBall.moveBall();
		
		//makes the ball bounce or move through the edges
		gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
		
		//paddles will move to where the balll is
		userPaddle.moveTo(userMouseY);

		//moves pc paddle to where the ball y position should be
		pcPaddle.moveTo(gameBall.getY());

		if(pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)){
			//moves the ball to move in the opposite direction if it collides with either paddle
			gameBall.reverseX();		
		}
	}
	public void mouseDragged(MouseEvent e){


	}
	public void mouseMoved(MouseEvent e){
		userMouseY = e.getY();

	}
	//this resets for new rounds so that there isnt a continuation when someone loses a point
	public void resetz(){
		//pause for a second or so to give players a breather
		//for this to work the ball class requires setters
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}


		gameBall.setX(300);
		gameBall.setY(200);
		gameBall.setCx(3);
		gameBall.setCy(3);
		gameBall.setSpeed(3);
		int bounceCount = 0;
	}
}
