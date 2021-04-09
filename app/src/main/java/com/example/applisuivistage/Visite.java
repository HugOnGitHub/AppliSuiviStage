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
    protected int _idTuteurV;
    protected int _idProfesseurV;
    protected int _idEtudiantV;
    protected int _idEntrepriseV;

    public Visite(int _idtuteurV, int _idprofesseurV, int _idetudiantV, int _identrepriseV, String dateVisite, String conditions, String bilan, String ressources, String conclusion, String jury, String opportunite, String siopportunite) {
        _idTuteurV = _idtuteurV;
        _idProfesseurV = _idprofesseurV;
        _idEtudiantV = _idetudiantV;
        _idEntrepriseV = _identrepriseV;
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

    public int get_idTuteurV() {
        return _idTuteurV;
    }

    public int get_idProfesseurV() {
        return _idProfesseurV;
    }

    public int get_idEtudiantV() {
        return _idEtudiantV;
    }

    public int get_idEntrepriseV() {
        return _idEntrepriseV;
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

    public void set_idTuteurV(int _idtuteurV) { _idTuteurV = _idtuteurV; }

    public void set_idProfesseurV(int _idprofesseurV) { _idProfesseurV = _idprofesseurV; }

    public void set_idEtudiantV(int _idetudiantV) { _idEtudiantV = _idetudiantV; }

    public void set_idEntrepriseV(int _identrepriseV) { _idEntrepriseV = _identrepriseV; }
}
