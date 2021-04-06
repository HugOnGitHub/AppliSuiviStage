package com.example.applisuivistage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FicheSuiviActivity3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport_3);

        //on déclare en final les données passées à l'autre interface
        final EditText conditionsStage = findViewById(R.id.editConditionsStage);
        final EditText bilanTravaux = findViewById(R.id.editBilanTravaux);

        Intent intent2 = getIntent();
        Toast.makeText(FicheSuiviActivity3.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Specialite"), Toast.LENGTH_SHORT).show();
        Toast.makeText(FicheSuiviActivity3.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Eleve"), Toast.LENGTH_SHORT).show();

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
                        i.putExtra("EXTRA_Eleve",intent.getStringExtra("EXTRA_Eleve"));
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
    }
}
