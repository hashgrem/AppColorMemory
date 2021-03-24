package com.example.appcolormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public int vie;
    private int maxBlocEclaires;
    private int nombreAleatoire;
    private int nbBloc;
    private int nbBlocSequence;
    private Timer timer;
    private TimerTask timerTask;
    private int[] tabStock;
    private  int compteur;

    ImageButton BoutonVert, BoutonRouge, BoutonOrange, BoutonBleu;
    ImageButton tmpBouton, tmp2Bouton;
    ImageButton clickBouton;

    Random random = new Random();

    ImageButton boutonVert, boutonRouge, boutonOrange, boutonBleu;


    ImageButton[] stockBoutons = {boutonVert, boutonRouge, boutonOrange, boutonBleu};
    ImageButton[] tabBoutons = {boutonVert, boutonRouge, boutonOrange, boutonBleu};

    int[] test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getBaseContext(), "Reason can not be blank", Toast.LENGTH_SHORT).show();


        tabStock = new int[]{};

        compteur= 0;
        nbBlocSequence = 1;
        vie = 2;
        maxBlocEclaires = 3;
        nbBloc=4;


         boutonVert  = (ImageButton) findViewById(R.id.imageButtonVert);
         boutonRouge = (ImageButton) findViewById(R.id.imageButtonRouge);
         boutonOrange = (ImageButton) findViewById(R.id.imageButtonOrange);
         boutonBleu = (ImageButton) findViewById(R.id.imageButtonBleu);
         tmpBouton = (ImageButton) findViewById(R.id.imageBlanc);

        ImageButton[] tabBoutons = {
                boutonVert,
                boutonRouge,
                boutonOrange,
                boutonBleu
        };

         test = new int[]{
                 boutonVert.getId()
         };

         timer = new Timer();

        try {
            CreationSequence(nbBloc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boutonVert.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 try {
                     Verif(boutonVert.getId());
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

             }
         });

        boutonRouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TEST", Toast.LENGTH_LONG).show();
                try {
                    Verif(boutonRouge.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        boutonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonOrange.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        boutonBleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonBleu.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public void Verif(int idBoutonClicke) throws InterruptedException {

        //Comparer avec l'ID du bouton aléatoire


        if(tabStock[compteur] == idBoutonClicke)
        {

            Toast.makeText(getApplicationContext(), "Correcte", Toast.LENGTH_LONG).show();
            compteur++;
            nbBlocSequence++;
            tabStock[nbBlocSequence] = RandomID();

            for (int i=0 ; i<nbBlocSequence ; i++)
            {
                try {
                    EclaireBloc(tabStock[i]);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        else
        {
            vie--;
            Toast.makeText(getApplicationContext(), "Incorrecte", Toast.LENGTH_LONG).show();
            for (int i=0 ; i<nbBlocSequence ; i++)
            {
                try {
                    EclaireBloc(tabStock[i]);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public int RandomID()
    {
        int[] tabID= new int[nbBloc];

        tabID[0] = boutonVert.getId(); //faire les autres
        tabID[1] = boutonBleu.getId();
        tabID[2] = boutonOrange.getId();
        tabID[3] = boutonRouge.getId();

        nombreAleatoire = random.nextInt(tabID.length);

        return tabID[nombreAleatoire];


        //Parcourir tableau test et return un id aléatoire
    }

    public void  CreationSequence(int nbBloc) throws InterruptedException {
        int[] tabSequence = new int[nbBloc];

        timerTask = new TimerTask() {
            @Override
            public void run() {

                for (int i=0 ; i<nbBlocSequence ; i++)
                {
                    tabSequence[i] = RandomID();

                    // Stuff that updates the UI
                    try {
                        EclaireBloc(tabSequence[i]);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };

        timer.schedule(timerTask, 2000);

        tabStock = tabSequence;

        //return tabSequence;

    }

    public void EclaireBloc(int id) throws InterruptedException {


        ImageButton boutonEclaire = findViewById(id);
        boutonEclaire.getBackground().mutate().setAlpha(80);
        Thread.sleep(400);
        boutonEclaire.getBackground().mutate().setAlpha(255);
        Thread.sleep(1000);

    }


}