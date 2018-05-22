package com.linameritha.myapplication.Model.Siswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SiswaresultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("siswabelajar")
    @Expose
    private ArrayList<SiswaModel> siswabelajar = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<SiswaModel> getSiswabelajar() {
        return siswabelajar;
    }

    public void setSiswabelajar(ArrayList<SiswaModel> siswabelajar) {
        this.siswabelajar = siswabelajar;
    }

}
