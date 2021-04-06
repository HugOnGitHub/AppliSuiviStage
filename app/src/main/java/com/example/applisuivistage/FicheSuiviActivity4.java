package com.example.applisuivistage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FicheSuiviActivity4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport_4);

        //on déclare en final les données passées à l'autre interface
        final EditText ressourcesOutils = findViewById(R.id.editRessourcesOutils);
        final EditText commentairesAppreciations = findViewById(R.id.editCommentairesAppreciations);

        Intent intent2 = getIntent();
        Toast.makeText(FicheSuiviActivity4.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Specialite"), Toast.LENGTH_SHORT).show();
        Toast.makeText(FicheSuiviActivity4.this, "Vous avez choisi : " + "\nla specialité : " + intent2.getStringExtra("EXTRA_Nom"), Toast.LENGTH_SHORT).show();

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
                        Intent i = new Intent(FicheSuiviActivity4.this, FicheSuiviActivity4.class);
                        i.putExtra("EXTRA_Nom",intent.getStringExtra("EXTRA_Nom"));
                        i.putExtra("EXTRA_Prenom",intent.getStringExtra("EXTRA_Prenom"));
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
                        i.putExtra("EXTRA_ConditionsStages",intent.getStringExtra("EXTRA_ConditionsStages"));
                        i.putExtra("EXTRA_BilanTravaux",intent.getStringExtra("EXTRA_BilanTravaux"));
                        i.putExtra("EXTRA_RessourcesOutils",ressourcesOutils.getText().toString());
                        i.putExtra("EXTRA_CommentairesAppreciations",commentairesAppreciations.getText().toString());
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
