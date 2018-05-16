package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.linameritha.myapplication.R;

public class ViewrapotAdapter extends BaseAdapter {
    Context context;
    String titles[];
    String deskripsi[];
    LayoutInflater inflater;

    public ViewrapotAdapter(Context applicationContext,String[] titles, String[] deskripsi){
        this.context = context;
        this.titles = titles;
        this.deskripsi = deskripsi;
        inflater = (LayoutInflater.from(applicationContext));
    }

    public int getCount(){
        return titles.length;
    }

    public Object getItem(int i){
        return null;
    }

    public long getItemId(int i){
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup){
        view = inflater.inflate(R.layout.activity_viewrapotisi, null);
        TextView judul = (TextView) view.findViewById(R.id.text1);
        TextView isi = (TextView) view.findViewById(R.id.text2);
        judul.setText(titles[i]);
        isi.setText(deskripsi[i]);
        return view;
    }
}
