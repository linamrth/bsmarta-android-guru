package com.linameritha.myapplication.Model.SemuaSiswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailsemuasiswaModel {
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
    private Integer idgenerate;

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

    public Integer getIdgenerate() {
        return idgenerate;
    }

    public void setIdgenerate(Integer idgenerate) {
        this.idgenerate = idgenerate;
    }

}
