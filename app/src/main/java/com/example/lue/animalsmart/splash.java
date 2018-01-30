package com.example.lue.animalsmart;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Hello<><><><>","Oncreat of splash is called");
        setContentView(R.layout.activity_splash);
image=(ImageView)findViewById(R.id.imageView2);

        // Splash screen timer




            new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(splash.this, MainActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Hello<><><><>","OnStart of splash is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Hello<><><><>","OnRestart splash is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Hello<><><><>","OnResume  splash is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Hello<><><><>","OnPause of splash is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Hello<><><><>","OnStop of splash is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Hello<><><><>","OnDestroy of splash is called");
    }
}
