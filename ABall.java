package com.bytethestarz.pingpong;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ABall {
    //reference https://kevinsguides.com/guides/code/java/javaprojs/simple-2d-pong as a template
    Bitmap BallPaddle; //Paddle
    int x, y, cx, cy, speed, size; //Paddle
    Paint p;
    //int width = 15;

    public ABall(Canvas canvas, int xdir, int ydir, int width, int velocity) {

        //own code
        p.setColor(Color.argb(255,255,255,255));
        p.setTextSize(30);
        canvas.drawCircle(xdir, ydir, width, p);
    }

    //ball code
    //public void paint(Graphics g){
    //https://www.javatpoint.com/java-awt-canvas
    //paints in the given paremeters with the colour given
    //g.setColor(color);
    //g.fillOval(x, y, size, size);
    //}

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

    public int getY(){ //accessor
        return y;
    }

    public int getX(){ //accessor
        return x;
    }

    public int getSize(){ //accessor
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

