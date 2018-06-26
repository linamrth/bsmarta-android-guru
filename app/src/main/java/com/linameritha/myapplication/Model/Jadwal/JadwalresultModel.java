package com.linameritha.myapplication.Model.Jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JadwalresultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private JadwalModell results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JadwalModell getResults() {
        return results;
    }

    public void setResults(JadwalModell results) {
        this.results = results;
    }

}
