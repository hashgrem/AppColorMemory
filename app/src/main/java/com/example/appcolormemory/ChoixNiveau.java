package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class ChoixNiveau extends AppCompatActivity {

    private Button btn_niveau_facile;
    private Button btn_niveau_difficile;
    private Button btn_niveau_expert;
    private Button btn_niveau_chrono;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_choix_niveau);

        this.btn_niveau_facile = (Button) findViewById(R.id.btn_niv_facile);
        this.btn_niveau_difficile = (Button) findViewById(R.id.btn_niv_difficile);
        this.btn_niveau_expert = (Button) findViewById(R.id.btn_niv_expert);
        this.btn_niveau_chrono = (Button) findViewById(R.id.btn_niv_chrono);

        btn_niveau_facile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Niveau_Facile = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Niveau_Facile);
            }
        });

        btn_niveau_difficile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Niveau_Difficle = new Intent(getApplicationContext(), HardNiveau1.class);
                startActivity(Niveau_Difficle);
                finish();

            }
        });

        btn_niveau_expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Niveau_Expert = new Intent(getApplicationContext(), NiveauExpert.class);
                startActivity(Niveau_Expert);
                finish();

            }
        });

        btn_niveau_chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Niveau_Chrono = new Intent(getApplicationContext(), NiveauChrono.class);
                startActivity(Niveau_Chrono);
                finish();

            }
        });

    }
}