package com.linameritha.myapplication.Fitur.Siswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Model.Siswa.DetailsiswaresultModel;
import com.linameritha.myapplication.Model.Siswa.SiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsiswaActivity extends AppCompatActivity {
    private ArrayList<DetailsiswaresultModel> dataDetailsiswa;
    private RecyclerView rv;
    private DetailsiswaAdapter detailsiswaAdapter;
    private TextView tvHari, tvTanggal, tvNamaguru, tvStatus;
    Integer idsiswabelajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsiswa);
        setTitle("Daftar Rapot");

        Intent intent = getIntent();
        idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("terserah", String.valueOf(idsiswabelajar));

        tvHari = (TextView) findViewById(R.id.tvhari);
        tvTanggal = (TextView) findViewById(R.id.tvtanggal);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvStatus = (TextView) findViewById(R.id.tvstatusrapot);

        rv = (RecyclerView) findViewById(R.id.rv);

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

    @Override
    protected void onResume() {
        super.onResume();
        ApiServices.services_get.getDetailsiswa(idsiswabelajar).enqueue(new Callback<DetailsiswaresultModel>() {
            @Override
            public void onResponse(Call<DetailsiswaresultModel> call, Response<DetailsiswaresultModel> response) {
                DetailsiswaresultModel resultModel = response.body();

                detailsiswaAdapter = new DetailsiswaAdapter(DetailsiswaActivity.this, resultModel.getJadwalgenerate());
                rv.setLayoutManager(new LinearLayoutManager(DetailsiswaActivity.this));
                rv.setAdapter(detailsiswaAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DetailsiswaresultModel> call, Throwable t) {

            }
        });
    }
}
