package com.linameritha.myapplication.Model.Siswa;

public class SiswaModel {
    private String nama;
    private String programlevel;
    private String tanggal;
    private String namaguru;
    private String statusrapot;

    public SiswaModel(String nama, String programlevel) {
        this.nama = nama;
        this.programlevel = programlevel;
    }

    public SiswaModel(String tanggal, String namaguru, String statusrapot){
        this.tanggal = tanggal;
        this.namaguru = namaguru;
        this.statusrapot = statusrapot;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProgramlevel() {
        return programlevel;
    }

    public void setProgramlevel(String programlevel) {
        this.programlevel = programlevel;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    public String getStatusrapot() {
        return statusrapot;
    }

    public void setStatusrapot(String statusrapot) {
        this.statusrapot = statusrapot;
    }
}
