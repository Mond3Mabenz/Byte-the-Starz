package com.bytethestarz.pingpong;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class APaddle {
    //this was inspired from https://kevinsguides.com/guides/code/java/javaprojs/simple-2d-pong#paddles
    //syntaxes
    //declare instance variables
    //Bitmap
    int height, xdir, ydir, velocity;//paddle
    int cx, cy;
    Paint p;
    Context cont;
    int width = 15;
    //TODO: go back to this as this is how the objects relate to one another, thank you
    int screenWidth;
    int screenHeight;
    /*The paddles are rectangles that moves vertaically.
    -The height parameter: height of the paddle
    -The velocity parameter: The speed at which tha paddles move
    -The xdir parameter: The x-position on which to start drawintg the paddle
    -The ydir parameter: The y-position on which to start drawing the paddle*/


    public APaddle(Canvas canvas, int x, int y, int cx, int cy, int speed, int size){
        p.setColor(Color.argb(255,51,204,255));
        p.setTextSize(30);
        canvas.drawRect(x - (cx/2), y-(cy/2),x+(cx/2), y+(cy/2), p);

    }

    public void moveTo(int orig_center){

        int padd_center = ydir + height/2;  //The y-positin of the paddles center

        //Check if the paddle needs to move more than the speed-value away from current position
        if(Math.abs(padd_center - orig_center)> velocity){

            //f the center of the paddle is too low, move paddle up by the speed
            if(padd_center > orig_center){
                ydir -= velocity;
            }

            //If the center of the paddle is higher than the original center of the paddle, move paddle down by speed
            if(padd_center < orig_center){
                ydir += velocity;
            }
        }
    }
    /* Need to determine collision of the ball on the paddle
    -Determine the posiotion of the ball against the paddle position.
    -The ball is colliding with the paddle if its  x-position lies between the right and left side and the y-position lies between top and bottom of paddle
    -The parameter b - the ball we're checking for collisions
    -Return true if the ball collides
    */
    public boolean checkCollision(ABall b){
        int right = xdir + width;
        int bottom = ydir + height;

        //Check if ball is between the right and left values
        if(b.getX()>(xdir - b.getSize()) && b.getX()< right){

            // Check if ball is between top andf bottom
            if(b.getY() > ydir && b.getY()< bottom){
                return true;
            }
        }
        return false;
    }

}
