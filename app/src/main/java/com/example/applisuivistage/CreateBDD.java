package com.example.applisuivistage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateBDD extends SQLiteOpenHelper {


    private static final String TABLE_ENTREPRISE = "Entreprise";
    static final String COL_IDENTREPRISE = "_id";
    private static final String COL_NOMSOCIETE =  "NomSociete";
    private static final String COL_ADRESSE =  "Adresse";
    private static final String COL_NUMTELSOCIETE =  "NumTelSociete";
    private static final String CREATE_TABLEENTREPRISE = "CREATE TABLE " + TABLE_ENTREPRISE + " ("+COL_IDENTREPRISE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_NOMSOCIETE + " TEXT NOT NULL," + COL_ADRESSE +
            " TEXT NOT NULL," + COL_NUMTELSOCIETE + " TEXT NOT NULL);";

    private static final String TABLE_ETUDIANT = "Etudiant";
    static final String COL_IDETUDIANT = "_id";
    private static final String COL_NOMETUDIANT = "NomEtudiant";
    private static final String COL_PRENOMETUDIANT = "PrenomEtudiant";
    private static final String COL_CLASSE = "Classe";
    private static final String COL_ANNEE = "Annee";
    private static final String COL_SPECIALITE = "Specialite";
    private static final String CREATE_TABLEETUDIANT = "CREATE TABLE " + TABLE_ETUDIANT + " ("+COL_IDETUDIANT+" INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NOMETUDIANT +
            " TEXT NOT NULL," + COL_PRENOMETUDIANT + " TEXT NOT NULL," + COL_CLASSE + " TEXT NOT NULL," + COL_ANNEE + " TEXT NOT NULL," + COL_SPECIALITE + " TEXT NOT NULL);";

    private static final String TABLE_DATE = "Date";
    static final String COL_IDDATE = "_id";
    private static final String COL_DATEDEBUT =  "DateDebut";
    private static final String COL_DATEFIN =  "DateFin";
    private static final String CREATE_TABLEDATE = "CREATE TABLE " + TABLE_DATE + " ("+COL_IDDATE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_DATEDEBUT + " TEXT NOT NULL," + COL_DATEFIN + " TEXT NOT NULL);";

    private static final String TABLE_PROFESSEUR = "Professeur";
    static final String COL_IDPROFESSEUR = "_id";
    private static final String COL_IDENTITEPROF =  "IdentiteProf";
    private static final String COL_EMAILPROF =  "EmailProf";
    private static final String COL_NUMTELPROF =  "NumTelProf";
    private static final String CREATE_TABLEPROFESSEUR = "CREATE TABLE " + TABLE_PROFESSEUR + " ("+COL_IDPROFESSEUR+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_IDENTITEPROF +
            " TEXT NOT NULL," + COL_EMAILPROF + " TEXT NOT NULL, "+ COL_NUMTELPROF + " TEXT NOT NULL);";

    private static final String TABLE_TUTEUR = "Tuteur";
    static final String COL_IDTUTEUR = "_id";
    private static final String COL_IDENTITETUTEUR =  "IdentiteTuteur";
    private static final String COL_EMAILTUTEUR =  "EmailTuteur";
    private static final String COL_NUMTELTUTEUR =  "NumTelTuteur";
    private static final String CREATE_TABLETUTEUR = "CREATE TABLE " + TABLE_TUTEUR + " ("+COL_IDTUTEUR+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_IDENTITETUTEUR +
            " TEXT NOT NULL," + COL_EMAILTUTEUR + " TEXT NOT NULL, "+ COL_NUMTELTUTEUR + " TEXT NOT NULL);";

    private static final String TABLE_STAGE = "Stage";
    static final String COL_IDSTAGE = "_id";
    static final String COL_IDTUTEUR_STAGE = "_idTuteurStage";
    static final String COL_IDPROFESSEUR_STAGE = "_idProfesseurStage";
    static final String COL_IDETUDIANT_STAGE = "_idEtudiantStage";
    static final String COL_IDENTREPRISE_STAGE = "_idEntrepriseStage";
    private static final String CREATE_TABLESTAGE = "CREATE TABLE " + TABLE_STAGE + " ("+COL_IDSTAGE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_IDTUTEUR_STAGE + " INTEGER,"+ COL_IDPROFESSEUR_STAGE + " INTEGER,"+ COL_IDETUDIANT_STAGE + " INTEGER,"+ COL_IDENTREPRISE_STAGE + " INTEGER,"
            + " FOREIGN KEY("+COL_IDTUTEUR_STAGE+") REFERENCES " + TABLE_TUTEUR + " ("+ COL_IDTUTEUR+"), "
            + " FOREIGN KEY("+COL_IDPROFESSEUR_STAGE+") REFERENCES " + TABLE_PROFESSEUR + " ("+ COL_IDPROFESSEUR+"), "
            + " FOREIGN KEY("+COL_IDETUDIANT_STAGE+") REFERENCES " + TABLE_ETUDIANT + " ("+ COL_IDETUDIANT+"), "
            + " FOREIGN KEY("+COL_IDENTREPRISE_STAGE+") REFERENCES " + TABLE_ENTREPRISE + " ("+ COL_IDENTREPRISE+")" +");";

    private static final String TABLE_VISITE = "Visite";
    static final String COL_IDVISITE = "_id";
    static final String COL_IDSTAGE_VISITE = "_idStageVisite";
    private static final String COL_DATEVISITE = "DateVisite";
    private static final String COL_CONDITIONS = "Conditions";
    private static final String COL_BILAN = "Bilan";
    private static final String COL_RESSOURCES = "Ressources";
    private static final String COL_CONCLUSION = "Conclusion";
    private static final String COL_JURY = "Jury";
    private static final String COL_OPPORTUNITE = "Opportunite";
    private static final String COL_SIOPPORTUNITE = "SIOpportunite";
    private static final String CREATE_TABLEVISITE = "CREATE TABLE " + TABLE_VISITE + " ("+COL_IDVISITE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_IDSTAGE_VISITE + " INTEGER,"+ COL_DATEVISITE + " TEXT NOT NULL,"+ COL_CONDITIONS +
            " TEXT NOT NULL,"+ COL_BILAN + " TEXT NOT NULL,"+ COL_RESSOURCES + " TEXT NOT NULL,"+ COL_CONCLUSION + " TEXT NOT NULL,"+ COL_JURY + " TEXT NOT NULL,"+ COL_OPPORTUNITE +
            " TEXT NOT NULL,"+ COL_SIOPPORTUNITE + " TEXT NOT NULL,"
            + " FOREIGN KEY("+COL_IDSTAGE_VISITE+") REFERENCES " + TABLE_STAGE + " ("+ COL_IDSTAGE+")" +");";


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
        db.execSQL(CREATE_TABLEENTREPRISE);
        db.execSQL(CREATE_TABLEETUDIANT);
        db.execSQL(CREATE_TABLEPROFESSEUR);
        db.execSQL(CREATE_TABLETUTEUR);
        db.execSQL(CREATE_TABLEVISITE);
        db.execSQL(CREATE_TABLEDATE);
        db.execSQL(CREATE_TABLESTAGE);
    }
    // appelée si la version de la base a changé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut supprimer la table et la recréeré
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAGE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENTREPRISE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFESSEUR + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TUTEUR + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATE + ";");
        onCreate(db);
    }


}
