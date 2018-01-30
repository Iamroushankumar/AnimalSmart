package com.example.lue.animalsmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrScannerHandler extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mscanner;
    Handler handler;
    String Data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner_handler);
        Log.d("HELLO<><><><>","qr scanner called");
        mscanner= new ZXingScannerView(this);
        handler =new Handler();
        mscanner = new ZXingScannerView(this);
        setContentView(mscanner);
        mscanner.setResultHandler(this);
//                handler.ZINGSCANNERVIEW=1;

        // Start camera on resume
        mscanner.startCamera();
        handler.CAMERA_STATUS=1;
    }

    @Override
    public void handleResult(Result rawResult) {
        Log.d("HELLO<><><><>", rawResult.getText()); // Prints scan results
        // Prints the scan format (qrcode, pdf417 etc.)
        Log.d("HELLO<><><><>", rawResult.getBarcodeFormat().toString());
        Data = rawResult.getText();

        Toast.makeText(this, Data, Toast.LENGTH_SHORT).show();
//        AlertDialog.Builder builder = new AlertDialog.Builder(Scanner_Activity.this);
//        builder.setTitle("Scan Result");
//        builder.setMessage(rawResult.getText());
//        AlertDialog alert1 = builder.create();
//        alert1.show();
        mscanner.stopCameraPreview();
        mscanner.stopCamera();
        handler.DATA=Data;
        Intent i=new Intent(this,Data_Show.class);
        startActivity(i);
        finish();
    }
    public void onPause() {

        super.onPause();
        if(handler.CAMERA_STATUS==1){
            mscanner.stopCamera();
        }
        // Stop camera on pause
        Log.d("Hello<><><><>", "OnPause of scanner is called");


    }
}
