package com.linameritha.myapplication.Model.Siswa;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsirapotresultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private IsirapotModel result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IsirapotModel getResult() {
        return result;
    }

    public void setResult(IsirapotModel result) {
        this.result = result;
    }
}
