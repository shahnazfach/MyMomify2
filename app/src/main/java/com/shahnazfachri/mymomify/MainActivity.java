package com.shahnazfachri.mymomify;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {


     private int waktu_loading=3000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //bar transparant
           Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getSupportActionBar().hide();


            setContentView(R.layout.activity_main);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent loginIntent=new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();

                }
            },waktu_loading);
        }
}