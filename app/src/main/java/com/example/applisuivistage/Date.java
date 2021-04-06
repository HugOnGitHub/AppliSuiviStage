package com.example.applisuivistage;

public class Date {
    protected String DateDebut;
    protected String DateFin;

    public Date(String datedebut, String datefin) {
        DateDebut = datedebut;
        DateFin = datefin;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public void setDateDebut(String datedebut) {
        DateDebut = datedebut;
    }

    public void setDateFin(String datefin) {
        DateFin = datefin;
    }

}
