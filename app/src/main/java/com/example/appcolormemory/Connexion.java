package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Connexion extends AppCompatActivity {

    EditText  email,password;
    Button btn_connexion;
    SQLiteHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_login);

        setContentView(R.layout.layout_connexion);

        email = findViewById(R.id.connexion_email);
        password = findViewById(R.id.connexion_password);
        btn_connexion = findViewById(R.id.connexion_btn_connexion);
        db=new SQLiteHelper(getApplicationContext());



        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.connection(email.getText().toString(),password.getText().toString())){
                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                    intent.putExtra("datapass",email.getText().toString());
                    String last_activity = "Connexion";
                    intent.putExtra("last_activity", last_activity );
                    startActivity((intent));
                    finish();
                }
                else{
                    Toast.makeText(Connexion.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}