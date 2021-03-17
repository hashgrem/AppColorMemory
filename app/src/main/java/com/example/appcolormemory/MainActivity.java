package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageButton boutonVert  = (ImageButton) findViewById(R.id.imageButtonVert);
        ImageButton boutonRouge = (ImageButton) findViewById(R.id.imageButtonRouge);
        ImageButton boutonOrange = (ImageButton) findViewById(R.id.imageButtonOrange);
        ImageButton boutonBleu = (ImageButton) findViewById(R.id.imageButtonBleu);

        ImageButton[] tabBoutons = {
                boutonVert,
                boutonRouge,
                boutonOrange,
                boutonBleu
        };

        // Quand le jeu commence:

        int maxBlocEclaires = 11; //selon le mode donc a changer


        //Mode facile:

        for(int i=1;i<11;i++)
        {
            boolean bool = true;
            Random random = new Random();
            int nombreAleatoire;
            ImageButton tmpBouton;
            int vie = 2;
            int[] tabSequence = { // idée: stocké les boutons différents de boutons aléatoire

            };

            nombreAleatoire =  random.nextInt(3);

            tmpBouton = tabBoutons[nombreAleatoire];
            tmpBouton.getBackground().setAlpha(128);

            // si la séquence est reproduite (onClick), alors on fait rien = itération suivante
            // sinon meme itération et vie = vie - 1


            //  PROBLEME ICI:

            if ()
            //si clic bon bouton
            {
                tmpBouton.setOnClickListener(
                        (view) -> {reactionAuClickBoutonAleatoire();}
                );

            }

            else { // si clic mauvais bvouton
                vie = vie - 1;

                if (vie == 0) {
                    i = maxBlocEclaires;
                    Toast.makeText(this, "Vous avez perdu", Toast.LENGTH_LONG).show();

                }

                else

                    Toast.makeText(this, "Vous avez perdu une vie", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void reactionAuClickBoutonAleatoire() {
        Toast.makeText(this, "OK, séquence correcte", Toast.LENGTH_LONG).show();

    }

}