package com.linameritha.myapplication.Model.Profil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelSkillProfile {
    @SerializedName("namaprogram")
    @Expose
    private String namaprogram;
    @SerializedName("level")
    @Expose
    private String level;

    public String getNamaprogram() {
        return namaprogram;
    }

    public void setNamaprogram(String namaprogram) {
        this.namaprogram = namaprogram;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
