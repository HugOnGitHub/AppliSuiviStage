package com.example.applisuivistage;

public class Tuteur {
    protected String NomTuteur;
    protected String PrenomTuteur;
    protected String EmailTuteur;
    protected String NumTelTuteur;

    public Tuteur(String nomTuteur, String prenomTuteur, String emailTuteur, String numTelTuteur) {
        NomTuteur = nomTuteur;
        PrenomTuteur = prenomTuteur;
        EmailTuteur = emailTuteur;
        NumTelTuteur = numTelTuteur;
    }

    public String getNomTuteur() {
        return NomTuteur;
    }

    public String getPrenomTuteur() { return PrenomTuteur; }

    public String getEmailTuteur() {
        return EmailTuteur;
    }

    public String getNumTelTuteur() { return NumTelTuteur; }

    public void setNomTuteur(String nomTuteur) {
        NomTuteur = nomTuteur;
    }

    public void setPrenomTuteur(String prenomTuteur) {
        PrenomTuteur = prenomTuteur;
    }

    public void setEmailTuteur(String emailTuteur) {
        EmailTuteur = emailTuteur;
    }

    public void setNumTelTuteur(String numTelTuteur) { NumTelTuteur = numTelTuteur; }
}
