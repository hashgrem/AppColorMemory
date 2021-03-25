package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DemarrageApp extends AppCompatActivity {


    private Button btn_inscription;
    private Button btn_connexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demarrage_app);

        this.btn_inscription = (Button) findViewById(R.id.acceuil_btn_inscription);
        this.btn_connexion = (Button) findViewById(R.id.acceuil_btn_connexion);

        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inscription_page = new Intent(getApplicationContext(), Inscription.class);
                startActivity(inscription_page);
            }
        });

        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion_page = new Intent(getApplicationContext(), Connexion.class);
                startActivity(connexion_page);
            }
        });

    }
}