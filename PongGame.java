import javax.swing.*;

public class PongGame extends JPanel{
	
	static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
	
	public void(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public PongGame(){
		gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
		
		userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
		
		pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		gameBall.paint(g);
		
		userPaddle.paint(g);
		pcPaddle.paint(g);
	}
	
	public void gameLogic(){
		gameBall.moveBall();
		
		gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
	}
	
	

}