package com.lco.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN =1 ;
   // GoogleSignInApi mGoogleSignInClient;
   GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    //GoogleSignInClient mGoogleSignInClient;
    Button b1,b2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    EditText ed1,ed2;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.email);
        ed2=findViewById(R.id.pass1);
        b1=findViewById(R.id.btn1);
        ////////////////

        mDatabase = FirebaseDatabase.getInstance().getReference();












        ////////////////////////////auth

//        if(mAuth.getCurrentUser()!=null){
//            finish();
//            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
//        }
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






        //////////////////////////
        ////////*********************
        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_google);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        //mGoogleSignInClient = (GoogleSignInApi) GoogleSignIn.getClient(MainActivity.this, gso);
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();

            }
        });
        /////////////////////

        /////////////////////
        b2=findViewById(R.id.btn2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Signup1Activity.class);
                startActivity(i);

            }
        });

    }
    private void signIn() {

        Intent signInIntent =  mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately

                // ...
            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {

            updateUI(currentUser);
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
       // Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithCredential:failure", task.getException());

                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    private void updateUI(FirebaseUser currentUser) {
        Toast.makeText(MainActivity.this,"logged in",Toast.LENGTH_SHORT).show();
        //Intent i=new Intent(MainActivity.this,Main2Activity.class);
       // startActivity(i);
    }
    ///////emailauth
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
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.cancel();
                        finish();
                        Toast.makeText(MainActivity.this,"logged in succesfully",Toast.LENGTH_SHORT).show();

                       //** Intent i=new Intent(MainActivity.this,HomeActivity.class);
                        //**startActivity(i);


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
}
