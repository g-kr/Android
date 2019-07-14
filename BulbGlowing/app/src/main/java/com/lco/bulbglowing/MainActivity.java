package com.lco.bulbglowing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   private  CameraManager cameraManager;
   private ImageView im;
    boolean ison;
    String backcamid;
    private void turnOnLight(){
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(backcamid, true);
                im.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im = findViewById(R.id.imbtn);
        ison = false;
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (ison) {
                        turnOffLight();
                        ison = false;

                    } else {
                        turnOnLight();
                        ison = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        boolean isFlashavilable = getApplicationContext().getPackageManager().hasSystemFeature(getPackageManager().FEATURE_CAMERA_FLASH);
        if (!isFlashavilable) {
            AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
            alert.setTitle("Flashlight app");
            alert.setMessage(getString(R.string.msg_err));
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "ok", (new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            }));
            alert.show();
            return;
        } else {
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            //not done yrt
            try{
                backcamid=cameraManager.getCameraIdList()[0];
            }
            catch (CameraAccessException e){
                e.printStackTrace();
            }


        }


//        public Void turnOffLight(){
//            try{
//                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
//                    cameraManager.setTorchMode(backcamid,false);
//                    im.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp);
//                }
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }


    }

    private void turnOffLight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(backcamid, false);
                im.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        private void turnOnLight () {
//            try {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    cameraManager.setTorchMode(backcamid, true);
//                    im.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    protected void onStop () {
        super.onStop();
        if (ison) {
            turnOffLight();
        }
    }

    }

