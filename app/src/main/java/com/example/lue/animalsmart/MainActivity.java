package com.example.lue.animalsmart;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
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

import org.w3c.dom.Text;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.CAMERA;

public class MainActivity extends AppCompatActivity {

EditText user,pass;
    Button login;
    ImageView headerleftarrow,headerrightarrow;
    TextView register,headertext;
    Boolean isPermitted=false;
    public static final int RequestPermissionCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Hello<><><><>","ONcreat of main is called");
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.user);
                pass=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        headerleftarrow=(ImageView)findViewById(R.id.leftarrow);
        headerrightarrow=(ImageView)findViewById(R.id.rightarrow);

        register=(TextView)findViewById(R.id.tregister);
        headertext=(TextView)findViewById(R.id.hatertext);

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent i=new Intent(getApplicationContext(),Scanner_Activity.class);
        startActivity(i);
    }
});
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Register_Activity.class);
                startActivity(i);
            }
        });



        checkRunTimePermission();

    }



    private void checkRunTimePermission() {

        if(checkPermission()){

          Toast.makeText(MainActivity.this, "All Permissions Granted Successfully", Toast.LENGTH_LONG).show();

        }
        else {

            requestPermission();
        }
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {
                        CAMERA,
                        ACCESS_COARSE_LOCATION

                }, RequestPermissionCode);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case RequestPermissionCode:

                if (grantResults.length > 0) {

                    boolean CameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean ReadContactsPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
//                    boolean ReadPhoneStatePermission = grantResults[2] == PackageManager.PERMISSION_GRANTED;

                    if (CameraPermission && ReadContactsPermission ) {

                        Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();

                    }
                }

                break;
        }
    }

    public boolean checkPermission() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int SecondPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_COARSE_LOCATION);
//        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_PHONE_STATE);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED ;
//                ThirdPermissionResult == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Hello<><><><>","OnStart of main is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Hello<><><><>","OnRestart main is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Hello<><><><>","OnResume  main is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Hello<><><><>","OnPause of main is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Hello<><><><>","OnStop of main is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Hello<><><><>","OnDestroy of main is called");
    }
}
