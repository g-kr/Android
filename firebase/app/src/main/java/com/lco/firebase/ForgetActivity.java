package com.lco.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetActivity extends AppCompatActivity {
    EditText ed;
    Button b1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ed=findViewById(R.id.edemail);
        b1=findViewById(R.id.btnrst);
        firebaseAuth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=ed.getText().toString();
                if(email.equals("")){
                    Toast.makeText(ForgetActivity.this,"Enter a email to reset password",Toast.LENGTH_SHORT).show();

                }
                else{
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgetActivity.this,"Reset link is sent",Toast.LENGTH_SHORT).show();
                                finish();
                                Intent i=new Intent(ForgetActivity.this,MainActivity.class);
                                startActivity(i);

                            }
                            else{
                                Toast.makeText(ForgetActivity.this,"ERROR",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }

            }
        });
    }
}
