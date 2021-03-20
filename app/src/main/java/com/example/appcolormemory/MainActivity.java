package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int vie = 2;
    int maxBlocEclaires = 3;
    int nombreAleatoire;

    ImageButton tmpBoutonVert, tmpBoutonRouge, tmpBoutonOrange, tmpBoutonBleu;
    ImageButton tmpBouton, tmp2Bouton;
    ImageButton clickBouton;

    Random random = new Random();

    ImageButton boutonVert, boutonRouge, boutonOrange, boutonBleu;


    ImageButton[] stockBoutons = {boutonVert, boutonRouge, boutonOrange, boutonBleu};
    ImageButton[] tabBoutons = {boutonVert, boutonRouge, boutonOrange, boutonBleu};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageButton boutonVert  = (ImageButton) findViewById(R.id.imageButtonVert);
        ImageButton boutonRouge = (ImageButton) findViewById(R.id.imageButtonRouge);
        ImageButton boutonOrange = (ImageButton) findViewById(R.id.imageButtonOrange);
        ImageButton boutonBleu = (ImageButton) findViewById(R.id.imageButtonBleu);
        ImageButton tmpBouton = (ImageButton) findViewById(R.id.imageBlanc);

        ImageButton[] tabBoutons = {
                boutonVert,
                boutonRouge,
                boutonOrange,
                boutonBleu
        };

        Jeu();
        
    }

    public void Jeu() {

        while ((vie > 0) && (maxBlocEclaires < 11)) {

            for (int i = 0; i < maxBlocEclaires; i++) // Création de la séquence de couleur aléatoire
            {

                Toast.makeText(this, "Je rentre dans le for ", Toast.LENGTH_LONG).show();

                nombreAleatoire = random.nextInt(3);

                stockBoutons[i] = tabBoutons[nombreAleatoire]; //On stocke le bouton a chaque itération.

                tmpBouton = tabBoutons[nombreAleatoire]; //On éclaire un bouton a chaque itération.
                tmpBouton.getBackground().mutate().setAlpha(80); //erreur ici "reference sur objet null"
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tmpBouton.getBackground().mutate().setAlpha(255);


            }

            for (int i = 1; i < maxBlocEclaires; i++) // Utilisateur / Joueur
            {
                tmp2Bouton = stockBoutons[i]; // On stocke le i-ième block éclairé

                boutonVert.setOnClickListener(
                        (view) -> {
                            reactionAuClickBoutonVertParUtilisateur();
                        }
                );
            }
        }
    }

    private void reactionAuClickBoutonVertParUtilisateur() {
        Toast.makeText(this, "Vert", Toast.LENGTH_LONG).show();

        if(boutonVert == tmp2Bouton)
        {
            maxBlocEclaires += 1;

        }
        else
            vie -= 1;


    }
}