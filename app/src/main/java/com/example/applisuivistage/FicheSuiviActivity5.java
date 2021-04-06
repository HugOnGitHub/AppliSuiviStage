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
        Toast.makeText(FicheSuiviActivity5.this, "Vous avez choisi : " + "\nla specialité : " + selectedRadioParticipMaitreStage, Toast.LENGTH_SHORT).show();

        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioOpportunite);
        final String selectedRadioOpportunite =((RadioButton)findViewById(rg2.getCheckedRadioButtonId() )).getText().toString();
        Toast.makeText(FicheSuiviActivity5.this, "Vous avez choisi : " + "\nla specialité : " + selectedRadioOpportunite, Toast.LENGTH_SHORT).show();

        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioSiOpportunite);
        final String selectedRadioSiOpportunite =((RadioButton)findViewById(rg3.getCheckedRadioButtonId() )).getText().toString();
        Toast.makeText(FicheSuiviActivity5.this, "Vous avez choisi : " + "\nla specialité : " + selectedRadioSiOpportunite, Toast.LENGTH_SHORT).show();

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

        Intent intent2 = getIntent();
        Toast.makeText(FicheSuiviActivity5.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Specialite"), Toast.LENGTH_SHORT).show();
        Toast.makeText(FicheSuiviActivity5.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Eleve"), Toast.LENGTH_SHORT).show();

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
        FicheSuiviBdd.open();
        Cursor c = FicheSuiviBdd.getUnTuteur(nom,prenom);
        c.moveToFirst();
        int _idTuteur = c.getInt(c.getColumnIndex("_id"));

        Cursor c2 = FicheSuiviBdd.getUnProfesseur(nom,prenom);
        c.moveToFirst();
        int _idProfesseur = c.getInt(c.getColumnIndex("_id"));

        Cursor c3 = FicheSuiviBdd.getUnEtudiant(nom,prenom);
        c.moveToFirst();
        int _idEtudiant = c.getInt(c.getColumnIndex("_id"));

        Cursor c4 = FicheSuiviBdd.getUneEntreprise(nom,prenom);
        c.moveToFirst();
        int _idEntreprise = c.getInt(c.getColumnIndex("_id"));

        final Visite uneFiche =  new Visite(_idTuteur, _idProfesseur, _idEtudiant, _idEntreprise, dateVisite, conditionsStages, bilanTravaux, ressourcesOutils, commentairesAppreciations, selectedRadioParticipMaitreStage, selectedRadioOpportunite, selectedRadioSiOpportunite);
        ListView ListeInfosUnReleve = (ListView) findViewById(R.id.listeInfosUnReleve);
        List<String> infoReleve = new ArrayList<String>();
        infoReleve.add("temperature : "+ templu);
        infoReleve.add("mois : "+ moislu);
        infoReleve.add("jour : "+ jourlu);
        infoReleve.add("heure : "+ heurelu);
        ArrayAdapter<String> adapterReleve = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, infoReleve);
        ListeInfosUnReleve.setAdapter(adapterReleve);

        ListView ListeInfosUnLac = (ListView) findViewById(R.id.listeInfosUnLac);
        List<String> infoLac = new ArrayList<String>();
        infoLac.add("lac : "+ nomlaclu);
        infoLac.add("coordonnees longitudinales : "+ coordlonglu);
        infoLac.add("coordonnees latitudinales : "+ coordlatlu);
        ArrayAdapter<String> adapterLac = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, infoLac);
        ListeInfosUnLac.setAdapter(adapterLac);

        //programmation du bouton quitter
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
                        FicheSuiviBdd.insererFicheSuivi(uneFiche);
                        FicheSuiviBdd.close();
                        finish();
                        break;
                }
            }
        };
    }
}
