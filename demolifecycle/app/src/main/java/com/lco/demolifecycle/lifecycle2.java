package com.lco.demolifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class lifecycle2 extends AppCompatActivity {

    Button b1,b2;
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"resume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onstart",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle2);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        Toast.makeText(this,"oncreate1",Toast.LENGTH_SHORT).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);

            }
        });
        onStart();

    }
}
