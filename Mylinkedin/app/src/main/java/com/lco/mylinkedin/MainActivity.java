package com.lco.mylinkedin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        String Cource[]={"Adam","Willam","Asif","ranjeet","roshan","Gulshan","mac"};
        int images[]={R.drawable.person1,R.drawable.person2,R.drawable.person3};
        recyclerView.setAdapter(new CourceAdapter(Cource,images));
    }
}
