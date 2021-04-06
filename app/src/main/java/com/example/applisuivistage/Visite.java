package com.example.applisuivistage;

public class Visite {
    protected String DateVisite;
    protected String Conditions;
    protected String Bilan;
    protected String Ressources;
    protected String Conclusion;
    protected String Jury;
    protected String Opportunite;
    protected String SIOpportunite;
    protected int _idTuteur;
    protected int _idProfesseur;
    protected int _idEtudiant;
    protected int _idEntreprise;

    public Visite(int _idtuteur, int _idprofesseur, int _idetudiant, int _identreprise, String dateVisite, String conditions, String bilan, String ressources, String conclusion, String jury, String opportunite, String siopportunite) {
        _idTuteur = _idtuteur;
        _idProfesseur = _idprofesseur;
        _idEtudiant = _idetudiant;
        _idEntreprise = _identreprise;
        DateVisite = dateVisite;
        Conditions = conditions;
        Bilan = bilan;
        Ressources = ressources;
        Conclusion = conclusion;
        Jury = jury;
        Opportunite = opportunite;
        SIOpportunite = siopportunite;
    }

    public String getDateVisite() {
        return DateVisite;
    }

    public String getConditions() {
        return Conditions;
    }

    public String getBilan() {
        return Bilan;
    }

    public String getRessources() {
        return Ressources;
    }

    public String getConclusion() {
        return Conclusion;
    }

    public String getJury() {
        return Jury;
    }

    public String getOpportunite() {
        return Opportunite;
    }

    public String getSIOpportunite() {
        return SIOpportunite;
    }

    public int get_idTuteur() {
        return _idTuteur;
    }

    public int get_idProfesseur() {
        return _idProfesseur;
    }

    public int get_idEtudiant() {
        return _idEtudiant;
    }

    public int get_idEntreprise() {
        return _idEntreprise;
    }


    public void setDateVisite(String dateVisite) {
        DateVisite = dateVisite;
    }

    public void setConditions(String conditions) {
        Conditions = conditions;
    }

    public void setBilan(String bilan) {
        Bilan = bilan;
    }

    public void setRessources(String ressources) { Ressources = ressources; }

    public void setConclusion(String conclusion) {
        Conclusion = conclusion;
    }

    public void setJury(String jury) {
        Jury = jury;
    }

    public void setOpportunite(String opportunite) {
        Opportunite = opportunite;
    }

    public void setSIOpportunite(String siopportunite) { SIOpportunite = siopportunite; }

    public void set_idTuteur(int _idtuteur) { _idTuteur = _idtuteur; }

    public void set_idProfesseur(int _idprofesseur) { _idProfesseur = _idprofesseur; }

    public void set_idEtudiant(int _idetudiant) { _idEtudiant = _idetudiant; }

    public void set_idEntreprise(int _identreprise) { _idEntreprise = _identreprise; }
}
