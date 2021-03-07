package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    //Variables de classe:
    private String prenomUtilisateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open(); // Ouverture de la base de donnée

        //On récupère la valeur de chaque champs du formulaire.

        EditText monEditTextFirstName = (EditText)findViewById(R.id.first_name);
        String monPrenom =  monEditTextFirstName.getText().toString();
        prenomUtilisateur = db.addFirstName(monPrenom);




        db.close(); //Fermeture de la base de donnée
    }
}