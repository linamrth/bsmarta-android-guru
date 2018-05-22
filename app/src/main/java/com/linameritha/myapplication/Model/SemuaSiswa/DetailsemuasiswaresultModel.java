package com.linameritha.myapplication.Model.SemuaSiswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailsemuasiswaresultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jadwalgenerate")
    @Expose
    private ArrayList<DetailsemuasiswaModel> jadwalgenerate = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DetailsemuasiswaModel> getJadwalgenerate() {
        return jadwalgenerate;
    }

    public void setJadwalgenerate(ArrayList<DetailsemuasiswaModel> jadwalgenerate) {
        this.jadwalgenerate = jadwalgenerate;
    }
}
