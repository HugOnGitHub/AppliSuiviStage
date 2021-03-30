package com.example.applisuivistage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBDD extends SQLiteOpenHelper {
    private static final String TABLE_ETUDIANT = "Etudiant";
    static final String COL_IDETUDIANT = "_id";
    private static final String COL_NOM = "Nom";
    private static final String COL_PRENOM = "Prenom";
    private static final String COL_CLASSE = "Classe";
    private static final String COL_ANNEE = "Annee";
    private static final String CREATE_TABLEETUDIANT = "CREATE TABLE " + TABLE_ETUDIANT + " ("+COL_IDETUDIANT+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM + " TEXT NOT NULL," + COL_PRENOM + " TEXT NOT NULL," + COL_CLASSE + " TEXT NOT NULL," + COL_ANNEE + " TEXT NOT NULL);";

    //constructeur paramétré
    public CreateBDD(Context context, String name, SQLiteDatabase.CursorFactory
            factory, int version) {
        super(context, name, factory, version);
    }
    //méthodes d'instance permettant la gestion de l'objet
    @Override
    public void onCreate(SQLiteDatabase db) {
        //appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLEETUDIANT);

    }
    // appelée si la version de la base a changé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut supprimer la table et de la recréer
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT + ";");
        onCreate(db);
    }
}
