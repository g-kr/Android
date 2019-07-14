package com.lco.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    EditText ed1,ed2;

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        b1=findViewById(R.id.btn1);
        progressDialog=new ProgressDialog(this);
        b3=findViewById(R.id.btnsignup);
        firebaseAuth=FirebaseAuth.getInstance();
        b2=findViewById(R.id.btnforget);
        if(firebaseAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i=new Intent(MainActivity.this,ForgetActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,password;
                email=ed1.getText().toString();
                password=ed2.getText().toString();
                if (ed1.getText().toString().length() > 6) {
                    if (ed2.getText().toString().length() > 6) {
                        login(email,password);
                    } else {
                        Toast.makeText(MainActivity.this, "Enter a password greater tha 6", Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Enter a email greater tha 6", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    public void login(String email,String password){
        if(email.isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_SHORT).show();

        }
        else if(password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Enter password",Toast.LENGTH_SHORT).show();

        }
        else{
            progressDialog.setMessage("login User....");
            progressDialog.show();
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.cancel();
                        finish();
                        Toast.makeText(MainActivity.this,"logged in succesfully",Toast.LENGTH_SHORT).show();

                        Intent i=new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(i);


                    }
                    else{

                        Toast.makeText(MainActivity.this,"logged in failed",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                    finish();

                }
            });
        }


    }
    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
        super.onBackPressed();
    }
}
