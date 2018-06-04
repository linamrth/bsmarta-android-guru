package com.linameritha.myapplication.Model.Profil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelResultProfile {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private ModelProfile results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelProfile getResults() {
        return results;
    }

    public void setResults(ModelProfile results) {
        this.results = results;
    }
}
