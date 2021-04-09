package com.example.applisuivistage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOBdd {
    static final int VERSION_BDD =12;
    private static final String NOM_BDD = "SuiviStageTestBdd.db";
    //table etudiant
    static final String TABLE_ETUDIANT = "Etudiant";
    static final String COL_IDETUDIANT = "_id";
    static final int NUM_COL_IDETUDIANT = 0;
    static final String COL_IDENT_ETUD = "_idEntEtud";
    static final int NUM_COL_IDENT_ETUD = 1;
    static final String COL_NOMETUDIANT = "NomEtudiant";
    static final int NUM_COL_NOMETUDIANT = 2;
    static final String COL_PRENOMETUDIANT = "PrenomEtudiant";
    static final int NUM_COL_PRENOMETUDIANT = 3;
    static final String COL_CLASSE = "Classe";
    static final int NUM_COL_CLASSE = 4;
    static final String COL_ANNEE = "Annee";
    static final int NUM_COL_ANNEE = 5;
    static final String COL_SPECIALITE = "Specialite";
    static final int NUM_COL_SPECIALITE = 6;
    //table entreprise
    static final String TABLE_ENTREPRISE = "Entreprise";
    static final String COL_IDENTREPRISE = "_id";
    static final int NUM_COL_IDENTREPRISE = 0;
    static final String COL_NOMSOCIETE = "NomSociete";
    static final int NUM_COL_NOMSOCIETE = 1;
    static final String COL_ADRESSE = "Adresse";
    static final int NUM_COL_ADRESSE = 2;
    static final String COL_NUMTELSOCIETE = "NumTelSociete";
    static final int NUM_NUMTELSOCIETE = 3;
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
        values.put(COL_IDENT_ETUD, unEtudiant.get_idEntEtud());
        values.put(COL_NOMETUDIANT, unEtudiant.getNomEtudiant());
        values.put(COL_PRENOMETUDIANT, unEtudiant.getPrenomEtudiant());
        values.put(COL_CLASSE, unEtudiant.getClasse());
        values.put(COL_ANNEE, unEtudiant.getAnnee());
        values.put(COL_SPECIALITE, unEtudiant.getSpecialite());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_ETUDIANT, null, values);
    }
    public Cursor getDataEtudiant(){
        return db.rawQuery("SELECT * FROM Etudiant", null);
    }

    public Cursor getListeNomEtudiant(){
        return db.rawQuery("SELECT " + COL_NOMETUDIANT + " FROM Etudiant", null);
    }
    public Cursor getListePrenomEtudiant(String nom){
        return db.rawQuery("SELECT " + COL_PRENOMETUDIANT + " FROM " + TABLE_ETUDIANT + " WHERE " + COL_NOMETUDIANT + " =\"" + nom +"\"", null);
    }

    public long insererEntreprise (Entreprise uneEntreprise){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOMSOCIETE, uneEntreprise.getNomSociete());
        values.put(COL_ADRESSE, uneEntreprise.getAdresse());
        values.put(COL_NUMTELSOCIETE, uneEntreprise.getNumTelSociete());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_ENTREPRISE, null, values);
    }
    public Cursor getDataEntreprise(){
        return db.rawQuery("SELECT * FROM Entreprise", null);
    }


    public Cursor getListeStages(){
        return db.rawQuery("SELECT * FROM " + TABLE_ETUDIANT + " ETUD INNER JOIN " + TABLE_ENTREPRISE + " ENT ON ETUD."+COL_IDENT_ETUD+" = ENT."+COL_IDENTREPRISE+"" , null);
    }
    /***public Cursor getListeEtudiants(){
        return db.rawQuery("SELECT " + COL_IDETUDIANT + " FROM " + TABLE_ETUDIANT +" WHERE " + COL_NOM + " =\"" + nom +"\"", null);
    }
    public Cursor getUnTuteur(){
        return db.rawQuery("SELECT " + COL_IDETUDIANT + " FROM " + TABLE_ETUDIANT +" WHERE " + COL_NOM + " =\"" + nom +"\"", null);
    }
    public Cursor getUnProfesseur(){
        return db.rawQuery("SELECT " + COL_IDETUDIANT + " FROM " + TABLE_ETUDIANT +" WHERE " + COL_NOM + " =\"" + nom +"\"", null);
    }*/
    public Cursor getUnEtudiant(String nom, String prenom){
        return db.rawQuery("SELECT " + COL_IDETUDIANT + " FROM " + TABLE_ETUDIANT +" WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\"", null);
    }
    /***public Cursor getUneEntreprise(){
        return db.rawQuery("SELECT " + COL_IDETUDIANT + " FROM " + TABLE_ETUDIANT +" WHERE " + COL_NOM + " =\"" + nom +"\"", null);
    }*/
}
