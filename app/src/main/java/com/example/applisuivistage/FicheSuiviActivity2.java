package com.example.applisuivistage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
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

        Intent intent2 = getIntent();
        Toast.makeText(FicheSuiviActivity2.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Specialite"), Toast.LENGTH_SHORT).show();
        Toast.makeText(FicheSuiviActivity2.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Nom"), Toast.LENGTH_SHORT).show();

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
    }
}
