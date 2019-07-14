package com.lco.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;
    String email,password;
    TextView txt;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        b1=findViewById(R.id.btn1);
        txt=findViewById(R.id.txtview);
        firebaseAuth=FirebaseAuth.getInstance();
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                email= ed1.getText().toString();
                password=ed2.getText().toString();
                if (ed1.getText().toString().length() > 6) {
                    if (ed2.getText().toString().length() > 6) {
                        signup(email,password);
                        Intent i=new Intent(Main2Activity.this,HomeActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Main2Activity.this, "Enter a password greater tha 6", Toast.LENGTH_SHORT).show();


                    }
                }
                else{
                    Toast.makeText(Main2Activity.this, "Enter a email greater tha 6", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }
    public void signup(String str1,String str2){
        //System.out.println("fghjk");
        firebaseAuth.createUserWithEmailAndPassword(str1,str2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Main2Activity.this, "succesful", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent i=new Intent(Main2Activity.this,MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(Main2Activity.this, "failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }


}
