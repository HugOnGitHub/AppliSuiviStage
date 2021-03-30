package com.example.applisuivistage;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //on associe à un objet java de type Button, un widget repéré physiquement par son id
        Button btnAfficherStages = findViewById(R.id.btnAfficherStages);
        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAfficherStages:
                        Intent intent2 = new Intent(MainActivity.this, AfficherStagesActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        //on affecte au bouton l'écouteur
        btnAfficherStages.setOnClickListener(ecouteur);

        remplirTableEtudiant();
        }

    public void remplirTableEtudiant() {
        DAOBdd etudiantBdd = new DAOBdd(this);
        Etudiant etudiant1 = new Etudiant("Sourice", "Clémentin", "2SLAM", "2021");
        Etudiant etudiant2 = new Etudiant("Dabin", "Hugo", "2SLAM", "2021");
        Etudiant etudiant3 = new Etudiant("Moinard", "Florian", "2SLAM", "2021");
        Etudiant etudiant4 = new Etudiant("Guyon", "Carmin", "2SLAM", "2021");
        //on ouvre la base de données
        etudiantBdd.open();
        //on insère etudiant1, etudiant2 puis etudiant3
        etudiantBdd.insererEtudiant(etudiant1);
        etudiantBdd.insererEtudiant(etudiant2);
        etudiantBdd.insererEtudiant(etudiant3);
        etudiantBdd.insererEtudiant(etudiant4);
        //le curseur pour afficher le nombre de lacs dans la base
        Cursor c = etudiantBdd.getDataEtudiant();
        Toast.makeText(getApplicationContext(), " il y a " +
                String.valueOf(c.getCount()) + " etudiants ", Toast.LENGTH_LONG).show();
    }

}