package com.linameritha.myapplication.Model.SemuaSiswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaterihalamansemuasiswaModel {
    @SerializedName("idlessonplan")
    @Expose
    private Integer idlessonplan;
    @SerializedName("idprogramlevel")
    @Expose
    private Integer idprogramlevel;
    @SerializedName("pertemuan")
    @Expose
    private Integer pertemuan;
    @SerializedName("hal")
    @Expose
    private Integer hal;
    @SerializedName("materi")
    @Expose
    private String materi;

    public Integer getIdlessonplan() {
        return idlessonplan;
    }

    public void setIdlessonplan(Integer idlessonplan) {
        this.idlessonplan = idlessonplan;
    }

    public Integer getIdprogramlevel() {
        return idprogramlevel;
    }

    public void setIdprogramlevel(Integer idprogramlevel) {
        this.idprogramlevel = idprogramlevel;
    }

    public Integer getPertemuan() {
        return pertemuan;
    }

    public void setPertemuan(Integer pertemuan) {
        this.pertemuan = pertemuan;
    }

    public Integer getHal() {
        return hal;
    }

    public void setHal(Integer hal) {
        this.hal = hal;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }
}
