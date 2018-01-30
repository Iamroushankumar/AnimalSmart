package com.example.lue.animalsmart;

import android.Manifest;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class Register_Activity extends AppCompatActivity  {


    EditText uname, upass, uemail, ucpass, uphone;
    Button register, cancle;
    ImageView headerrightarow,headerleftarrow;
    LocationManager locationManager;
    TextView headertext, textviewlocation;
    private String provider;

Location location;
    GpsTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Hello<><><><>","ONcreat of Register is called");
        setContentView(R.layout.activity_register_);
        uname = (EditText) findViewById(R.id.ename);
        uemail = (EditText) findViewById(R.id.eemail);
        ucpass = (EditText) findViewById(R.id.ecpass);
        upass = (EditText) findViewById(R.id.epass);
        uphone = (EditText) findViewById(R.id.ephone);
        register = (Button) findViewById(R.id.bregister);
        textviewlocation = (TextView) findViewById(R.id.tlocation);
        cancle = (Button) findViewById(R.id.bcancle);
        headertext = (TextView) findViewById(R.id.hatertext);
        headerrightarow = (ImageView) findViewById(R.id.rightarrow);
        headerleftarrow=(ImageView)findViewById(R.id.leftarrow);
        headerrightarow.setVisibility(View.INVISIBLE);
        headertext.setText("REGISTER");
        headertext.setVisibility(View.VISIBLE);
        headerleftarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Make code", Toast.LENGTH_SHORT).show();
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        textviewlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
                Log.d("HELLO<><><><>","Clicked");
                gps = new GpsTracker(Register_Activity.this);

                // check if GPS enabled
                if(gps.canGetLocation()){

                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Log.d("Hello<><><>",String.valueOf(latitude)+String.valueOf(longitude));
                    try {

                      String  adress = Register_Activity.this.getMyLocation(latitude,longitude);
                        textviewlocation.setText(adress);

                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.d("HELLO<><><><>",e.toString());
                    }
                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });



    }


    public String getMyLocation(double lat,double log) throws IOException {

//        progress = new ProgressDialog(this);
//        progress.setCancelable(true);//you can cancel it by pressing back button
//        progress.setMessage("File downloading ...");
//        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        progress.setProgress(0);//initially progress is 0
//        progress.setMax(100);//sets the maximum value 100
//        progress.show();
        Log.d("HELLO<><><><>", "Enter into function");
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        StringBuffer buffer=new StringBuffer();
        addresses = geocoder.getFromLocation(lat, log, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
Log.d("Hello<><><>",addresses.toString());
        String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
        String city = addresses.get(0).getLocality();
        String state = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        String postalCode = addresses.get(0).getPostalCode();
        String knownName = addresses.get(0).getFeatureName();
        buffer.append(address);
//        buffer.append("City- "+city+"\n");
//        buffer.append("State- "+state+"\n");
//        buffer.append("Country- "+country+"\n");
//        buffer.append("Pin- "+postalCode+"\n");
//        buffer.append(knownName);

        String adress=  buffer.toString();
        Log.d("Hello<><><>",adress.toString());
//        progress.dismiss();
        return adress;

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Hello<><><><>","OnStart of register is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Hello<><><><>","OnRestart register is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Hello<><><><>","OnResume  register is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Hello<><><><>","OnPause of register is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Hello<><><><>","OnStop of register is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Hello<><><><>","OnDestroy of register is called");
    }












}
