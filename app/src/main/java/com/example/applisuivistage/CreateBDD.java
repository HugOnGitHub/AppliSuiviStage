package com.example.applisuivistage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBDD extends SQLiteOpenHelper {


    private static final String TABLE_ENTREPRISE = "Entreprise";
    static final String COL_IDENTREPRISE = "_idEntreprise";
    private static final String COL_NOMSOCIETE =  "NomSociete";
    private static final String COL_ADRESSE =  "ADRESSE";
    private static final String COL_NUMTEL =  "NumTel";
    private static final String CREATE_TABLEENTREPRISE = "CREATE TABLE " + TABLE_ENTREPRISE + " ("+COL_IDENTREPRISE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOMSOCIETE + " TEXT NOT NULL," + COL_ADRESSE + " TEXT NOT NULL," + COL_NUMTEL + " TEXT NOT NULL);";

    private static final String TABLE_ETUDIANT = "Etudiant";
    static final String COL_IDETUDIANT = "_idEtudiant";
    static final String COL_IDET_ENT = "_idEntEt";
    private static final String COL_NOMETUDIANT = "NomEtudiant";
    private static final String COL_PRENOMETUDIANT = "PrenomEtudiant";
    private static final String COL_CLASSE = "Classe";
    private static final String COL_ANNEE = "Annee";
    private static final String CREATE_TABLEETUDIANT = "CREATE TABLE " + TABLE_ETUDIANT + " ("+COL_IDETUDIANT+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_IDET_ENT + " INTEGER," + COL_NOMETUDIANT + " TEXT NOT NULL," + COL_PRENOMETUDIANT + " TEXT NOT NULL," + COL_CLASSE + " TEXT NOT NULL," + COL_ANNEE + " TEXT NOT NULL," + " FOREIGN KEY("+COL_IDET_ENT+") REFERENCES " + TABLE_ENTREPRISE + " ("+ COL_IDENTREPRISE+"));";

    private static final String TABLE_DATE = "Date";
    static final String COL_IDDATE = "_idDate";
    private static final String COL_DATEDEBUT =  "DateDebut";
    private static final String COL_DATEFIN =  "DateFin";
    private static final String CREATE_TABLEDATE = "CREATE TABLE " + TABLE_DATE + " ("+COL_IDDATE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_DATEDEBUT + " TEXT NOT NULL," + COL_DATEFIN + " TEXT NOT NULL,);";

    private static final String TABLE_PROFESSEUR = "Professeur";
    static final String COL_IDPROFESSEUR = "_idProfesseur";
    private static final String COL_NOM =  "Nom";
    private static final String COL_PRENOM =  "Prenom";
    private static final String COL_EMAIL =  "Email";
    private static final String COL_NUMTELPROF =  "NumTelProf";
    private static final String CREATE_TABLEPROFESSEUR = "CREATE TABLE " + TABLE_PROFESSEUR + " ("+COL_IDPROFESSEUR+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOM + " TEXT NOT NULL," + COL_PRENOM + " TEXT NOT NULL," + COL_EMAIL + " TEXT NOT NULL, "+ COL_NUMTELPROF + " TEXT NOT NULL);";

    private static final String TABLE_TUTEUR = "Tuteur";
    static final String COL_IDTUTEUR = "_idTuteur";
    private static final String COL_NOMTUTEUR =  "NomTuteur";
    private static final String COL_PRENOMTUTEUR =  "PrenomTuteur";
    private static final String COL_EMAILTUTEUR =  "EmailTuteur";
    private static final String COL_NUMTELTUTEUR =  "NumTelTuteur";
    private static final String CREATE_TABLETUTEUR = "CREATE TABLE " + TABLE_TUTEUR + " ("+COL_IDTUTEUR+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOMTUTEUR + " TEXT NOT NULL," + COL_PRENOMTUTEUR + " TEXT NOT NULL," + COL_EMAILTUTEUR + " TEXT NOT NULL, "+ COL_NUMTELTUTEUR + " TEXT NOT NULL);";

    private static final String TABLE_VISITE = "Visite";
    static final String COL_IDVISITE = "_idVisite";
    static final String COL_IDTUTEURV = "_idTuteurV";
    static final String COL_IDPROFESSEURV = "_idProfesseurV";
    static final String COL_IDETUDIANTV = "_idEtudiantV";
    static final String COL_IDENTREPRISEV = "_idEntrepriseV";
    private static final String COL_DATEVISITE = "DateVisite";
    private static final String COL_CONDITIONS = "Conditions";
    private static final String COL_BILAN = "Bilan";
    private static final String COL_RESSOURCES = "Ressources";
    private static final String COL_CLONCLUSION = "Conclusion";
    private static final String COL_JURY = "Jury";
    private static final String COL_OPPORTUNITE = "Opportunite";
    private static final String COL_SIOPPORTUNITE = "SIOpportunite";
    private static final String CREATE_TABLEVISITE = "CREATE TABLE " + TABLE_VISITE + " ("+COL_IDVISITE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_IDTUTEURV + " INTEGER,"+ COL_IDPROFESSEURV + " INTEGER,"+ COL_IDETUDIANTV + " INTEGER,"+ COL_IDENTREPRISEV + " INTEGER,"+ COL_DATEVISITE + " TEXT NOT NULL,"+ COL_CONDITIONS + " TEXT NOT NULL,"+ COL_BILAN + " TEXT NOT NULL,"+ COL_RESSOURCES + " TEXT NOT NULL,"+ COL_CLONCLUSION + " TEXT NOT NULL,"+ COL_JURY + " TEXT NOT NULL,"+ COL_OPPORTUNITE + " TEXT NOT NULL,"+ COL_SIOPPORTUNITE + " TEXT NOT NULL,"+ " FOREIGN KEY("+COL_IDTUTEURV+") REFERENCES " + TABLE_TUTEUR + " ("+ COL_IDTUTEUR+") " + " FOREIGN KEY("+COL_IDPROFESSEURV+") REFERENCES " + TABLE_PROFESSEUR + " ("+ COL_IDPROFESSEUR+") " + " FOREIGN KEY("+COL_IDETUDIANTV+") REFERENCES " + TABLE_ETUDIANT + " ("+ COL_IDETUDIANT+") " + " FOREIGN KEY("+COL_IDENTREPRISEV+") REFERENCES " + TABLE_ENTREPRISE + " ("+ COL_IDENTREPRISE+"));";


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
        //On peut supprimer la table et de la recréeré
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT + ";");
        onCreate(db);
    }


}
