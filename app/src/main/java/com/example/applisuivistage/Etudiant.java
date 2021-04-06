package com.example.applisuivistage;

public class Etudiant {

    protected String NomEtudiant;
    protected String PrenomEtudiant;
    protected String Classe;
    protected String Annee;

    public Etudiant(String nomEtudiant, String prenomEtudiant, String classe, String annee) {
        NomEtudiant = nomEtudiant;
        PrenomEtudiant = prenomEtudiant;
        Classe = classe;
        Annee = annee;
    }

    public String getNomEtudiant() {
        return NomEtudiant;
    }

    public String getPrenomEtudiant() {
        return PrenomEtudiant;
    }

    public String getClasse() {
        return Classe;
    }

    public String getAnnee() {
        return Annee;
    }

    public void setNomEtudiant(String nomEtudiant) {
        NomEtudiant = nomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        PrenomEtudiant = prenomEtudiant;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public void setAnnee(String annee) {
        Annee = annee;
    }

    public String toString() {
        return (NomEtudiant + '\t'+'\t'+'\t' + PrenomEtudiant );
    }

}

