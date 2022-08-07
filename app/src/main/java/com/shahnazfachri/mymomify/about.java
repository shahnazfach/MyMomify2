package com.shahnazfachri.mymomify;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class about extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button btnexit = findViewById(R.id.btn_exit);
        btnexit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent a = new Intent(about.this,apkmenu.class);
                startActivity(a);
            }
        });


    }
}
