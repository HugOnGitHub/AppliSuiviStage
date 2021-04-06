package com.example.applisuivistage;

public class Professeur {
    protected String Nom;
    protected String Prenom;
    protected String Email;
    protected String NumTel;

    public Professeur(String nom, String prenom, String email, String numTel) {
        Nom = nom;
        Prenom = prenom;
        Email = email;
        NumTel = numTel;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getEmail() {
        return Email;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setNumTel(String numTel) { NumTel = numTel; }
}
