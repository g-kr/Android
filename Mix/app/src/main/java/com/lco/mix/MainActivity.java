package com.lco.mix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button call,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencall();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browser();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datatransfer();


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try{
                   whatsapp();
               }
               catch (Exception e){
                   e.printStackTrace();
               }

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thirdactivity();

            }
        });








    }
    private void opencall(){
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:797869703"));
        startActivity(intent);
    }
    private void browser(){
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://learncodeonline.in"));
        startActivity(i);
    }
    private void whatsapp(){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(intent.EXTRA_TEXT,"this is my text message");
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }
    public void datatransfer(){
        Intent i=new Intent(this,SecondAction.class);
        i.putExtra("name","gulshan");
        i.putExtra("name","raushan");
        startActivity(i);



    }
    public void Thirdactivity(){
        Intent i=new Intent(this,ThirdActivity.class);

    }



}
