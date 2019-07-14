package com.lco.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView courcelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courcelist=findViewById(R.id.recyclerview);
        courcelist.setLayoutManager(new LinearLayoutManager(this));
        String Cource[]={"java","c++","phuytojsd","javascript","php","node","react native","machine learning","hacking","cloud computing"};
        courcelist.setAdapter(new CourceAdapter(Cource));
    }
}
