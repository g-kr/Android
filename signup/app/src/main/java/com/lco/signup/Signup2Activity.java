package com.lco.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Signup2Activity extends AppCompatActivity {
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    EditText edusername,edemail,edphone,edcity,edaddress;
    Button btnsubmit;
    private DatabaseReference mDatabase;




//
//    final String id="12345";
//    final String dob=mDisplayDate.getText().toString();
//    final String phone=edphone.getText().toString().trim();
//    final String address=edaddress.getText().toString();
//    final String postal=edpostal.getText().toString();
//    final String city=edcity.getText().toString();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        getSupportActionBar().setTitle("Signup");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDisplayDate=findViewById(R.id.date);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(Signup2Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month=month+1;
                String date=month+"/"+day+"/"+year;
                mDisplayDate.setText(date);

            }
        };
        ////////////////////////////////////////////////
        edemail=findViewById(R.id.email2);
        edusername=findViewById(R.id.Username);
        edphone=findViewById(R.id.phonenumber2);
        edcity=findViewById(R.id.city2);
        btnsubmit=findViewById(R.id.submitbtn2);
        edaddress=findViewById(R.id.address);
//        edpostal=findViewById(R.id.postalcode);

        edusername.setEnabled(false);
        edemail.setEnabled(false);

        final String user =getIntent().getStringExtra("user");
        final String email =getIntent().getStringExtra("email");
        edusername.setText(user);
        edemail.setText(email);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                writeNewUser(user,email,edphone.getText().toString().trim());
                Intent i=new Intent(Signup2Activity.this,HOMEActivity.class);
                startActivity(i);

            }
        });


        /////////database
        //writeNewUser("asif","sdfasssa");


//        mDatabase.child("users").child("email").child("USerid").setValue(user);
//////////////database


    }
    private void writeNewUser(String username, String email,String phone) {
        String userId=mDatabase.push().getKey();
        User user = new User(username,email,phone);
       // User.child(id).setValue(user);
        mDatabase.child(userId).setValue(user);




    }

}
