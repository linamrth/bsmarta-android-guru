package com.linameritha.myapplication.Model.Profil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.linameritha.myapplication.Api.ApiServices;

import java.util.ArrayList;

public class ModelProfile {
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("namaguru")
    @Expose
    private String namaguru;
    @SerializedName("telepon")
    @Expose
    private String telepon;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("namacabang")
    @Expose
    private String namacabang;
    @SerializedName("program")
    @Expose
    private ArrayList<ModelSkillProfile> program = null;

    public String getFoto() {
        return ApiServices.BASE_URL_FOTO+foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamacabang() {
        return namacabang;
    }

    public void setNamacabang(String namacabang) {
        this.namacabang = namacabang;
    }

    public ArrayList<ModelSkillProfile> getProgram() {
        return program;
    }

    public void setProgram(ArrayList<ModelSkillProfile> program) {
        this.program = program;
    }
}
