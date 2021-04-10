package com.example.applisuivistage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FicheSuiviActivity5 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport_5);

        //on déclare en final les données de l'interface à enregistrer
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioParticipMaitreStage);
        final String selectedRadioParticipMaitreStage =((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();

        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioOpportunite);
        final String selectedRadioOpportunite =((RadioButton)findViewById(rg2.getCheckedRadioButtonId() )).getText().toString();

        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioSiOpportunite);
        final String selectedRadioSiOpportunite =((RadioButton)findViewById(rg3.getCheckedRadioButtonId() )).getText().toString();

        String nom ="";
        String prenom ="";
        String annee ="";
        String classe ="";
        String specialite="";
        String tuteurPedag="";
        String mailPedag="";
        String dateVisite="";
        String entreprise="";
        String divers="";
        String tuteurEntrep="";
        String telEntrep="";
        String mailEntrep="";
        String conditionsStages="";
        String bilanTravaux="";
        String ressourcesOutils="";
        String commentairesAppreciations="";

        //on va récupérer les valeurs provenant de NewReleveActivity
        Intent intent = getIntent();
        if (intent != null) {
            nom= intent.getStringExtra("EXTRA_Nom");
            prenom= intent.getStringExtra("EXTRA_Prenom");
            annee= intent.getStringExtra("EXTRA_Annee");
            classe= intent.getStringExtra("EXTRA_Classe");
            specialite= intent.getStringExtra("EXTRA_Specialite");
            tuteurPedag= intent.getStringExtra("EXTRA_TuteurPedag");
            mailPedag= intent.getStringExtra("EXTRA_MailPedag");
            dateVisite= intent.getStringExtra("EXTRA_DateVisite");
            entreprise= intent.getStringExtra("EXTRA_Entreprise");
            divers= intent.getStringExtra("EXTRA_Divers");
            tuteurEntrep= intent.getStringExtra("EXTRA_TuteurEntrep");
            telEntrep= intent.getStringExtra("EXTRA_TelEntrep");
            mailEntrep= intent.getStringExtra("EXTRA_MailEntrep");
            conditionsStages= intent.getStringExtra("EXTRA_ConditionsStages");
            bilanTravaux= intent.getStringExtra("EXTRA_BilanTravaux");
            ressourcesOutils= intent.getStringExtra("EXTRA_RessourcesOutils");
            commentairesAppreciations= intent.getStringExtra("EXTRA_CommentairesAppreciations");
        }

        final DAOBdd FicheSuiviBdd = new DAOBdd(this);
        //on ouvre la base de données
        FicheSuiviBdd.open();
        Cursor c = FicheSuiviBdd.getIDStage(nom, prenom);
        // champs dans lesquelles afficher les colonnes
        c.moveToFirst();
        // The Cursor is now set to the right position
        final int _idStageVisite = c.getInt(c.getColumnIndex("_idStageVisite"));
        final String dateVisiteFinal = dateVisite;
        final String conditionsStagesFinal = conditionsStages;
        final String bilanTravauxFinal = bilanTravaux;
        final String ressourcesOutilsFinal = ressourcesOutils;
        final String commentairesAppreciationsFinal = commentairesAppreciations;

        Cursor c1 = FicheSuiviBdd.getIDStageVisite(_idStageVisite);

        if(c1.getCount()>0){
            //programmation des boutons
            Button btnAnnuler = findViewById(R.id.btnAnnuler);
            Button btnEnregistrer = findViewById(R.id.btnEnregistrer);
            //on va créer un écouteur
            View.OnClickListener ecouteur = new View.OnClickListener() {
                //on implémente la méthode onclick
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.btnAnnuler:
                            finish();
                            break;
                        case R.id.btnEnregistrer:
                            Cursor c2 = FicheSuiviBdd.updateVisite(_idStageVisite, dateVisiteFinal, conditionsStagesFinal, bilanTravauxFinal, ressourcesOutilsFinal,
                                    commentairesAppreciationsFinal, selectedRadioParticipMaitreStage, selectedRadioOpportunite, selectedRadioSiOpportunite);
                            FicheSuiviBdd.close();
                            finish();
                            break;
                    }
                }
            };
        }else{
            final Visite uneVisite = new Visite(c.getInt(c.getColumnIndex("_id")), dateVisite, conditionsStages, bilanTravaux, ressourcesOutils,
                    commentairesAppreciations, selectedRadioParticipMaitreStage, selectedRadioOpportunite, selectedRadioSiOpportunite);
            //programmation des boutons
            Button btnAnnuler = findViewById(R.id.btnAnnuler);
            Button btnEnregistrer = findViewById(R.id.btnEnregistrer);
            //on va créer un écouteur
            View.OnClickListener ecouteur = new View.OnClickListener() {
                //on implémente la méthode onclick
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.btnAnnuler:
                            finish();
                            break;
                        case R.id.btnEnregistrer:
                            //on insère une visite
                            FicheSuiviBdd.insererVisite(uneVisite);
                            FicheSuiviBdd.close();
                            finish();
                            break;
                    }
                }
            };
        }
        c1.close();
    }
}
