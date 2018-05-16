package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.linameritha.myapplication.R;

public class ViewrapotActivity extends AppCompatActivity {

    ListView list;
    String titles[] = {"Pertemuan Ke", "Tanggal", "Nama guru", "Materi Pembelajaran", "Hasil Belajar", "Halaman Ketercapaian", "Catatan Guru", "Reward Hasil", "Reward Sikap"};
    String deskripsi[] = {"1", "Jumat, 27 April 2018", "Shifwatin", "Membaca huruf vokal aiueo", "Baik sekali", "6", "Tingkatkan terus belajarnya", "1", "2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrapot);
        setTitle("Hasil Belajar");

        list = (ListView) findViewById(R.id.lv);
        ViewrapotAdapter viewrapotAdapter = new ViewrapotAdapter(getApplicationContext(), titles, deskripsi);
        list.setAdapter(viewrapotAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}