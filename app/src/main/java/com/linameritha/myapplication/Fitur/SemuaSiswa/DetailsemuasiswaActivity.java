package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.SemuaSiswa.DetailsemuasiswaAdapter;
import com.linameritha.myapplication.Fitur.Siswa.DetailsiswaActivity;
import com.linameritha.myapplication.Fitur.Siswa.DetailsiswaAdapter;
import com.linameritha.myapplication.Model.SemuaSiswa.DetailsemuasiswaresultModel;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaModel;
import com.linameritha.myapplication.Model.Siswa.DetailsiswaresultModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsemuasiswaActivity extends AppCompatActivity {
    private ArrayList<DetailsemuasiswaresultModel> dataDetailsemuasiswa = new ArrayList<>();
    private RecyclerView rv;
    private DetailsemuasiswaAdapter detailsemuasiswaAdapter;
    private TextView tvHari, tvTanggal, tvNamaguru, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsemuasiswa);
        setTitle("Daftar Rapot");

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("terserah", String.valueOf(idsiswabelajar));

        tvHari = (TextView) findViewById(R.id.tvhari);
        tvTanggal = (TextView) findViewById(R.id.tvtanggal);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvStatus = (TextView) findViewById(R.id.tvstatusrapot);

        rv = (RecyclerView) findViewById(R.id.rv);

        ApiServices.services_get.getDetailsemuasiswa(idsiswabelajar).enqueue(new Callback<DetailsemuasiswaresultModel>() {
            @Override
            public void onResponse(Call<DetailsemuasiswaresultModel> call, Response<DetailsemuasiswaresultModel> response) {
                DetailsemuasiswaresultModel resultModel = response.body();

                detailsemuasiswaAdapter = new DetailsemuasiswaAdapter(DetailsemuasiswaActivity.this, resultModel.getJadwalgenerate());
                rv.setLayoutManager(new LinearLayoutManager(DetailsemuasiswaActivity.this));
                rv.setAdapter(detailsemuasiswaAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DetailsemuasiswaresultModel> call, Throwable t) {

            }
        });

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
