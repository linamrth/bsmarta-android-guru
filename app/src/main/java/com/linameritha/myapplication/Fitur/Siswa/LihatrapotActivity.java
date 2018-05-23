package com.linameritha.myapplication.Fitur.Siswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Model.Siswa.LihatrapotModel;
import com.linameritha.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatrapotActivity extends AppCompatActivity {
    private LihatrapotModel lihatrapotModel;
    private TextView tvNama, tvKelas, tvProgram, tvLevel;
    private TextView tvNamaguru, tvTanggal, tvPertemuanke;
    private TextView tvMateri, tvHalamanketercapaian, tvHasil, tvCatatanguru, tvRewardhasil, tvRewardsikap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatrapot);
        setTitle("Rapot Kursus");

        Intent intent = getIntent();
        String idgenerate = intent.getStringExtra("idgenerate");
        Log.d("terserah", String.valueOf(idgenerate));

        tvNama = (TextView) findViewById(R.id.tvnama);
        tvKelas = (TextView) findViewById(R.id.tvkelas);
        tvProgram = (TextView) findViewById(R.id.tvprogram);
        tvLevel = (TextView) findViewById(R.id.tvlevel);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvTanggal = (TextView) findViewById(R.id.tvtanggal);
        tvPertemuanke = (TextView) findViewById(R.id.tvpertemuanke);
        tvMateri = (TextView) findViewById(R.id.tvmateri);
        tvHalamanketercapaian = (TextView) findViewById(R.id.tvhalamanketercapaian);
        tvHasil = (TextView) findViewById(R.id.tvhasil);
        tvCatatanguru = (TextView) findViewById(R.id.tvcatatanguru);
        tvRewardhasil = (TextView) findViewById(R.id.tvrewardhasil);
        tvRewardsikap = (TextView) findViewById(R.id.tvrewardsikap);

        ApiServices.services_get.getLihatrapotsiswa(idgenerate).enqueue(new Callback<LihatrapotModel>() {
            @Override
            public void onResponse(Call<LihatrapotModel> call, Response<LihatrapotModel> response) {
                lihatrapotModel = response.body();

                tvNama.setText(lihatrapotModel.getNamalengkap());
                tvKelas.setText(lihatrapotModel.getKelas());
                tvProgram.setText(lihatrapotModel.getNamaprogram());
                tvLevel.setText("Level " + lihatrapotModel.getLevel());
                tvNamaguru.setText(lihatrapotModel.getNamaguru());
                tvTanggal.setText(lihatrapotModel.getTanggal());
                tvPertemuanke.setText(lihatrapotModel.getPertemuanke());
                tvMateri.setText(lihatrapotModel.getMateri());
                tvHalamanketercapaian.setText("Halaman " + lihatrapotModel.getHalamanketercapaian());
                tvHasil.setText(lihatrapotModel.getHasil());
                tvCatatanguru.setText(lihatrapotModel.getCatatanguru());
                tvRewardhasil.setText("Bintang " + lihatrapotModel.getRewardhasil());
                tvRewardsikap.setText("Bintang " + lihatrapotModel.getRewardsikap());
            }

            @Override
            public void onFailure(Call<LihatrapotModel> call, Throwable t) {

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
