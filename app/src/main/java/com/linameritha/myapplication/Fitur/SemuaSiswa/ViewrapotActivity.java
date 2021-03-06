package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Model.SemuaSiswa.ViewrapotModel;
import com.linameritha.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewrapotActivity extends AppCompatActivity {
    private ViewrapotModel viewrapotModel;
    private TextView tvNama, tvKelas, tvProgram, tvLevel;
    private TextView tvNamaguru, tvTanggal, tvPertemuanke;
    private TextView tvMateri, tvHalamanketercapaian, tvHasil, tvCatatanguru;
    private RatingBar tvRewardhasil, tvRewardsikap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrapot);
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
        tvRewardhasil = (RatingBar) findViewById(R.id.tvrewardhasil);
        tvRewardsikap = (RatingBar) findViewById(R.id.tvrewardsikap);

        ApiServices.services_get.getViewrapotsemuasiswa(idgenerate).enqueue(new Callback<ViewrapotModel>() {
            @Override
            public void onResponse(Call<ViewrapotModel> call, Response<ViewrapotModel> response) {
                viewrapotModel = response.body();

                tvNama.setText(viewrapotModel.getNamalengkap());
                tvKelas.setText(viewrapotModel.getKelas());
                tvProgram.setText(viewrapotModel.getNamaprogram());
                tvLevel.setText("Level " + viewrapotModel.getLevel());
                tvNamaguru.setText(viewrapotModel.getNamaguru());
                tvTanggal.setText(viewrapotModel.getTanggal());
                tvPertemuanke.setText(viewrapotModel.getPertemuanke());
                tvMateri.setText(viewrapotModel.getMateri());
                tvHalamanketercapaian.setText("Halaman " + viewrapotModel.getHalamanketercapaian());
                tvHasil.setText(viewrapotModel.getHasil());
                tvCatatanguru.setText(viewrapotModel.getCatatanguru());
                tvRewardhasil.setRating(viewrapotModel.getRewardhasil());
                tvRewardsikap.setRating(viewrapotModel.getRewardsikap());
            }

            @Override
            public void onFailure(Call<ViewrapotModel> call, Throwable t) {

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
}