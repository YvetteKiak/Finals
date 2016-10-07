package com.example.yvette.finals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by benjarmanalili on 16/07/2016.
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ImageView imgView= (ImageView)findViewById(R.id.imageViewLogo);
    Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(3000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            finally{
                Intent intent = new Intent(SplashScreen.this,Login.class );
                startActivity(intent);
            }
        }
    };
        timerThread.start();
    }

    @Override
    protected  void onPause(){
        super.onPause();
        finish();
    }
}
