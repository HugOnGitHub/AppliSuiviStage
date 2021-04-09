package com.example.applisuivistage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class AfficherStagesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_stages);

        //Création d'une instance de la classe DAOBdd
        DAOBdd stagesBdd = new DAOBdd(this);
        //on associe un objet java à la liste view des stages
        ListView listViewStages = findViewById(R.id.listViewStages);
        //On ouvre la table
        stagesBdd.open();
        //on récupère tous les releves via le curseur
        Cursor c = stagesBdd.getListeStages();
        Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(c.getCount()) +
                " stages selectionnes", Toast.LENGTH_LONG).show();
        // colonnes à afficher
        String[] columns = new String[]{DAOBdd.COL_NOMETUDIANT, DAOBdd.COL_PRENOMETUDIANT, DAOBdd.COL_NOMSOCIETE};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.textViewNom, R.id.textViewPrenom, R.id.textViewEntreprise};
        //on choisit le type d’adapter pour notre affichage de la liste
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this,
                R.layout.activity_afficher_stages, c, columns, to, 0);
        // on assigne cet adapter à notre ListView
        listViewStages.setAdapter(dataAdapter);
        //on ferme la table
        stagesBdd.close();
    }
}
