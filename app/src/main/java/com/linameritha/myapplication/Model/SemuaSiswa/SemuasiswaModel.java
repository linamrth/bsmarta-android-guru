package com.linameritha.myapplication.Model.SemuaSiswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SemuasiswaModel {
    @SerializedName("namalengkap")
    @Expose
    private String namalengkap;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("namaprogram")
    @Expose
    private String namaprogram;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("idsiswabelajar")
    @Expose
    private String idsiswabelajar;

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNamaprogram() {
        return namaprogram;
    }

    public void setNamaprogram(String namaprogram) {
        this.namaprogram = namaprogram;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIdsiswabelajar() {
        return idsiswabelajar;
    }

    public void setIdsiswabelajar(String idsiswabelajar) {
        this.idsiswabelajar = idsiswabelajar;
    }
}
