package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Inscription extends AppCompatActivity {

    EditText prenom, email,password;
    Button btn_inscription;
    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inscription);


        prenom=findViewById(R.id.inscription_prenom);
        email = findViewById(R.id.inscription_email);
        password = findViewById(R.id.inscription_password);

        btn_inscription = findViewById(R.id.inscription_btn_inscription);

        db=new SQLiteHelper(getApplicationContext());


        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( db.addJoueur(prenom.getText().toString(),email.getText().toString(),password.getText().toString(), 0) ){
                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity((intent));
                    finish();
                }
                else{
                    Toast.makeText(Inscription.this, "Erreur création profil", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}