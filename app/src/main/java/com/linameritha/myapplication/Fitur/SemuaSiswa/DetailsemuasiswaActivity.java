package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.SemuaSiswa.DetailsemuasiswaAdapter;
import com.linameritha.myapplication.Fitur.Siswa.DetailsiswaActivity;
import com.linameritha.myapplication.Fitur.Siswa.DetailsiswaAdapter;
import com.linameritha.myapplication.Fitur.Siswa.GrafikPerkembanganSiswa;
import com.linameritha.myapplication.Model.SemuaSiswa.DetailsemuasiswaresultModel;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaModel;
import com.linameritha.myapplication.Model.Siswa.DetailsiswaresultModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsemuasiswaActivity extends AppCompatActivity {
    private ArrayList<DetailsemuasiswaresultModel> dataDetailsemuasiswa;
    private Toolbar toolbar;
    private RecyclerView rv;
    private DetailsemuasiswaAdapter detailsemuasiswaAdapter;
    private TextView tvHari, tvTanggal, tvNamaguru, tvStatus;
    private ImageView logo;
    Integer idsiswabelajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsemuasiswa);
        setTitle("Daftar Rapot");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("terserah", String.valueOf(idsiswabelajar));

        tvHari = (TextView) findViewById(R.id.tvhari);
        tvTanggal = (TextView) findViewById(R.id.tvtanggal);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvStatus = (TextView) findViewById(R.id.tvstatus);
        logo = (ImageView) findViewById(R.id.logostatus);

        rv = (RecyclerView) findViewById(R.id.rv);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.grafik:
                Intent intent = new Intent(this, GrafikPerkembanganSiswa.class);
                intent.putExtra("idsiswabelajar", idsiswabelajar);
                startActivity(intent);
                return true;
        }

        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Apakah anda yakin ingin keluar ?")
//                .setCancelable(false)
//                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        finish();
//                    }
//                })
//                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alert = builder.create();
//        alert.show();
//    }

    protected void onResume() {
        super.onResume();

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
    }
}
