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

        remplirTableEtudiant();
        remplirTableProfesseur();
        remplirTableTuteur();
        remplirTableEntreprise();
        remplirTableStage();
        }

    public void remplirTableEtudiant() {
        DAOBdd etudiantBdd = new DAOBdd(this);
        Etudiant etudiant1 = new Etudiant("Sourice", "Clémentin", "2SLAM", "2021", "Spécialité SLAM (Développeur)");
        Etudiant etudiant2 = new Etudiant("Dabin", "Hugo", "2SLAM", "2021", "Spécialité SLAM (Développeur)");
        Etudiant etudiant3 = new Etudiant("Moinard", "Florian", "2SLAM", "2021", "Spécialité SLAM (Développeur)");
        Etudiant etudiant4 = new Etudiant("Guyon", "Carmin", "2SLAM", "2021", "Spécialité SISR (Administrateur Réseau)");
        //on ouvre la base de données
        etudiantBdd.open();
        //on insère etudiant1, etudiant2 puis etudiant3
        etudiantBdd.insererEtudiant(etudiant1);
        etudiantBdd.insererEtudiant(etudiant2);
        etudiantBdd.insererEtudiant(etudiant3);
        etudiantBdd.insererEtudiant(etudiant4);
        etudiantBdd.close();
    }

    public void remplirTableProfesseur() {
        DAOBdd professeurBdd = new DAOBdd(this);
        Professeur professeur1 = new Professeur("Contant Nelly", "ncontant@la-joliverie.com", "06 06 06 06 06");
        Professeur professeur2 = new Professeur("Bourgeois Nicolas", "nbourgeois@la-joliverie.com", "07 07 07 07 07");
        //on ouvre la base de données
        professeurBdd.open();
        //on insère professeur1, professeur2
        professeurBdd.insererProfesseur(professeur1);
        professeurBdd.insererProfesseur(professeur2);
        professeurBdd.close();
    }

    public void remplirTableTuteur() {
        DAOBdd tuteurBdd = new DAOBdd(this);
        Tuteur tuteur1 = new Tuteur("Souris Clara", "clara.souris@a3web.fr", "06 78 54 25 63");
        Tuteur tuteur2 = new Tuteur("Chiri Baptiste", "baptiste@besync.fr", "06 07 08 09 10");
        Tuteur tuteur3 = new Tuteur("Moineau Sacha", "sacha.moineau@rectorat.fr", "07 08 10 45 12");
        Tuteur tuteur4 = new Tuteur("Gucon Caroline", "caroline.gucon@briace.fr", "06 95 85 45 25");
        //on ouvre la base de données
        tuteurBdd.open();
        //on insère tuteur1, tuteur2 puis tuteur3
        tuteurBdd.insererTuteur(tuteur1);
        tuteurBdd.insererTuteur(tuteur2);
        tuteurBdd.insererTuteur(tuteur3);
        tuteurBdd.insererTuteur(tuteur4);
        tuteurBdd.close();
    }

    public void remplirTableEntreprise() {
        DAOBdd entrepriseBdd = new DAOBdd(this);
        Entreprise entreprise1 = new Entreprise("A3WEB", "Rue de Belgique, 49280 La Séguinière", "02 52 45 00 10");
        Entreprise entreprise2 = new Entreprise("BESYNC", "18 Rue du Moulin des Landes, 44840 Les Sorinières", "02 85 52 61 70");
        Entreprise entreprise3 = new Entreprise("Rectorat de Nantes", "4 Chemin de la Houssinière, 44300 Nantes", "02 40 37 37 37");
        Entreprise entreprise4 = new Entreprise("Lycée Briacé", "Pole de Formation Briace, 44430 Le Landreau", "02 40 06 43 33");
        //on ouvre la base de données
        entrepriseBdd.open();
        //on insère entreprise1, entreprise2 puis entreprise3
        entrepriseBdd.insererEntreprise(entreprise1);
        entrepriseBdd.insererEntreprise(entreprise2);
        entrepriseBdd.insererEntreprise(entreprise3);
        entrepriseBdd.insererEntreprise(entreprise4);
        entrepriseBdd.close();
    }

    public void remplirTableStage() {
        DAOBdd stageBdd = new DAOBdd(this);
        Stage stage1 = new Stage(1, 1, 1, 1);
        Stage stage2 = new Stage(2, 2, 2, 2);
        Stage stage3 = new Stage(3, 1, 3, 3);
        Stage stage4 = new Stage(4, 2, 4, 4);
        //on ouvre la base de données
        stageBdd.open();
        //on insère stage1, stage2 puis stage3
        stageBdd.insererStage(stage1);
        stageBdd.insererStage(stage2);
        stageBdd.insererStage(stage3);
        stageBdd.insererStage(stage4);
        stageBdd.close();
    }

}