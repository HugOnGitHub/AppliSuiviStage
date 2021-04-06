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

    public Visite(String dateVisite, String conditions, String bilan, String ressources, String conclusion, String jury, String opportunite, String siopportunite) {
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
}
