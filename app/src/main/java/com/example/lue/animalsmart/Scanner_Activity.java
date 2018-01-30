package com.example.lue.animalsmart;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import java.util.Scanner;
import java.util.logging.*;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner_Activity extends AppCompatActivity  {

    RatingBar ratingbar;
    ImageView headerrightarrow,headerleftarrow;
Handler handler;
    Button scan;
    TextView contactus, titletext;
    String rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Hello<><><><>","ONcreat of scanner is called");
        setContentView(R.layout.activity_scanner_);
        scan = (Button) findViewById(R.id.scan);
        ratingbar = (RatingBar) findViewById(R.id.rate);
        contactus = (TextView) findViewById(R.id.contact);
        titletext = (TextView) findViewById(R.id.hatertext);
        headerrightarrow = (ImageView) findViewById(R.id.rightarrow);
        headerleftarrow=(ImageView)findViewById(R.id.leftarrow);
        headerleftarrow.setVisibility(View.INVISIBLE);
        headerrightarrow.setVisibility(View.INVISIBLE);
        titletext.setText("USER ACTION");
        titletext.setVisibility(View.VISIBLE);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent i=new Intent(Scanner_Activity.this,Data_Show.class);
                startActivity(i);

            }
        });
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rate = String.valueOf(v);
                Toast.makeText(getApplicationContext(), rate, Toast.LENGTH_SHORT).show();
            }
        });


        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Contact_Form.class);
                startActivity(i);
            }
        });
    }




    @Override
    public void onResume() {
        super.onResume();
        Log.d("Hello<><><><>", "Resume of scanner is called");
        // Register ourselves as a handler for scan results.
//        mscanner.setResultHandler(this);
//        // Start camera on resume
//        mscanner.startCamera();
    }

//    @Override
//    public void onBackPressed() {
//Log.d("HELLO<><><><>", String.valueOf(handler.ZINGSCANNERVIEW));
//        Log.d("HELLO<><><><>", String.valueOf(handler.CAMERA_STATUS));
//        if(handler.ZINGSCANNERVIEW==1){
//            mscanner.stopCamera();
//            Log.d("Hello<><><><>", " status value chaged");
//            setContentView(R.layout.activity_scanner_);
//            handler.ZINGSCANNERVIEW=0;
//            handler.CAMERA_STATUS=0;
//
//            return;
//        }
//       else{
//            super.onBackPressed();
//            Log.d("Hello<><><><>", " NORMAL");
//        }
//
//    }

    @Override
    public void onPause() {

        super.onPause();
        // Stop camera on pause
        Log.d("Hello<><><><>", "OnPause of scanner is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Hello<><><><>", "OnStop of scanner is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Hello<><><><>", "OnDestroy of scanner is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Hello<><><><>", "OnStart of scanner is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Hello<><><><>", "OnRestart of Scanner is called");
    }
}
