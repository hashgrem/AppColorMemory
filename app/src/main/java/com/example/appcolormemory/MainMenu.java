package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    private Button btn_jouer;
    private Button btn_profil;

    SQLiteHelper db;
    TextView username_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_menu);

        this.btn_jouer = (Button) findViewById(R.id.btn_jouer);
        username_msg = (TextView) findViewById(R.id.main_menu_username_msg);

        db=new SQLiteHelper(getApplicationContext());

        











        btn_jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choixniveauActivity = new Intent(getApplicationContext(), ChoixNiveau.class);
                startActivity(choixniveauActivity);
            }
        });

        this.btn_profil = (Button) findViewById(R.id.btn_profil);

        btn_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profil = new Intent(getApplicationContext(), Profil.class);
                startActivity(profil);
            }
        });

    }
}