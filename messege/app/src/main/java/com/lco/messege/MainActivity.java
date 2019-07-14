package com.lco.messege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.acl.Permission;

public class MainActivity extends AppCompatActivity {
    private static final int MESSAGE=1;
    EditText ed1,ed2;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed1=findViewById(R.id.ed2);
        img=findViewById(R.id.msgbtn);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messagesend();
            }
        });

    }
    public void messagesend(){
        String number=ed1.getText().toString();
        String Text=ed2.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},MESSAGE);


            }
            else{
                String dial="tel:"+number;
                Intent i=new Intent(Intent.ACTION_SENDTO);
                i.putExtra(i.EXTRA_TEXT,Text);
                i.setData(Uri.parse(dial));
                startActivity(i);
            }

        }
        else {
            Toast.makeText(MainActivity.this,"Enter a valid number",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       if(requestCode==MESSAGE){
           if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
               messagesend();
           }
           else{
               Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show();
           }
       }
    }
}
