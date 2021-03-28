package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    private Button btn_jouer;
    private Button btn_profil;
    String data_passed = "";
    SQLiteHelper db;
    TextView username_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_menu);


        this.btn_jouer = (Button) findViewById(R.id.btn_jouer);
        username_msg = (TextView) findViewById(R.id.main_menu_username_msg);


        db=new SQLiteHelper(getApplicationContext());

        Intent intent = getIntent();

        if (intent != null) {

            String data_passed_last_activity = "";
            if (intent.hasExtra("datapass")) {
                data_passed = intent.getStringExtra("datapass");
                if (intent.hasExtra("last_activity")) {
                    data_passed_last_activity = intent.getStringExtra("last_activity");



                    if (data_passed_last_activity.compareTo("Connexion")==0) {

                       data_passed = db.recuperation_username(data_passed);

                    }

                    else {

                    }

                    username_msg = (TextView) findViewById(R.id.main_menu_username_msg);
                    username_msg.setText("Bonjour " + data_passed + " !");

                }
            }
        }











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


              // String data_pass_username_variable=intent.getStringExtra("datapass");
                Intent profil = new Intent(getApplicationContext(), Profil.class);
                profil.putExtra("username_variable", data_passed);
                startActivity(profil);
            }
        });

    }
}