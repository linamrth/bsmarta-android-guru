package com.linameritha.myapplication.Model.SemuaSiswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputrapotsemuasiswaModel {
    @SerializedName("idguru")
    @Expose
    private Integer idguru;
    @SerializedName("idgenerate")
    @Expose
    private Integer idgenerate;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("materi")
    @Expose
    private String materi;
    @SerializedName("hasil")
    @Expose
    private String hasil;
    @SerializedName("halamanketercapaian")
    @Expose
    private Integer halamanketercapaian;
    @SerializedName("pertemuanke")
    @Expose
    private Integer pertemuanke;
    @SerializedName("catatanguru")
    @Expose
    private String catatanguru;
    @SerializedName("rewardhasil")
    @Expose
    private Integer rewardhasil;
    @SerializedName("rewardsikap")
    @Expose
    private Integer rewardsikap;
    @SerializedName("idrapotbelajar")
    @Expose
    private Integer idrapotbelajar;

    public Integer getIdguru() {
        return idguru;
    }

    public void setIdguru(Integer idguru) {
        this.idguru = idguru;
    }

    public Integer getIdgenerate() {
        return idgenerate;
    }

    public void setIdgenerate(Integer idgenerate) {
        this.idgenerate = idgenerate;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    public Integer getHalamanketercapaian() {
        return halamanketercapaian;
    }

    public void setHalamanketercapaian(Integer halamanketercapaian) {
        this.halamanketercapaian = halamanketercapaian;
    }

    public Integer getPertemuanke() {
        return pertemuanke;
    }

    public void setPertemuanke(Integer pertemuanke) {
        this.pertemuanke = pertemuanke;
    }

    public String getCatatanguru() {
        return catatanguru;
    }

    public void setCatatanguru(String catatanguru) {
        this.catatanguru = catatanguru;
    }

    public Integer getRewardhasil() {
        return rewardhasil;
    }

    public void setRewardhasil(Integer rewardhasil) {
        this.rewardhasil = rewardhasil;
    }

    public Integer getRewardsikap() {
        return rewardsikap;
    }

    public void setRewardsikap(Integer rewardsikap) {
        this.rewardsikap = rewardsikap;
    }

    public Integer getIdrapotbelajar() {
        return idrapotbelajar;
    }

    public void setIdrapotbelajar(Integer idrapotbelajar) {
        this.idrapotbelajar = idrapotbelajar;
    }
}
