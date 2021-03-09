package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    //Variables de classe:
    private String prenomUtilisateur = "";
    private String nomUtilisateur = "";
    private String emailUtilisateur = "";
    private String passwordUtilisateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open(); // Ouverture de la base de donnée

        //On récupère la valeur de chaque champs du formulaire.

        //Prénom
        EditText monEditTextFirstName = (EditText)findViewById(R.id.first_name);
        String monPrenom =  monEditTextFirstName.getText().toString();
        prenomUtilisateur = db.addFirstName(monPrenom);

        //Nom
        EditText monEditTextLastName = (EditText)findViewById(R.id.last_name);
        String monNomDeFamille = monEditTextLastName.getText().toString();
        nomUtilisateur = db.addLastName(monNomDeFamille);

        //Email
        EditText monEditTextEmail = (EditText)findViewById(R.id.email);
        String monEmail = monEditTextEmail.getText().toString();
        emailUtilisateur = db.addEmail(monEmail);

        //Mot de passe
        EditText monEditTextPassword = (EditText)findViewById(R.id.password);
        String monPassword = monEditTextPassword.getText().toString();
        passwordUtilisateur = db.addPassword(monPassword);







        db.close(); //Fermeture de la base de donnée
    }
}