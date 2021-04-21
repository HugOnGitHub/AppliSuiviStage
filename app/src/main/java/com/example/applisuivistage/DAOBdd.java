package com.example.applisuivistage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAOBdd {
    static final int VERSION_BDD =1;
    private static final String NOM_BDD = "BDDSuiviStage.db";
    //table etudiant
    static final String TABLE_ETUDIANT = "Etudiant";
    static final String COL_IDETUDIANT = "_id";
    static final int NUM_COL_IDETUDIANT = 0;
    static final String COL_NOMETUDIANT = "NomEtudiant";
    static final int NUM_COL_NOMETUDIANT = 1;
    static final String COL_PRENOMETUDIANT = "PrenomEtudiant";
    static final int NUM_COL_PRENOMETUDIANT = 2;
    static final String COL_CLASSE = "Classe";
    static final int NUM_COL_CLASSE = 3;
    static final String COL_ANNEE = "Annee";
    static final int NUM_COL_ANNEE = 4;
    static final String COL_SPECIALITE = "Specialite";
    static final int NUM_COL_SPECIALITE = 5;
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
    //table stage
    static final String TABLE_STAGE = "Stage";
    static final String COL_IDSTAGE = "_id";
    static final int NUM_COL_IDSTAGE = 0;
    static final String COL_IDTUTEUR_STAGE = "_idTuteurStage";
    static final int NUM_COL_IDTUTEUR_STAGE = 1;
    static final String COL_IDPROFESSEUR_STAGE = "_idProfesseurStage";
    static final int NUM_COL_IDPROFESSEUR_STAGE = 2;
    static final String COL_IDETUDIANT_STAGE = "_idEtudiantStage";
    static final int NUM_COL_IDETUDIANT_STAGE = 3;
    static final String COL_IDENTREPRISE_STAGE = "_idEntrepriseStage";
    static final int NUM_COL_IDENTREPRISE_STAGE = 4;
    //table professeur
    static final String TABLE_PROFESSEUR = "Professeur";
    static final String COL_IDPROFESSEUR = "_id";
    static final int NUM_COL_IDPROFESSEUR = 0;
    static final String COL_IDENTITEPROF = "IdentiteProf";
    static final int NUM_COL_IDENTITEPROF = 1;
    static final String COL_EMAILPROF = "EmailProf";
    static final int NUM_COL_EMAILPROF = 2;
    static final String COL_NUMTELPROF = "NumTelProf";
    static final int NUM_COL_NUMTELPROF = 3;
    //table professeur
    static final String TABLE_TUTEUR = "Tuteur";
    static final String COL_IDTUTEUR = "_id";
    static final int NUM_COL_IDTUTEUR = 0;
    static final String COL_IDENTITETUTEUR = "IdentiteTuteur";
    static final int NUM_COL_IDENTITETUTEUR = 1;
    static final String COL_EMAILTUTEUR = "EmailTuteur";
    static final int NUM_COL_EMAILTUTEUR = 3;
    static final String COL_NUMTELTUTEUR = "NumTelTuteur";
    static final int NUM_COL_NUMTELTUTEUR = 4;
    //table date
    static final String TABLE_DATE = "Date";
    static final String COL_IDDATE = "_id";
    static final int NUM_COL_IDDATE = 0;
    static final String COL_DATEDEBUT = "DateDebut";
    static final int NUM_COL_DATEDEBUT = 1;
    static final String COL_DATEFIN = "DateFin";
    static final int NUM_COL_DATEFIN = 2;
    //table visite
    static final String TABLE_VISITE = "Visite";
    static final String COL_IDVISITE = "_id";
    static final int NUM_COL_IDVISITE = 0;
    static final String COL_IDSTAGE_VISITE = "_idStageVisite";
    static final int NUM_COL_IDSTAGE_VISITE = 1;
    static final String COL_DATEVISITE = "DateVisite";
    static final int NUM_COL_DATEVISITE = 2;
    static final String COL_CONDITIONS = "Conditions";
    static final int NUM_COL_CONDITIONS = 3;
    static final String COL_BILAN = "Bilan";
    static final int NUM_COL_BILAN = 4;
    static final String COL_RESSOURCES = "Ressources";
    static final int NUM_COL_RESSOURCES = 5;
    static final String COL_CONCLUSION = "Conclusion";
    static final int NUM_COL_CONCLUSION = 6;
    static final String COL_JURY = "Jury";
    static final int NUM_COL_JURY = 7;
    static final String COL_OPPORTUNITE = "Opportunite";
    static final int NUM_COL_OPPORTUNITE = 8;
    static final String COL_SIOPPORTUNITE = "SIOpportunite";
    static final int NUM_COL_SIOPPORTUNITE = 9;
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
    public Cursor getInfosEtudiant(String nom, String prenom){
        return db.rawQuery("SELECT Annee, Classe, Specialite FROM " + TABLE_ETUDIANT + " WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\"", null);
    }
    public Cursor updateEtudiant(String nom, String prenom, String specialite){
        return db.rawQuery("UPDATE "+ TABLE_ETUDIANT
                + " SET " + COL_SPECIALITE + " =\"" + specialite
                + "\" WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\"", null);
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

    public Cursor updateEntreprise(String nom, String prenom, String entreprise){
        return db.rawQuery("UPDATE "+ TABLE_ENTREPRISE
                + " SET " + COL_NOMSOCIETE + " =\"" + entreprise
                + "\" WHERE " + COL_IDENTREPRISE
                + " = (SELECT " + COL_IDENTREPRISE_STAGE + " FROM STAGE STA"
                        + " INNER JOIN " + TABLE_ETUDIANT + " ETUD ON STA."+COL_IDETUDIANT_STAGE+" = ETUD."+COL_IDETUDIANT
                        + " WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\""
                        + "AND " + COL_IDENTREPRISE_STAGE + " = Entreprise.\"" + COL_IDENTREPRISE +"\")", null);
    }





    public long insererStage (Stage unStage){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_IDTUTEUR_STAGE, unStage.get_idTuteurStage());
        values.put(COL_IDPROFESSEUR_STAGE, unStage.get_idProfesseurStage());
        values.put(COL_IDETUDIANT_STAGE, unStage.get_idEtudiantStage());
        values.put(COL_IDENTREPRISE_STAGE, unStage.get_idEntrepriseStage());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_STAGE, null, values);
    }
    public Cursor getDataStage(){
        return db.rawQuery("SELECT * FROM Stage", null);
    }

    public Cursor getListeStages(){
        return db.rawQuery("SELECT * FROM " + TABLE_STAGE
                + " STA INNER JOIN " + TABLE_ETUDIANT + " ETUD ON STA."+COL_IDETUDIANT_STAGE+" = ETUD."+COL_IDETUDIANT
                + " INNER JOIN " + TABLE_ENTREPRISE + " ENT ON STA."+COL_IDENTREPRISE_STAGE+" = ENT."+COL_IDENTREPRISE+"" , null);
    }

    public Cursor getInfosStage(String nom, String prenom){
        return db.rawQuery("SELECT * FROM " + TABLE_STAGE
                + " STA INNER JOIN " + TABLE_PROFESSEUR + " PROF ON STA."+COL_IDPROFESSEUR_STAGE+" = PROF."+COL_IDPROFESSEUR
                + " INNER JOIN " + TABLE_ENTREPRISE + " ENT ON STA."+COL_IDENTREPRISE_STAGE+" = ENT."+COL_IDENTREPRISE
                + " INNER JOIN " + TABLE_TUTEUR + " TUT ON STA."+COL_IDTUTEUR_STAGE+" = TUT."+COL_IDTUTEUR
                + " INNER JOIN " + TABLE_ETUDIANT + " ETUD ON STA."+COL_IDETUDIANT_STAGE+" = ETUD."+COL_IDETUDIANT
                + " WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\"", null);
    }

    public Cursor getIDStage(String nom, String prenom){
        return db.rawQuery("SELECT STA."+COL_IDSTAGE +" FROM " + TABLE_STAGE
                + " STA INNER JOIN " + TABLE_ETUDIANT + " ETUD ON STA."+COL_IDETUDIANT_STAGE+" = ETUD."+COL_IDETUDIANT
                + " WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\"", null);
    }





    public long insererProfesseur (Professeur unProfesseur){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_IDENTITEPROF, unProfesseur.getIdentiteProf());
        values.put(COL_EMAILPROF, unProfesseur.getEmailProf());
        values.put(COL_NUMTELPROF, unProfesseur.getNumTelProf());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_PROFESSEUR, null, values);
    }
    public Cursor getDataProfesseur(){
        return db.rawQuery("SELECT * FROM Professeur", null);
    }

    public Cursor updateProfesseur(String nom, String prenom, String tuteur, String mail){
        return db.rawQuery("UPDATE "+ TABLE_PROFESSEUR
                + " SET " + COL_IDENTITEPROF + " =\"" + tuteur + "\", "
                + COL_EMAILPROF + " =\"" + mail
                + "\" WHERE " + COL_IDPROFESSEUR
                + " = (SELECT " + COL_IDPROFESSEUR_STAGE + " FROM STAGE STA"
                        + " INNER JOIN " + TABLE_ETUDIANT + " ETUD ON STA."+COL_IDETUDIANT_STAGE+" = ETUD."+COL_IDETUDIANT
                        + " WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\""
                        + "AND " + COL_IDPROFESSEUR_STAGE + " = Professeur.\"" + COL_IDPROFESSEUR +"\")", null);
    }





    public long insererTuteur (Tuteur unTuteur){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_IDENTITETUTEUR, unTuteur.getIdentiteTuteur());
        values.put(COL_EMAILTUTEUR, unTuteur.getEmailTuteur());
        values.put(COL_NUMTELTUTEUR, unTuteur.getNumTelTuteur());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_TUTEUR, null, values);
    }
    public Cursor getDataTuteur(){
        return db.rawQuery("SELECT * FROM Tuteur", null);
    }

    public Cursor updateTuteur(String nom, String prenom, String tuteur, String tel, String mail){
        return db.rawQuery("UPDATE "+ TABLE_TUTEUR
                + " SET " + COL_IDENTITETUTEUR + " =\"" + tuteur + "\", "
                + COL_NUMTELTUTEUR + " =\"" + tel + "\", "
                + COL_EMAILTUTEUR + " =\"" + mail
                + "\" WHERE " + COL_IDTUTEUR
                + " = (SELECT " + COL_IDTUTEUR_STAGE + " FROM STAGE STA"
                        + " INNER JOIN " + TABLE_ETUDIANT + " ETUD ON STA."+COL_IDETUDIANT_STAGE+" = ETUD."+COL_IDETUDIANT
                        + " WHERE " + COL_NOMETUDIANT + " =\"" + nom + "\" AND " + COL_PRENOMETUDIANT + " =\"" + prenom +"\""
                        + "AND " + COL_IDTUTEUR_STAGE + " = Tuteur.\"" + COL_IDTUTEUR +"\")", null);

    }





    public long insererDate (Date unDate){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_DATEDEBUT, unDate.getDateDebut());
        values.put(COL_DATEFIN, unDate.getDateFin());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_DATE, null, values);
    }
    public Cursor getDataDate(){
        return db.rawQuery("SELECT * FROM Date", null);
    }





    public long insererVisite (Visite uneVisite){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_IDSTAGE_VISITE, uneVisite.get_idStageVisite());
        values.put(COL_DATEVISITE, uneVisite.getDateVisite());
        values.put(COL_CONDITIONS, uneVisite.getConditions());
        values.put(COL_BILAN, uneVisite.getBilan());
        values.put(COL_RESSOURCES, uneVisite.getRessources());
        values.put(COL_CONCLUSION, uneVisite.getConclusion());
        values.put(COL_JURY, uneVisite.getJury());
        values.put(COL_OPPORTUNITE, uneVisite.getOpportunite());
        values.put(COL_SIOPPORTUNITE, uneVisite.getSIOpportunite());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_VISITE, null, values);
    }
    public Cursor getDataVisite(){
        return db.rawQuery("SELECT * FROM Visite", null);
    }

    public Cursor getIDStageVisite(int _idStageVisite){
        return db.rawQuery("SELECT "+ COL_IDSTAGE_VISITE +" FROM " + TABLE_VISITE
                + " WHERE " + COL_IDSTAGE_VISITE + " =\"" + _idStageVisite +"\"", null);
    }

    public Cursor updateVisite(int _idStageVisite, String dateVisite, String conditionsStages, String bilanTravaux, String ressourcesOutils, String conclusion,
                               String selectedRadioJury, String selectedRadioOpportunite, String selectedRadioSiOpportunite){
        return db.rawQuery("UPDATE "+ TABLE_VISITE
                + " SET " + COL_IDSTAGE_VISITE + " =\"" + _idStageVisite + "\", "
                + COL_DATEVISITE + " =\"" + dateVisite + "\", "
                + COL_CONDITIONS + " =\"" + conditionsStages + "\", "
                + COL_BILAN + " =\"" + bilanTravaux + "\", "
                + COL_RESSOURCES + " =\"" + ressourcesOutils + "\", "
                + COL_CONCLUSION + " =\"" + conclusion + "\", "
                + COL_JURY + " =\"" + selectedRadioJury + "\", "
                + COL_OPPORTUNITE + " =\"" + selectedRadioOpportunite + "\", "
                + COL_SIOPPORTUNITE + " =\"" + selectedRadioSiOpportunite
                + "\" WHERE " + COL_IDSTAGE_VISITE + " =\"" + _idStageVisite +"\"", null);
    }
    public Cursor getInfosVisite(int _idStageVisite){
        return db.rawQuery("SELECT * FROM " + TABLE_VISITE
                + " WHERE " + COL_IDSTAGE_VISITE + " =\"" + _idStageVisite +"\"", null);
    }
}
