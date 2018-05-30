package com.linameritha.myapplication.Model.SemuaSiswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.linameritha.myapplication.Model.Siswa.IsirapotModel;

public class InputrapotresultsemuasiswaModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private InputrapotsemuasiswaModel result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InputrapotsemuasiswaModel getResult() {
        return result;
    }

    public void setResult(InputrapotsemuasiswaModel result) {
        this.result = result;
    }
}
