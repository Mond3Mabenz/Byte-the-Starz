import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GraphicsConfiguration;

public class CreateWindow{
  public static void main(String[] args){
    JFrame frame = new JFrame();
    frame.setSize(600,400);  //size adjustable,DO NOT PRESS THE ENLARGE BUTTON!!!!!
	Color c = new Color(0,0,0);
	frame.getContentPane().setBackground(c);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Test Frame");
    frame.setVisible(true);
  }
}
