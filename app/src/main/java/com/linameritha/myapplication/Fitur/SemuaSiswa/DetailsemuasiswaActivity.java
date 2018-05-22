package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.linameritha.myapplication.Fitur.SemuaSiswa.DetailsemuasiswaAdapter;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class DetailsemuasiswaActivity extends AppCompatActivity {

    private ArrayList<SemuasiswaModel> dataDetailsemuasiswa = new ArrayList<>();
    private RecyclerView rv;
    private DetailsemuasiswaAdapter detailsemuasiswaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsemuasiswa);
        setTitle("Jadwal Pertemuan");

        rv = (RecyclerView) findViewById(R.id.rv);

        createDetailSemuasiswa();

        detailsemuasiswaAdapter = new DetailsemuasiswaAdapter(this, dataDetailsemuasiswa);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(detailsemuasiswaAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createDetailSemuasiswa(){
        for (int i=0; i<10; i++){
//            SemuasiswaModel detailsemuasiswa = new SemuasiswaModel("Rabu, 25 April 2018", "Shifwatin", "Sudah Terisi");
//            dataDetailsemuasiswa.add(detailsemuasiswa);
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
