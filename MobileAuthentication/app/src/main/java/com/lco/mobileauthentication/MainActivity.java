package com.lco.mobileauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ImageView btn1;
    EditText ed1,ed3,ed2;
    FirebaseAuth firebaseAuth;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btnlogin);
        ed1=findViewById(R.id.country);
        ed2=findViewById(R.id.phone);
        ed3=findViewById(R.id.editText2);
        firebaseAuth=FirebaseAuth.getInstance();//link le ke aarha
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=ed2.getText().toString().trim();
                if(number.isEmpty() || number.length()<10){
                    ed2.setError("Enter a valid number");
                    ed2.requestFocus();
                    return;
                }
                final String phonenumber="+"+"91"+number;
                sendVerificationCode(phonenumber);

            }
        });

    }
    public void sendVerificationCode(String phonenumber){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phonenumber,60, TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack


        );



    }
    private  PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code=phoneAuthCredential.getSmsCode();
            if(code!=null){
                ed3.setText(code);
                verifyCode(code);

            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId=s;
        }

    };
    private void verifyCode(String code){
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verificationId,code);
        signInWithCredential(credential);

    }
    private void signInWithCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Succesful",Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
