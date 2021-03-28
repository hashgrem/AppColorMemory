package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    TextView affichage_username, affichage_score, affichage_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profil);

        SQLiteHelper db;
        db = new SQLiteHelper(getApplicationContext());

        affichage_username = (TextView) findViewById(R.id.profil_nom_utilisateur);
        affichage_score = (TextView) findViewById(R.id.profil_score);
        affichage_email = (TextView) findViewById(R.id.profil_email) ;


        Intent intent = getIntent();

        if (intent != null) {
            String data_passed_variable = "";
            if (intent.hasExtra("username_variable")) {

                intent.getStringExtra("username_variable");

                affichage_username.setText(intent.getStringExtra("username_variable"));
                affichage_score.setText(String.valueOf(db.recuperation_score(intent.getStringExtra("username_variable"))));
                affichage_email.setText(String.valueOf(db.recuperation_email(intent.getStringExtra("username_variable"))));

            }
        }
    }
}

