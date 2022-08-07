package com.shahnazfachri.mymomify;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.shahnazfachri.mymomify.Activities.MovieActivity;


public class apkmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apkmenu);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportActionBar().hide();

        ImageView imageView_setting = findViewById(R.id.img_set);
        imageView_setting.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent a = new Intent(apkmenu.this,home.class);
                startActivity(a);
            }
        });

        ImageView imageView_note = findViewById(R.id.img_note);
        imageView_note.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent c = new Intent(apkmenu.this,notemenu.class);
                startActivity(c);
            }
        });

        ImageView imageView_report = findViewById(R.id.img_report);
        imageView_report.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent e = new Intent(apkmenu.this,reportmenu.class);
                startActivity(e);
            }
        });

        ImageView imageView_insight = findViewById(R.id.img_insight);
        imageView_insight.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent d = new Intent(apkmenu.this,MovieActivity.class);
                startActivity(d);
            }
        });

        ImageView imageView_lokasi = findViewById(R.id.img_lokasi);
        imageView_lokasi.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent d = new Intent(apkmenu.this,PuskesmasActivity.class);
                startActivity(d);
            }
        });

        ImageView imageView_tentang = findViewById(R.id.img_tentang);
        imageView_tentang.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent d = new Intent(apkmenu.this,about.class);
                startActivity(d);
            }
        });
        


    }

}