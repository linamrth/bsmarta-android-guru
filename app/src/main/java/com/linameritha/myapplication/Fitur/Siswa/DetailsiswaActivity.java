package com.linameritha.myapplication.Fitur.Siswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.linameritha.myapplication.Model.Siswa.SiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class DetailsiswaActivity extends AppCompatActivity {

    private ArrayList<SiswaModel> dataDetailsiswa = new ArrayList<>();
    private RecyclerView rv;
    private DetailsiswaAdapter detailsiswaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsiswa);
        setTitle("Jadwal Pertemuan");

        rv = (RecyclerView) findViewById(R.id.rv);

        createDetailSiswa();

        detailsiswaAdapter = new DetailsiswaAdapter(this, dataDetailsiswa);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(detailsiswaAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createDetailSiswa(){
        for (int i=0; i<10; i++){
            SiswaModel detailsiswa = new SiswaModel("Jumat, 27 April 2018", "Rosmelia Capriana", "Belum Terisi");
            dataDetailsiswa.add(detailsiswa);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
