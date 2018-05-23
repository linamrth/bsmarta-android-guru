package com.linameritha.myapplication.Model.Siswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsiswaModel {
    @SerializedName("hari")
    @Expose
    private String hari;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("statusrapotkursus")
    @Expose
    private String statusrapotkursus;
    @SerializedName("namaguru")
    @Expose
    private String namaguru;
    @SerializedName("idgenerate")
    @Expose
    private String idgenerate;

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatusrapotkursus() {
        return statusrapotkursus;
    }

    public void setStatusrapotkursus(String statusrapotkursus) {
        this.statusrapotkursus = statusrapotkursus;
    }

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    public String getIdgenerate() {
        return idgenerate;
    }

    public void setIdgenerate(String idgenerate) {
        this.idgenerate = idgenerate;
    }
}
