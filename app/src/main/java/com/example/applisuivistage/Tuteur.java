package com.example.applisuivistage;

public class Tuteur {
    protected String Tuteur;
    protected String Email;
    protected String NumTel;

    public Tuteur(String tuteur, String email, String numTel) {
        Tuteur = tuteur;
        Email = email;
        NumTel = numTel;
    }

    public String getTuteur() {
        return Tuteur;
    }

    public String getEmail() {
        return Email;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setTuteur(String tuteur) {
        Tuteur = tuteur;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setNumTel(String numTel) { NumTel = numTel; }
}
