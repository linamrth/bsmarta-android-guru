package com.linameritha.myapplication.Model.Siswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LihatrapotModel {
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
    @SerializedName("namaguru")
    @Expose
    private String namaguru;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("pertemuanke")
    @Expose
    private String pertemuanke;
    @SerializedName("materi")
    @Expose
    private String materi;
    @SerializedName("halamanketercapaian")
    @Expose
    private String halamanketercapaian;
    @SerializedName("hasil")
    @Expose
    private String hasil;
    @SerializedName("catatanguru")
    @Expose
    private String catatanguru;
    @SerializedName("rewardhasil")
    @Expose
    private Float rewardhasil;
    @SerializedName("rewardsikap")
    @Expose
    private Float rewardsikap;

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

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPertemuanke() {
        return pertemuanke;
    }

    public void setPertemuanke(String pertemuanke) {
        this.pertemuanke = pertemuanke;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public String getHalamanketercapaian() {
        return halamanketercapaian;
    }

    public void setHalamanketercapaian(String halamanketercapaian) {
        this.halamanketercapaian = halamanketercapaian;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public String getCatatanguru() {
        return catatanguru;
    }

    public void setCatatanguru(String catatanguru) {
        this.catatanguru = catatanguru;
    }

    public Float getRewardhasil() {
        return rewardhasil;
    }

    public void setRewardhasil(Float rewardhasil) {
        this.rewardhasil = rewardhasil;
    }

    public Float getRewardsikap() {
        return rewardsikap;
    }

    public void setRewardsikap(Float rewardsikap) {
        this.rewardsikap = rewardsikap;
    }
}
