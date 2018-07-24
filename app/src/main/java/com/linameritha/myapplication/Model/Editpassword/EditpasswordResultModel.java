package com.linameritha.myapplication.Model.Editpassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditpasswordResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("user")
    @Expose
    private EditpasswordModel user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EditpasswordModel getUser() {
        return user;
    }

    public void setUser(EditpasswordModel user) {
        this.user = user;
    }
}
