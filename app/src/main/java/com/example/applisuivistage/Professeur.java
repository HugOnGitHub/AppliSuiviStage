package com.example.applisuivistage;

public class Professeur {
    protected String NomProf;
    protected String PrenomProf;
    protected String EmailProf;
    protected String NumTelProf;

    public Professeur(String nomProf, String prenomProf, String emailProf, String numTelProf) {
        NomProf = nomProf;
        PrenomProf = prenomProf;
        EmailProf = emailProf;
        NumTelProf = numTelProf;
    }

    public String getNomProf() {
        return NomProf;
    }

    public String getPrenomProf() {
        return PrenomProf;
    }

    public String getEmailProf() {
        return EmailProf;
    }

    public String getNumTelProf() {
        return NumTelProf;
    }

    public void setNomProf(String nomProf) {
        NomProf = nomProf;
    }

    public void setPrenomProf(String prenomProf) {
        PrenomProf = prenomProf;
    }

    public void setEmailProf(String emailProf) {
        EmailProf = emailProf;
    }

    public void setNumTelProf(String numTelProf) { NumTelProf = numTelProf; }
}
