package com.lco.spanishsouond;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    SoundPool soundpool;
    int sound1,sound2,sound3,sound4,sound5,sound6,sound7,sound8,sound9,sound10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        b6=findViewById(R.id.btn6);
        b7=findViewById(R.id.btn7);
        b8=findViewById(R.id.btn8);
        b9=findViewById(R.id.btn9);
        b10=findViewById(R.id.btn10);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes =new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundpool=new SoundPool.Builder()
                    .setMaxStreams(8)
                    .setAudioAttributes(audioAttributes).build();

        }
        else{
            soundpool= new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        }
        sound1=soundpool.load(this,R.raw.one,1);
        sound2=soundpool.load(this,R.raw.two,1);
        sound3=soundpool.load(this,R.raw.three,1);
        sound4=soundpool.load(this,R.raw.four,1);
        sound5=soundpool.load(this,R.raw.five,1);
        sound6=soundpool.load(this,R.raw.six,1);
        sound7=soundpool.load(this,R.raw.seven,1);
        sound8=soundpool.load(this,R.raw.eight,1);
        sound9=soundpool.load(this,R.raw.nine,1);
        sound10=soundpool.load(this,R.raw.ten,1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound1,1,1,0,0,1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound2,1,1,0,0,1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound3,1,1,0,0,1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound4,1,1,0,0,1);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound5,1,1,0,0,1);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound6,1,1,0,0,1);
            }
        });b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound7,1,1,0,0,1);
            }
        });b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound8,1,1,0,0,1);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound9,1,1,0,0,1);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(sound10,1,1,0,0,1);
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundpool.release();
        soundpool=null;
    }
}
