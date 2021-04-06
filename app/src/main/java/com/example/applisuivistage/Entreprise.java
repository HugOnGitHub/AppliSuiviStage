package com.example.applisuivistage;

public class Entreprise {

    protected String NomSociete;
    protected String Adresse;
    protected String NumTel;

    public Entreprise(String nomSociete, String adresse, String numTel) {
        NomSociete = nomSociete;
        Adresse = adresse;
        NumTel = numTel;
    }

    public String getNomSociete() {
        return NomSociete;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNomSociete(String nomSociete) {
        NomSociete = nomSociete;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

}
