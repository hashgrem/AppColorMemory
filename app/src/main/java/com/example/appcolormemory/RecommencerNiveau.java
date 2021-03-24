package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RecommencerNiveau extends AppCompatActivity {

    ImageButton restart, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recommencer);

        restart = (ImageButton) findViewById(R.id.restart);
        home = (ImageButton) findViewById(R.id.home);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourEasyMode = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(retourEasyMode);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourHome = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(retourHome);
            }
        });
    }
}
