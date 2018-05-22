package com.linameritha.myapplication.Model.SemuaSiswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SemuasiswaresultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("siswabelajar")
    @Expose
    private ArrayList<SemuasiswaModel> siswabelajar = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<SemuasiswaModel> getSiswabelajar() {
        return siswabelajar;
    }

    public void setSiswabelajar(ArrayList<SemuasiswaModel> siswabelajar) {
        this.siswabelajar = siswabelajar;
    }
}
