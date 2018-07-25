package com.linameritha.myapplication.Model.Siswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GrafikPerkembanganModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pertemuan")
    @Expose
    private List<Integer> pertemuan;
    @SerializedName("target")
    @Expose
    private List<Integer> target;
    @SerializedName("hasiltarget")
    @Expose
    private List<String> hasiltarget;
    @SerializedName("materi")
    @Expose
    private List<String> materi;

    public  List<String> getMateri(){ return materi; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Integer> getPertemuan() {
        return (ArrayList<Integer>) pertemuan;
    }

    public void setPertemuan(ArrayList<Integer> pertemuan) {
        this.pertemuan = pertemuan;
    }

    public ArrayList<Integer> getTarget() {
        return (ArrayList<Integer>) target;
    }

    public void setTarget(ArrayList<Integer> target) {
        this.target = target;
    }

    public ArrayList<String> getHasiltarget() {
        return (ArrayList<String>) hasiltarget;
    }

    public void setHasiltarget(ArrayList<String> hasiltarget) {
        this.hasiltarget = hasiltarget;
    }
}
