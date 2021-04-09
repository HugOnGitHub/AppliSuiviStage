package com.example.applisuivistage;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.enableDefaults();
        OkHttpClient Etudiant = new OkHttpClient();
        Request requestClients = new Request.Builder().url("http://192.168.56.1/apiClient/getAllClientsJSON.php").build();
        //on associe à un objet java de type Button, un widget repéré physiquement par son id
        Button btnAfficherStages = findViewById(R.id.btnAfficherStages);
        Button btnFicheSuivi = findViewById(R.id.btnFicheSuivi);
        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAfficherStages:
                        Intent intent1 = new Intent(MainActivity.this, AfficherStagesActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.btnFicheSuivi:
                        Intent intent2 = new Intent(MainActivity.this, FicheSuiviActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        };
        //on affecte au bouton l'écouteur
        btnAfficherStages.setOnClickListener(ecouteur);
        btnFicheSuivi.setOnClickListener(ecouteur);

        remplirTableEntreprise();
        remplirTableEtudiant();
        }

    public void remplirTableEntreprise() {
        DAOBdd entrepriseBdd = new DAOBdd(this);
        Entreprise entreprise1 = new Entreprise("A3WEB", "Rue de Belgique, 49280 La Séguinière", "02 52 45 00 10");
        Entreprise entreprise2 = new Entreprise("BESYNC", "18 Rue du Moulin des Landes, 44840 Les Sorinières", "02 85 52 61 70");
        Entreprise entreprise3 = new Entreprise("Rectorat de Nantes", "4 Chemin de la Houssinière, 44300 Nantes", "02 40 37 37 37");
        Entreprise entreprise4 = new Entreprise("Lycée Briacé", "Pole de Formation Briace, 44430 Le Landreau", "02 40 06 43 33");
        //on ouvre la base de données
        entrepriseBdd.open();
        //on insère etudiant1, etudiant2 puis etudiant3
        entrepriseBdd.insererEntreprise(entreprise1);
        entrepriseBdd.insererEntreprise(entreprise2);
        entrepriseBdd.insererEntreprise(entreprise3);
        entrepriseBdd.insererEntreprise(entreprise4);
        //le curseur pour afficher le nombre de lacs dans la base
        Cursor c = entrepriseBdd.getDataEntreprise();
        Toast.makeText(getApplicationContext(), " il y a " +
                String.valueOf(c.getCount()) + " entreprises ", Toast.LENGTH_LONG).show();
        entrepriseBdd.close();
    }

    public void remplirTableEtudiant() {
        DAOBdd etudiantBdd = new DAOBdd(this);
        Etudiant etudiant1 = new Etudiant(1, "Sourice", "Clémentin", "2SLAM", "2021", "SLAM");
        Etudiant etudiant2 = new Etudiant(2, "Dabin", "Hugo", "2SLAM", "2021", "SLAM");
        Etudiant etudiant3 = new Etudiant(3, "Moinard", "Florian", "2SLAM", "2021", "SLAM");
        Etudiant etudiant4 = new Etudiant(4, "Guyon", "Carmin", "2SLAM", "2021", "SLAM");
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
        etudiantBdd.close();
    }

}