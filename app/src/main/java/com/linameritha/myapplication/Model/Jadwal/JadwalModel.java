package com.linameritha.myapplication.Model.Jadwal;

public class JadwalModel {
    private String jam;
    private String namasiswa;
    private String programlevel;
    private String statuskursus;

    public JadwalModel(String jam, String namasiswa, String programlevel, String statuskursus) {
        this.jam = jam;
        this.namasiswa = namasiswa;
        this.programlevel = programlevel;
        this.statuskursus = statuskursus;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getNamasiswa() {
        return namasiswa;
    }

    public void setNamasiswa(String namasiswa) {
        this.namasiswa = namasiswa;
    }

    public String getProgramlevel() {
        return programlevel;
    }

    public void setProgramlevel(String programlevel) {
        this.programlevel = programlevel;
    }

    public String getStatuskursus() {
        return statuskursus;
    }

    public void setStatuskursus(String statuskursus) {
        this.statuskursus = statuskursus;
    }
}
