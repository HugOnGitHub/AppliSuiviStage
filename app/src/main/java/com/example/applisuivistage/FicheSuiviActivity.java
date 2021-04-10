package com.example.applisuivistage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FicheSuiviActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport_1);

        //on déclare en final les données passées à l'autre interface
        final TextView annee = findViewById(R.id.checkedTextViewAnnee);
        final TextView classe = findViewById(R.id.checkedTextViewClasse);
        final String[] leNom = new String[1];
        final String[] lePrenom = new String[1];
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioSpecialite);
        final String selectedRadioValue =((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();

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
                        Intent i = new Intent(FicheSuiviActivity.this, FicheSuiviActivity2.class);
                        i.putExtra("EXTRA_Nom",leNom[0]);
                        i.putExtra("EXTRA_Prenom",lePrenom[0]);
                        i.putExtra("EXTRA_Annee",annee.getText().toString());
                        i.putExtra("EXTRA_Classe",classe.getText().toString());
                        i.putExtra("EXTRA_Specialite",selectedRadioValue);
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

        //gestion de la liste déroulante des noms
        Cursor c = FicheSuiviBdd.getListeNomEtudiant();
        ArrayList<String> bddNomEtudiant = new ArrayList<String>();
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            // The Cursor is now set to the right position
            bddNomEtudiant.add(c.getString(c.getColumnIndex("NomEtudiant")));
        }

        final Spinner spinnerNomEleve = (Spinner) findViewById(R.id.spinnerNomEleve);
        ArrayAdapter<String> dataAdapterR2 = new ArrayAdapter <String>( this ,
                android.R.layout.simple_spinner_item ,bddNomEtudiant );
        dataAdapterR2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
        );
        spinnerNomEleve.setAdapter(dataAdapterR2);
        spinnerNomEleve.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void
            onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                leNom[0] =
                        String.valueOf(spinnerNomEleve.getSelectedItem());

                //gestion de la liste déroulante des prenoms
                Cursor c1 = FicheSuiviBdd.getListePrenomEtudiant(leNom[0]);
                ArrayList<String> bddPrenomEtudiant = new ArrayList<String>();
                for(c1.moveToFirst(); !c1.isAfterLast(); c1.moveToNext()) {
                    // The Cursor is now set to the right position
                    bddPrenomEtudiant.add(c1.getString(c1.getColumnIndex("PrenomEtudiant")));
                }

                final Spinner spinnerPrenomEleve = (Spinner) findViewById(R.id.spinnerPrenomEleve);
                ArrayAdapter<String> dataAdapterR = new ArrayAdapter <String>(FicheSuiviActivity.this ,
                        android.R.layout.simple_spinner_item ,bddPrenomEtudiant );
                dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
                );
                spinnerPrenomEleve.setAdapter(dataAdapterR);
                spinnerPrenomEleve.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void
                    onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        lePrenom[0] =
                                String.valueOf(spinnerPrenomEleve.getSelectedItem());

                        //recuperation de l'annee et de classe en fonction des listes déroulantes
                        Cursor c2 = FicheSuiviBdd.getInfosEtudiant(leNom[0], lePrenom[0]);
                        // champs dans lesquelles afficher les colonnes
                        if(c2.moveToFirst()) {
                            // The Cursor is now set to the right position
                            TextView Annee = (TextView)findViewById(R.id.checkedTextViewAnnee);
                            Annee.setText(c2.getString(c2.getColumnIndex("Annee")));
                            TextView Classe = (TextView)findViewById(R.id.checkedTextViewClasse);
                            Classe.setText(c2.getString(c2.getColumnIndex("Classe")));
                            if (c2.getString(c2.getColumnIndex("Specialite")).equals("Spécialité SLAM (Développeur)")) {
                                rg.check(R.id.radioSLAM);
                            } else {
                                rg.check(R.id.radioSISR);
                            }
                        }
                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        //cas où rien n'est sélectionné dans la liste
                    }
                });
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //cas où rien n'est sélectionné dans la liste
            }
        });
    }
}
