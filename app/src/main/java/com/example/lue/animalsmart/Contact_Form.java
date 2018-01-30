package com.example.lue.animalsmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Contact_Form extends AppCompatActivity {
EditText edittextto,edittextsubject,edittextmessage;
    TextView headertext;
    Button contactsend;
    ImageView headerrightimg,headerleftimg;
    String To,Subject,Message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__form);
        edittextto=(EditText)findViewById(R.id.to);
        edittextmessage=(EditText)findViewById(R.id.message);
        edittextsubject=(EditText)findViewById(R.id.subject);
        contactsend=(Button)findViewById(R.id.contactsend);
        headerleftimg=(ImageView)findViewById(R.id.leftarrow);
        headerrightimg=(ImageView)findViewById(R.id.rightarrow);
        headertext=(TextView)findViewById(R.id.hatertext);
        headertext.setVisibility(View.VISIBLE);
        headertext.setText("CONTACT FORM");
        headerrightimg.setVisibility(View.INVISIBLE);
        headerleftimg.setVisibility(View.VISIBLE);
        headerleftimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Scanner_Activity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
finish();
            }
        });


        contactsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              sendData();
            }
        });
    }

    public void sendData(){

      To=  edittextto.getText().toString();
        Subject=edittextsubject.getText().toString();
        Message=edittextmessage.getText().toString();
        Intent mail =new Intent(Intent.ACTION_SEND);
        mail.putExtra(Intent.EXTRA_EMAIL,new String[]{To});
        mail.putExtra(Intent.EXTRA_SUBJECT,Subject);
        mail.putExtra(Intent.EXTRA_TEXT,Message);
        mail.setType("message/rfc822");
        startActivity(Intent.createChooser(mail,"Send Email Via :"));
    }
}
