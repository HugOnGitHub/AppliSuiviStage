package com.example.applisuivistage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOBdd {
    static final int VERSION_BDD =2;
    private static final String NOM_BDD = "SuiviStageTestBdd.db";
    //table etudiant
    static final String TABLE_ETUDIANT = "Etudiant";
    static final String COL_IDETUDIANT = "_id";
    static final int NUM_COL_IDETUDIANT = 0;
    static final String COL_NOM = "Nom";
    static final int NUM_COL_NOM = 1;
    static final String COL_PRENOM = "Prenom";
    static final int NUM_COL_PRENOM = 2;
    static final String COL_CLASSE = "Classe";
    static final int NUM_COL_CLASSE = 3;
    static final String COL_ANNEE = "Annee";
    static final int NUM_COL_ANNEE = 3;
    private CreateBDD tableCourante;
    private Context context;
    private SQLiteDatabase db;
    //le constructeur
    public DAOBdd(Context context){
        this.context = context;
        tableCourante = new CreateBDD(context, NOM_BDD, null, VERSION_BDD);
    }
    //si la bdd n’existe pas, l’objet SQLiteOpenHelper exécute la méthode onCreate
    // si la version de la base a changé, la méthode onUpgrade sera lancée
    // dans les 2 cas l’appel à getWritableDatabase ou getReadableDatabase renverra la base
    // de données en cache, nouvellement ouverte, nouvellement créée ou mise à jour
    //les méthodes d'instance
    public DAOBdd open(){
        db = tableCourante.getWritableDatabase();
        return this;
    }
    public DAOBdd close(){
        db.close();
        return null;
    }
    public long insererEtudiant (Etudiant unEtudiant){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM, unEtudiant.getNom());
        values.put(COL_PRENOM, unEtudiant.getPrenom());
        values.put(COL_CLASSE, unEtudiant.getClasse());
        values.put(COL_ANNEE, unEtudiant.getAnnee());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_ETUDIANT, null, values);
    }
    public Cursor getDataEtudiant(){
        return db.rawQuery("SELECT * FROM Etudiant", null);
    }
    public Cursor getListeEtudiants(){
        return db.rawQuery("SELECT * FROM " + TABLE_ETUDIANT + "", null);
    }
}
