package com.example.applisuivistage;

public class Professeur {
    protected String Nom;
    protected String Prenom;
    protected String Email;
    protected String NumTelProf;

    public Professeur(String nom, String prenom, String email, String numTelProf) {
        Nom = nom;
        Prenom = prenom;
        Email = email;
        NumTelProf = numTelProf;
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

    public String getNumTelProf() {
        return NumTelProf;
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

    public void setNumTelProf(String numTelProf) { NumTelProf = numTelProf; }
}
