package com.bytethestarz.pingpong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class CreateWindowTwo extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs;
    String dataName = "heha";
    String intName = "huha";
    int defaultInt = 0;
    public static int hiScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //APongGame Ping = new APongGame(this);
        //setContentView(Ping);

    }

    /*public void LetsPLay(View view) {
        APongGame Ping = new APongGame(this);
        setContentView(view.Ping);

    }*/

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case  R.id.text:
                Intent i;
                i = new Intent(this, APongGame.class);
                startActivity(i);
                break;
            /*case R.id.button2:
                Intent j;
                j = new Intent(this,NinjaActivity.class);
                startActivity(j);
                break;*/
        }

   }

}
/*/*<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal"
//        android:background= "@drawable/background"*/
//android:onClick = "onBtnClick"/>
