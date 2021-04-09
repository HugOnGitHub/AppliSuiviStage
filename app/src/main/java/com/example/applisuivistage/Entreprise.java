package com.example.applisuivistage;

public class Entreprise {

    protected String NomSociete;
    protected String Adresse;
    protected String NumTelSociete;

    public Entreprise(String nomSociete, String adresse, String numTelSociete) {
        NomSociete = nomSociete;
        Adresse = adresse;
        NumTelSociete = numTelSociete;
    }

    public String getNomSociete() {
        return NomSociete;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getNumTelSociete() {
        return NumTelSociete;
    }

    public void setNomSociete(String nomSociete) {
        NomSociete = nomSociete;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public void setNumTelSociete(String numTelSociete) { NumTelSociete = numTelSociete; }

}
