package com.example.applisuivistage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FicheSuiviActivity3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport_3);

        //on déclare en final les données passées à l'autre interface
        final EditText conditionsStage = findViewById(R.id.editConditionsStage);
        final EditText bilanTravaux = findViewById(R.id.editBilanTravaux);

        String nom ="";
        String prenom ="";
        Intent intent2 = getIntent();
        nom= intent2.getStringExtra("EXTRA_Nom");
        prenom= intent2.getStringExtra("EXTRA_Prenom");

        Button btnSuivant = (Button) findViewById(R.id.btnSuivant);
        Button btnAnnuler = (Button) findViewById(R.id.btnAnnuler);
        //on va créer un écouteur pour un groupe de boutons
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnSuivant:
                        //on passer les infos dans l'autre interface
                        Intent intent = getIntent();
                        Intent i = new Intent(FicheSuiviActivity3.this, FicheSuiviActivity4.class);
                        i.putExtra("EXTRA_Nom",intent.getStringExtra("EXTRA_Nom"));
                        i.putExtra("EXTRA_Prenom",intent.getStringExtra("EXTRA_Prenom"));
                        i.putExtra("EXTRA_Annee",intent.getStringExtra("EXTRA_Annee"));
                        i.putExtra("EXTRA_Classe",intent.getStringExtra("EXTRA_Classe"));
                        i.putExtra("EXTRA_Specialite",intent.getStringExtra("EXTRA_Specialite"));
                        i.putExtra("EXTRA_TuteurPedag",intent.getStringExtra("EXTRA_TuteurPedag"));
                        i.putExtra("EXTRA_MailPedag",intent.getStringExtra("EXTRA_MailPedag"));
                        i.putExtra("EXTRA_DateVisite",intent.getStringExtra("EXTRA_DateVisite"));
                        i.putExtra("EXTRA_Entreprise",intent.getStringExtra("EXTRA_Entreprise"));
                        i.putExtra("EXTRA_Divers",intent.getStringExtra("EXTRA_Divers"));
                        i.putExtra("EXTRA_TuteurEntrep",intent.getStringExtra("EXTRA_TuteurEntrep"));
                        i.putExtra("EXTRA_TelEntrep",intent.getStringExtra("EXTRA_TelEntrep"));
                        i.putExtra("EXTRA_MailEntrep",intent.getStringExtra("EXTRA_MailEntrep"));
                        i.putExtra("EXTRA_ConditionsStages",conditionsStage.getText().toString());
                        i.putExtra("EXTRA_BilanTravaux",bilanTravaux.getText().toString());
                        startActivityForResult(i,0);
                        break;
                    case R.id.btnAnnuler:
                        finish();
                        break;
                }
            }
        };
        btnSuivant.setOnClickListener((ecouteur));
        btnAnnuler.setOnClickListener((ecouteur));

        final DAOBdd FicheSuiviBdd = new DAOBdd(this);
        //on ouvre la base de données
        FicheSuiviBdd.open();
        Cursor c = FicheSuiviBdd.getIDStage(nom, prenom);
        // champs dans lesquelles afficher les colonnes
        c.moveToFirst();

        // final pour l'update d'une visite
        final int _idStageVisite = c.getInt(c.getColumnIndex("_id"));

        Cursor c1 = FicheSuiviBdd.getIDStageVisite(_idStageVisite);

        if(c1.getCount()>0){
            //recuperation des infos de visite en fonction des listes déroulantes
            Cursor c2 = FicheSuiviBdd.getInfosVisite(_idStageVisite);
            // champs dans lesquelles afficher les colonnes
            c2.moveToFirst();
            // The Cursor is now set to the right position
            TextView Conditions = (TextView)findViewById(R.id.editConditionsStage);
            Conditions.setText(c2.getString(c2.getColumnIndex("Conditions")));

            TextView Bilan = (TextView)findViewById(R.id.editBilanTravaux);
            Bilan.setText(c2.getString(c2.getColumnIndex("Bilan")));
        }else{

        }
        c1.close();
    }
}
