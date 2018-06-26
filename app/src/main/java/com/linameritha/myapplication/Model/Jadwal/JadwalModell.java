package com.linameritha.myapplication.Model.Jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.stream.Stream;

public class JadwalModell {
    @SerializedName("Hari")
    @Expose
    private String hari;
    @SerializedName("Jam")
    @Expose
    private ArrayList<String> jam = null;
    @SerializedName("Jadwal")
    @Expose
    private ArrayList<String> jadwal = null;

    public String getHari() {
        return hari;
    }

    public ArrayList<String> getJam() {
        return jam;
    }

    public ArrayList<String> getJadwal() {
        return jadwal;
    }
}
