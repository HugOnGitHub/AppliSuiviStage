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

public class FicheSuiviActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport_2);

        //on déclare en final les données passées à l'autre interface
        final EditText tuteurPedag = findViewById(R.id.editTextTuteurPedag);
        final EditText mailPedag = findViewById(R.id.editTextMailPedag);
        final EditText dateVisite = findViewById(R.id.editTextDateVisite);
        final EditText entreprise = findViewById(R.id.editTextEntreprise);
        final EditText divers = findViewById(R.id.editTextDivers);
        final EditText tuteurEntrep = findViewById(R.id.editTextTuteurEntrep);
        final EditText telEntrep = findViewById(R.id.editTextTelEntrep);
        final EditText mailEntrep = findViewById(R.id.editTextMailEntrep);

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
                        Intent i = new Intent(FicheSuiviActivity2.this, FicheSuiviActivity3.class);
                        i.putExtra("EXTRA_Nom",intent.getStringExtra("EXTRA_Nom"));
                        i.putExtra("EXTRA_Prenom",intent.getStringExtra("EXTRA_Prenom"));
                        i.putExtra("EXTRA_Annee",intent.getStringExtra("EXTRA_Annee"));
                        i.putExtra("EXTRA_Classe",intent.getStringExtra("EXTRA_Classe"));
                        i.putExtra("EXTRA_Specialite",intent.getStringExtra("EXTRA_Specialite"));
                        i.putExtra("EXTRA_TuteurPedag",tuteurPedag.getText().toString());
                        i.putExtra("EXTRA_MailPedag",mailPedag.getText().toString());
                        i.putExtra("EXTRA_DateVisite",dateVisite.getText().toString());
                        i.putExtra("EXTRA_Entreprise",entreprise.getText().toString());
                        i.putExtra("EXTRA_Divers",divers.getText().toString());
                        i.putExtra("EXTRA_TuteurEntrep",tuteurEntrep.getText().toString());
                        i.putExtra("EXTRA_TelEntrep",telEntrep.getText().toString());
                        i.putExtra("EXTRA_MailEntrep",mailEntrep.getText().toString());
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
        FicheSuiviBdd.open();

        //recuperation de l'annee et de classe en fonction des listes déroulantes
        Cursor c = FicheSuiviBdd.getInfosStage(nom, prenom);
        // champs dans lesquelles afficher les colonnes
        c.moveToFirst();
        // The Cursor is now set to the right position
        TextView IdentiteProf = (TextView)findViewById(R.id.editTextTuteurPedag);
        IdentiteProf.setText(c.getString(c.getColumnIndex("IdentiteProf")));

        TextView EmailProf = (TextView)findViewById(R.id.editTextMailPedag);
        EmailProf.setText(c.getString(c.getColumnIndex("EmailProf")));

        TextView NomSociete = (TextView)findViewById(R.id.editTextEntreprise);
        NomSociete.setText(c.getString(c.getColumnIndex("NomSociete")));

        TextView IdentiteTuteur = (TextView)findViewById(R.id.editTextTuteurEntrep);
        IdentiteTuteur.setText(c.getString(c.getColumnIndex("IdentiteTuteur")));

        TextView NumTelTuteur = (TextView)findViewById(R.id.editTextTelEntrep);
        NumTelTuteur.setText(c.getString(c.getColumnIndex("NumTelTuteur")));

        TextView EmailTuteur = (TextView)findViewById(R.id.editTextMailEntrep);
        EmailTuteur.setText(c.getString(c.getColumnIndex("EmailTuteur")));
    }
}
