package com.example.appcolormemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Help extends AppCompatActivity {

    ImageButton retourArriere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_help);

        retourArriere = (ImageButton) findViewById(R.id.btn_retour);

        retourArriere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retourChoixNiveau = new Intent(getApplicationContext(), ChoixNiveau.class);
                startActivity(retourChoixNiveau);
            }
        });


    }
}
