import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GraphicsConfiguration;

//The class is supposed to be able to be called
//called to create window; set size ; set colour

//in main/logical class the window should be called for example(CreateWindow win = new CreateWindow();
win.size(23, 45); and that should make window to our settings

public class CreateWindow{
  static JFrame frame = new JFrame("Pings Pongs");

  public static void main(String[] args){
    //exit n clse makes it possible so that the program exits on close button
    frame.setDefaultCloseOperation(WindowConstans.EXIT_ON_CLOSE);

    frame.setSize(700, 550);

    PongGame game = new PongGame();

    frame.add(game);

    frame.setVisible(true);

  }
}
//do not use code below for now
/*public class CreateWindow{
  public static void main(String[] args){
    JFrame frame = new JFrame();
    frame.setSize(600,400);  //size adjustable,DO NOT PRESS THE ENLARGE BUTTON!!!!!
	Color c = new Color(0,0,0);
	frame.getContentPane().setBackground(c);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Test Frame");
    frame.setVisible(true);
  }*/
