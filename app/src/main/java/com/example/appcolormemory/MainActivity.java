package com.example.appcolormemory;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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
    private float score;
    private int poidsMode;


    ImageButton premiereVie, deuxiemeVie;
    ImageButton boutonVert, boutonRouge, boutonOrange, boutonBleu;

    TextView affichage_score;

    Random random = new Random();

    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabStock = new int[]{};

        compteur= 0;
        nbBlocSequence = 1;
        vie = 2;
        maxBlocEclaires = 3;
        nbBloc=4;
        score = 0;
        poidsMode = 1;

        affichage_score = (TextView) findViewById(R.id.score);


        boutonVert  = (ImageButton) findViewById(R.id.imageButtonVert);
        boutonRouge = (ImageButton) findViewById(R.id.imageButtonRouge);
        boutonOrange = (ImageButton) findViewById(R.id.imageButtonOrange);
        boutonBleu = (ImageButton) findViewById(R.id.imageButtonBleu);

        premiereVie = (ImageButton) findViewById(R.id.vie_1);
        deuxiemeVie = (ImageButton) findViewById(R.id.vie_2);


        ImageButton[] tabBoutons = {
                boutonVert,
                boutonRouge,
                boutonOrange,
                boutonBleu
        };

        affichage_score.setText("Score: " +score);

        try {
            CreationSequence(maxBlocEclaires);
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

        db = new SQLiteHelper(getApplicationContext());
        Intent intent = getIntent();

        if(tabStock[compteur] == idBoutonClicke)
        {
            if(compteur+1 == nbBlocSequence){

                Toast.makeText(getApplicationContext(), "Séquence terminée", Toast.LENGTH_SHORT).show();

                compteur = 0;
                timer = new Timer();
                tabStock[nbBlocSequence] = RandomID();
                timerTask = new TimerTask() {
                    @Override
                    public void run() {

                        for (int i=0 ; i<nbBlocSequence ; i++)
                        {
                            // Stuff that updates the UI
                            try {
                                EclaireBloc(tabStock[i]);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                };
                timer.schedule(timerTask, 2000);
                nbBlocSequence++;

                if(nbBlocSequence == maxBlocEclaires)
                {
                    score = poidsMode*1;
                    affichage_score.setText("Score: " +score);
                    Thread.sleep(3000);
                    Intent niveauSuivant = new Intent(MainActivity.this, FacileNiveau2.class);
                    startActivity(niveauSuivant);
                }

            }
            else
            {
                Toast.makeText(getApplicationContext(), "bloc de séquence correct", Toast.LENGTH_SHORT).show();
                compteur++;
            }

        }
        else
        {
            deuxiemeVie.getBackground().mutate().setAlpha(0);
            compteur=0;
            vie--;

            Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();


            timer = new Timer();

            if(vie == 0){
                premiereVie.getBackground().mutate().setAlpha(0);
                Toast.makeText(getApplicationContext(), "Perdu", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);
                Intent recommencer = new Intent(MainActivity.this, RecommencerNiveau.class);
                startActivity(recommencer);
                Thread.sleep(2000);

            }
            else{
                timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        for (int i=0 ; i<nbBlocSequence ; i++)
                        {
                            try {
                                EclaireBloc(tabStock[i]);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                };

                timer.schedule(timerTask, 2000);

            }
        }
    }

    public int RandomID()
    {
        int[] tabID= new int[nbBloc];

        tabID[0] = boutonVert.getId();
        tabID[1] = boutonBleu.getId();
        tabID[2] = boutonOrange.getId();
        tabID[3] = boutonRouge.getId();

        nombreAleatoire = random.nextInt(tabID.length);

        return tabID[nombreAleatoire];

    }

    public void  CreationSequence(int nb_bloc_max) throws InterruptedException {
        timer = new Timer();

        int[] tabSequence = new int[nb_bloc_max];

        timerTask = new TimerTask() {
            @Override
            public void run() {

                for (int i=0 ; i<nbBlocSequence ; i++)
                {
                    tabSequence[i] = RandomID();

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


    }

    public void EclaireBloc(int id) throws InterruptedException {

        ImageButton boutonEclaire = findViewById(id);
        boutonEclaire.getBackground().mutate().setAlpha(80);
        Thread.sleep(400);
        boutonEclaire.getBackground().mutate().setAlpha(255);
        Thread.sleep(1000);

    }

}