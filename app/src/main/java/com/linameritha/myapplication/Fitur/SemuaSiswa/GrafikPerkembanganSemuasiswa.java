package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Model.SemuaSiswa.GrafikPerkembanganSemuasiswaModel;
import com.linameritha.myapplication.Model.Siswa.GrafikPerkembanganModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import im.dacer.androidcharts.LineView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GrafikPerkembanganSemuasiswa extends AppCompatActivity {
    private GrafikPerkembanganModel grafikPerkembanganModel;
    private LineView lineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik_perkembangan_semuasiswa);
        setTitle("Grafik Perkembangan");

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("idsiswabelajar", String.valueOf(idsiswabelajar));

        lineView = (LineView) findViewById(R.id.line_view);

        ApiServices.services_get.getGrafikPerkembangan(idsiswabelajar).enqueue(new Callback<GrafikPerkembanganModel>() {
            @Override
            public void onResponse(Call<GrafikPerkembanganModel> call, Response<GrafikPerkembanganModel> response) {
                grafikPerkembanganModel = response.body();
//                Toast.makeText(GrafikPerkembanganSiswa.this,  "Code : " + response.code(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()){
                    //Untuk Pertemuan
                    Integer pertemuan = grafikPerkembanganModel.getPertemuan().size();
                    ArrayList<String> mLabels = new ArrayList<String>();
                    for (int i = 0; i < pertemuan; i++) {
                        mLabels.add("Pertemuan " + grafikPerkembanganModel.getPertemuan().get(i).toString());
                    }
                    lineView.setBottomTextList(mLabels);
                    lineView.setColorArray(new int[] {
                            Color.parseColor("#F44336"), Color.parseColor("#9C27B0"),
                            Color.parseColor("#2196F3"), Color.parseColor("#009688")
                    });
                    lineView.setDrawDotLine(true);
                    lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);

                    //Untuk Data Target
                    ArrayList<Integer> targetlist = new ArrayList<>();
                    for (int i = 0; i < grafikPerkembanganModel.getTarget().size(); i++){
                        targetlist.add(grafikPerkembanganModel.getTarget().get(i));
                    }

                    //Untuk Data Hasil Ketercapaian
                    Integer hasiltarget = grafikPerkembanganModel.getHasiltarget().size();
                    ArrayList<Integer> dataList = new ArrayList<>();
                    for (int i = 0; i < hasiltarget; i++){
                        int hasil = Integer.parseInt(grafikPerkembanganModel.getHasiltarget().get(i));
                        dataList.add(hasil);
                    }

                    ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
                    dataLists.add(targetlist);
                    dataLists.add(dataList);
                    lineView.setDataList(dataLists);
                }
                else {
                    Toast.makeText(GrafikPerkembanganSemuasiswa.this, "** Belum Ada Data **", Toast.LENGTH_SHORT).show();
                };
            }

            @Override
            public void onFailure(Call<GrafikPerkembanganModel> call, Throwable t) {

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
