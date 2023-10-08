package com.bytethestarz.pingpong;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
//import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;

import androidx.core.content.res.ResourcesCompat;


public class APongGame extends Activity {
    //Extends?
    //implements

    static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 512;
    //BallPaddle gameBall;
    //BallPaddle userPaddle , pcPaddle;

    int userScore, pcScore;//this will be the initialiser
    int userMouseY;
    Canvas canvas;
    boolean gameStopped = false;
    Context cont;
    Bitmap Bground; //background\

    Rect rectB;
    Handler hand;
    Runnable runZ;
    int Bw, Bh; //background

    Paint txtP = new Paint();
    Paint txtScore = new Paint();
    Paint paint;
    int TEXT_SIZE = 120;
    ABall gameBall;
    APaddle userPaddle, pcPaddle;
    //int userScore, pcScore;
    int Score;
    // line 55 to 61: https://gist.github.com/munish7771/d4fdfb686c57627276d6
    boolean left;
    boolean right;
    boolean up;
    boolean down;
    boolean r_left;
    boolean r_right;
    //TODO: go back to this as this is how the objects relate to one another, thank you
    //addMouseMotionListener(this);


    public APongGame(Context cont) {
        super(cont);
        this.cont = cont;
        Bground = BitmapFactory.decodeResource(getResources(), R.drawable.cground);
        gameBall = new ABall(canvas, 300, 200, 3, 300); //ball
        userPaddle = new APaddle(canvas, 10, 200, 75, 3, 40, 40); //paddle
        pcPaddle = new APaddle(canvas, 765, 200, 30, 3, 40, 40);//paddle


        Display display = ((Activity) getContext()).getWindowManager().getCurrentWindowMetrics();
        Point size = new Point();
        display.getSize(size);
        Bw = size.x;
        Bh = size.y; //devising the height and width

        rectB = new Rect(0, 0, Bw, Bh);
        hand = new Handler();
        runZ = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        txtP.setColor(Color.rgb(255, 165, 0));
        txtP.setTextSize(TEXT_SIZE);
        txtP.setTextAlign(Paint.Align.CENTER);

        txtP.setTypeface(ResourcesCompat.getFont(cont, R.font.arcade));
        txtScore.setColor(Color.BLACK);
        //paddle position
        //TODO: Start here tomorrow;

    }

    protected void set(Canvas canvas) {

        super.onCreate(canvas);

        canvas.drawText("Score - USER [ " + userScore + " ] PC [ " + pcScore + " ] ", 20, 40, paint);
        canvas.drawBitmap(Bground, null, null);

    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((userPaddle.xdir <= Bw - userPaddle.cx / 2) || (userPaddle.cx >= userPaddle.cx / 2)) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (motionEvent.getX() >= Bw / 2) {
                        r_left = false;
                        r_right = true;
                    } else {
                        r_left = true;
                        r_right = false;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    r_right = false;
                    r_left = false;
                    break;
            }
        }
        return true;

    }

    public void gameLogic() {
        //moves the ball one frame
        gameBall.moveBall();

        //makes the ball bounce or move through the edges
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);

        //paddles will move to where the balll is
        userPaddle.moveTo(userMouseY);

        //moves pc paddle to where the ball y position should be
        pcPaddle.moveTo(gameBall.getY());

        if (pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)) {
            //moves the ball to move in the opposite direction if it collides with either paddle
            gameBall.reverseX();
        }
    }

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

        if(userScore >= 7 || pcScore >= 7){
            gameStopped = true;
        }
    }
}







