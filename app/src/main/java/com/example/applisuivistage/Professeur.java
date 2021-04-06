package com.example.applisuivistage;

public class Professeur {
    protected String Professeur;
    protected String Email;
    protected String NumTel;

    public Professeur(String professeur, String email, String numTel) {
        Professeur = professeur;
        Email = email;
        NumTel = numTel;
    }

    public String getProfesseur() {
        return Professeur;
    }

    public String getEmail() {
        return Email;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setProfesseur(String professeur) { Professeur = professeur; }

    public void setEmail(String email) {
        Email = email;
    }

    public void setNumTel(String numTel) { NumTel = numTel; }
}
