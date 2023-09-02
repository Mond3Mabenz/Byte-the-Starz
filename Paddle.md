import java.awt.*;
//this is import we used for java when we want to colour our paddle
public class paddle {
    private int height,xdir,ydir,velocity;
    private Color paddcolor;

    static int width = 15;

  
    public void Paddle(int xdir,int ydir,int height,int velocity){
        this.xdir = xdir;
        this.ydir = ydir;
        this.height = height;
        this.velocity = velocity;
        this.paddcolor = paddcolor;
    }
    public void colour(Graphics g){
        g.setColor(paddcolor);
        g.fillRect(xdir,ydir,width,height);
    }
}
