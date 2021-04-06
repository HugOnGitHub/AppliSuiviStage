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
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioSpecialite);
        final String selectedRadioValue =((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();
        Toast.makeText(FicheSuiviActivity.this, "Vous avez choisi : " + "\nla specialité : " + selectedRadioValue, Toast.LENGTH_SHORT).show();

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

        //gestion de la liste déroulante des prenoms
        final Spinner spinnerPrenomEleve = (Spinner) findViewById(R.id.spinnerPrenomEleve);
        String[] lesprenoms={"Florian Moinard", "Carmin Guyon", "Hugo Dabin", "Clémentin Sourice"};
        ArrayAdapter<String> dataAdapterR = new ArrayAdapter <String>( this ,
                android.R.layout.simple_spinner_item ,lesprenoms );
        dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
        );
        spinnerPrenomEleve.setAdapter(dataAdapterR);
        spinnerPrenomEleve.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void
            onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lePrenom[0] =
                        String.valueOf(spinnerPrenomEleve.getSelectedItem());

                Toast.makeText(FicheSuiviActivity.this, "Vous avez choisi : " + "\nle prenom : " + lePrenom[0], Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //cas où rien n'est sélectionné dans la liste
            }
        });

        //gestion de la liste déroulante des noms
        final Spinner spinnerNomEleve = (Spinner) findViewById(R.id.spinnerNomEleve);
        String[] lesnoms={"Moinard", "Carmin Guyon", "Hugo Dabin", "Clémentin Sourice"};
        ArrayAdapter<String> dataAdapterR2 = new ArrayAdapter <String>( this ,
                android.R.layout.simple_spinner_item ,lesnoms );
        dataAdapterR2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
        );
        spinnerNomEleve.setAdapter(dataAdapterR2);
        spinnerNomEleve.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void
            onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                leNom[0] =
                        String.valueOf(spinnerNomEleve.getSelectedItem());

                Toast.makeText(FicheSuiviActivity.this, "Vous avez choisi : " + "\nle nom : " + leNom[0], Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //cas où rien n'est sélectionné dans la liste
            }
        });
    }
}
