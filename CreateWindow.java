import javax.swing.JFrame;  ///what use do these imports have
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;  
import java.awt.*;

//THIS CLASS IS SUPPOSED TO BE ABLE TO BE CALLED AND CREATE THE WINDOW TO OUR SPECIFICITIES
//The class is supposed to be able to be called
//called to create window; set size ; set colour

//in main/logical class the window should be called for example(CreateWindow win = new CreateWindow();
//win.size(23, 45); and that should make window to our settings

public class CreateWindow implements ActionListener{
  JFrame jf;
  JButton b1;
  JLabel label;
  static JFrame frame = new JFrame("Pings Pongs");
  Container pane = frame.getContentPane();
  //static JButton b1 = new JButton("Button");
  //new WelcomeButton();
  //exit n clse makes it possible so that the program exits on close button
  public static void main(String[] args){
    new CreateWindow();
  } 
  CreateWindow(){
    jf = new JFrame("Example Buttons");
    b1 = new JButton("Let's Play!!");
    label = new JLabel();
    b1.setSize(70, 40);
    jf.add(b1);
    //jf.add(b2);
    jf.add(label);
    
    b1.addActionListener(this);
    jf.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 250));
    //the layout sets in position
    jf.setSize(800, 550); //change width
    jf.setVisible(true);
  }


  public void actionPerformed(ActionEvent ae) {
      if (ae.getActionCommand().equals("Let's Play!!")) {
        jf.dispose();
        pane.remove(b1);
        pane.repaint();//removes the button and game starts
        
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //size of JFrame needs to be slighty bigger
        frame.setSize(800, 550); //size of the window
            
        PongGame game = new PongGame();
        frame.add(game);
        frame.setVisible(true);
        //the ball will move with below code
          Timer timer = new Timer(40, new ActionListener(){
            public void actionPerformed(ActionEvent e){
              // calls in the game logic
              game.gameLogic();

              //repaints the screen
              game.repaint();
            }      
          
          });
          timer.start(); 
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

