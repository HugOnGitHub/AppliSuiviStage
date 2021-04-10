package com.example.applisuivistage;

public class Professeur {
    protected String IdentiteProf;
    protected String EmailProf;
    protected String NumTelProf;

    public Professeur(String identiteProf, String emailProf, String numTelProf) {
        IdentiteProf = identiteProf;
        EmailProf = emailProf;
        NumTelProf = numTelProf;
    }

    public String getIdentiteProf() {
        return IdentiteProf;
    }

    public String getEmailProf() {
        return EmailProf;
    }

    public String getNumTelProf() {
        return NumTelProf;
    }

    public void setIdentiteProf(String identiteProf) {
        IdentiteProf = identiteProf;
    }

    public void setEmailProf(String emailProf) {
        EmailProf = emailProf;
    }

    public void setNumTelProf(String numTelProf) { NumTelProf = numTelProf; }
}
