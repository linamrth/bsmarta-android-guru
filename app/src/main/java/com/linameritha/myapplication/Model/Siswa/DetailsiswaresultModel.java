package com.linameritha.myapplication.Model.Siswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailsiswaresultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jadwalgenerate")
    @Expose
    private ArrayList<DetailsiswaModel> jadwalgenerate = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DetailsiswaModel> getJadwalgenerate() {
        return jadwalgenerate;
    }

    public void setJadwalgenerate(ArrayList<DetailsiswaModel> jadwalgenerate) {
        this.jadwalgenerate = jadwalgenerate;
    }
}
