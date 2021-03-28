package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    TextView affichage_username, affichage_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profil);

        SQLiteHelper db;
        db = new SQLiteHelper(getApplicationContext());


        Intent intent = getIntent();

        if (intent != null) {
            String data_passed_variable = "";
            if (intent.hasExtra("username_variable")) {
                intent.getStringExtra("username_variable");

                affichage_username = (TextView) findViewById(R.id.profil_nom_utilisateur);
                affichage_username.setText("Nom D'utilisateur : "+intent.getStringExtra("username_variable"));


                affichage_score = (TextView) findViewById(R.id.profil_score);
                affichage_score.setText(" Votre Score" +String.valueOf(db.recuperation_score(intent.getStringExtra("username_variable"))));


            }
        }
    }
}

