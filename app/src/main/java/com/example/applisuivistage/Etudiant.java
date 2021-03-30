package com.example.applisuivistage;

public class Etudiant {

    protected String Nom;
    protected String Prenom;
    protected String Classe;
    protected String Annee;

    public Etudiant(String nom, String prenom, String classe, String annee) {
        Nom = nom;
        Prenom = prenom;
        Classe = classe;
        Annee = annee;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getClasse() {
        return Classe;
    }

    public String getAnnee() {
        return Annee;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public void setAnnee(String annee) {
        Annee = annee;
    }

}
