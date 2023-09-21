import java.awt.FlowLayout;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
public class WelcomeButton {

	
    public static void main(String s[]) {  
        JFrame frame = new JFrame("JFrame Example");  
        JPanel panel = new JPanel();  
        panel.setLayout(new FlowLayout()); 

		
        JLabel label = new JLabel("Welcome to Ping Pong");  
        JButton button = new JButton();  
        button.setText("Lets PLAY!!");
		
        panel.add(label);  
        panel.add(button);  
        frame.add(panel); 

		
        frame.setSize(900, 900);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}  
