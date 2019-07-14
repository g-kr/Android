package com.lco.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView fb,amazaon,flip,insta,gaana,spotify,myntra,jab,whats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fb=findViewById(R.id.facebook);
        amazaon=findViewById(R.id.amazon);
        flip=findViewById(R.id.flipkart);
        insta=findViewById(R.id.instagram);
        gaana=findViewById(R.id.gaana);
        spotify=findViewById(R.id.spotify);
        myntra=findViewById(R.id.myntra);
        whats=findViewById(R.id.whatsapp);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebook();
            }
        });
        amazaon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amazon();
            }
        });
        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipkart();
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                instagram();
            }
        });
        gaana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gaana();
            }
        });
        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spotify();
            }
        });
        myntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myntra();
            }
        });
        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whatsapp();
            }
        });
    }
    public void facebook(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.facebook.com");
        startActivity(intent);
    }
    public void amazon(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.amazon.in");
        startActivity(intent);
    }
    public void flipkart(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.flipkart.com");
        startActivity(intent);
    }
    public void instagram(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.instagram.com");
        startActivity(intent);
    }
    public void gaana(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.gaana.com");
        startActivity(intent);
    }
    public void spotify(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.spotify.com");
        startActivity(intent);
    }
    public void myntra(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.myntra.in");
        startActivity(intent);
    }
    public void whatsapp(){
        Intent intent=new Intent(MainActivity.this,SecondAction.class);
        intent.putExtra("url","https://www.web.whatsapp.com");
        startActivity(intent);
    }



}
