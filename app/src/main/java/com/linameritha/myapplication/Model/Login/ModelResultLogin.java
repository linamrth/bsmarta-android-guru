package com.linameritha.myapplication.Model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelResultLogin {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private ModelLogin result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelLogin getResult() {
        return result;
    }

    public void setResult(ModelLogin result) {
        this.result = result;
    }
}