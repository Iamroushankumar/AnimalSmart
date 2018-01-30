package com.example.lue.animalsmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Data_Show extends AppCompatActivity implements ZXingScannerView.ResultHandler{
TextView show;
    ImageView headerleftimage,headerrightimage;
    TextView headertextview;
  Handler handler;
    Button scan;

    String Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__show);
      handler=new Handler();
        headertextview=(TextView)findViewById(R.id.hatertext);
        headertextview.setText("FETCH DATA");
        headertextview.setVisibility(View.VISIBLE);
        headerleftimage=(ImageView)findViewById(R.id.leftarrow);
        headerrightimage=(ImageView)findViewById(R.id.rightarrow);
        headerrightimage.setVisibility(View.INVISIBLE);
        headerleftimage.setVisibility(View.VISIBLE);
        headerleftimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Data_Show.this,Scanner_Activity.class);
                startActivity(i);
                finish();
            }
        });
        show=(TextView)findViewById(R.id.Datashow) ;


        scan=(Button)findViewById(R.id.scaning);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Data_Show.this,QrScannerHandler.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void handleResult(Result rawResult) {


    }


    @Override
    protected void onResume() {
        super.onResume();
        String Data=handler.DATA;
        Log.d("HELLO<><><><>","Data");
        show.setText(Data);
        handler.DATA="";
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.DATA="DATA WILL BE HERE AFTER SCAN";
    }
}
