package com.example.appcolormemory;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HardNiveau7 extends AppCompatActivity {

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
    private float poidsMode;

    ImageButton boutonVert, boutonRouge, boutonJaune, boutonBleu, boutonRose, boutonViolet, boutonOrange, boutonMarron, boutonLavande, boutonGris;
    ImageButton premiereVie, deuxiemeVie;

    TextView affichage_score;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hard_niveau_7);

        tabStock = new int[]{};

        compteur= 0;
        nbBlocSequence = 3;
        vie = 2;
        maxBlocEclaires = 15;
        nbBloc=10;
        score = 9;
        poidsMode = 1.5f;

        affichage_score = (TextView) findViewById(R.id.score);


        boutonVert  = (ImageButton) findViewById(R.id.btn_vert);
        boutonRouge = (ImageButton) findViewById(R.id.btn_rouge);
        boutonJaune = (ImageButton) findViewById(R.id.btn_jaune);
        boutonBleu = (ImageButton) findViewById(R.id.btn_bleu);
        boutonRose = (ImageButton) findViewById(R.id.btn_rose);
        boutonViolet = (ImageButton) findViewById(R.id.btn_violet);
        boutonOrange = (ImageButton) findViewById(R.id.btn_orange);
        boutonMarron = (ImageButton) findViewById(R.id.btn_marron);
        boutonLavande = (ImageButton) findViewById(R.id.btn_lavande);
        boutonGris = (ImageButton) findViewById(R.id.btn_gris);

        premiereVie = (ImageButton) findViewById(R.id.vie_1);
        deuxiemeVie = (ImageButton) findViewById(R.id.vie_2);

        ImageButton[] tabBoutons = {
                boutonVert,
                boutonRouge,
                boutonJaune,
                boutonBleu,
                boutonRose,
                boutonViolet,
                boutonOrange,
                boutonMarron,
                boutonLavande,
                boutonGris
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

        boutonRose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonRose.getId());
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

        boutonJaune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonJaune.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        boutonViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonViolet.getId());
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

        boutonMarron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonMarron.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        boutonLavande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonLavande.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        boutonGris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Verif(boutonGris.getId());
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
                    score = poidsMode*7;
                    affichage_score.setText("Score: " +score);
                    Thread.sleep(3000);
                    Intent niveauSuivant = new Intent(HardNiveau7.this, ChoixNiveau.class);
                    startActivity(niveauSuivant);
                }

            }
            else
            {
                Toast.makeText(getApplicationContext(), "bloc de séquence correcte", Toast.LENGTH_SHORT).show();
                compteur++;
            }

        }
        else
        {
            deuxiemeVie.getBackground().mutate().setAlpha(0);
            compteur=0;
            vie--;

            Toast.makeText(getApplicationContext(), "Incorrecte", Toast.LENGTH_SHORT).show();


            timer = new Timer();

            if(vie == 0){
                premiereVie.getBackground().mutate().setAlpha(0);
                Toast.makeText(getApplicationContext(), "Perdu", Toast.LENGTH_SHORT).show();
                Thread.sleep(2000);
                Intent recommencer = new Intent(HardNiveau7.this, RecommencerNiveau.class);
                startActivity(recommencer);

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
        tabID[2] = boutonJaune.getId();
        tabID[3] = boutonRouge.getId();
        tabID[4] = boutonRose.getId();
        tabID[5] = boutonViolet.getId();
        tabID[6] = boutonOrange.getId();
        tabID[7] = boutonMarron.getId();
        tabID[8] = boutonLavande.getId();
        tabID[9] = boutonGris.getId();

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
