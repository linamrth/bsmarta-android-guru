package com.linameritha.myapplication.Fitur.LoginForm;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context){
        this.context = context;
        prefs = context.getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLogin(boolean login, Integer idguru){
        editor.putBoolean("login", login);
        editor.putInt("idguru", idguru);
        editor.commit();
    }

    public boolean login(){
        return prefs.getBoolean("login", false);
    }
}
