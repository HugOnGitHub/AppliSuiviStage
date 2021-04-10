package com.example.applisuivistage;

public class Tuteur {
    protected String IdentiteTuteur;
    protected String EmailTuteur;
    protected String NumTelTuteur;

    public Tuteur(String identiteTuteur, String emailTuteur, String numTelTuteur) {
        IdentiteTuteur = identiteTuteur;
        EmailTuteur = emailTuteur;
        NumTelTuteur = numTelTuteur;
    }

    public String getIdentiteTuteur() {
        return IdentiteTuteur;
    }

    public String getEmailTuteur() {
        return EmailTuteur;
    }

    public String getNumTelTuteur() { return NumTelTuteur; }

    public void setIdentiteTuteur(String identiteTuteur) {
        IdentiteTuteur = identiteTuteur;
    }

    public void setEmailTuteur(String emailTuteur) {
        EmailTuteur = emailTuteur;
    }

    public void setNumTelTuteur(String numTelTuteur) { NumTelTuteur = numTelTuteur; }
}
