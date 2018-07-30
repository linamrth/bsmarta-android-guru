package com.linameritha.myapplication.Model.Siswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.linameritha.myapplication.Api.ApiServices;

public class SiswaModel {
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("namalengkap")
    @Expose
    private String namalengkap;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("namaprogram")
    @Expose
    private String namaprogram;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("idsiswabelajar")
    @Expose
    private Integer idsiswabelajar;

    public String getFoto() {
        return ApiServices.BASE_URL_FOTO+foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

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

    public Integer getIdsiswabelajar() {
        return idsiswabelajar;
    }

    public void setIdsiswabelajar(Integer idsiswabelajar) {
        this.idsiswabelajar = idsiswabelajar;
    }
}
