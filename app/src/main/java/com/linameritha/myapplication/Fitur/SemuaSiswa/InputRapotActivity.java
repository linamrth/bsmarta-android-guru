package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.Siswa.IsirapotActivity;
import com.linameritha.myapplication.Model.SemuaSiswa.GurusemuasiswaModel;
import com.linameritha.myapplication.Model.SemuaSiswa.InputrapotresultsemuasiswaModel;
import com.linameritha.myapplication.Model.SemuaSiswa.MaterihalamansemuasiswaModel;
import com.linameritha.myapplication.Model.Siswa.GuruModel;
import com.linameritha.myapplication.Model.Siswa.MaterihalamanModel;
import com.linameritha.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputRapotActivity extends AppCompatActivity {
    private GurusemuasiswaModel gurusemuasiswaModel;
    private MaterihalamansemuasiswaModel materihalamansemuasiswaModel;
    private EditText namaguru, materi, hal, hasil, catatanguru;
    private RadioGroup rewardhasil, rewardsikap;
    private RadioButton rewardhasil1, rewardhasil2, rewardhasil3;
    private RadioButton rewardsikap1, rewardsikap2, rewardsikap3;
    private Button button;
    Integer nilai1, nilai2;
    String idgenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_rapot);
        setTitle("Input Rapot Kursus");

        final SharedPreferences sharedPreferences = InputRapotActivity.this.getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        Log.d("idguru", String.valueOf(sharedPreferences.getInt("idguru",0)));

        Intent intent = getIntent();
        idgenerate = intent.getStringExtra("idgenerate");
        Log.d("terserah", String.valueOf(idgenerate));

        namaguru = (EditText) findViewById(R.id.nmguru);
        materi = (EditText) findViewById(R.id.materi);
        hal = (EditText) findViewById(R.id.halketercapaian);
        hasil = (EditText) findViewById(R.id.hasil);
        catatanguru = (EditText) findViewById(R.id.catatanguru);

        rewardhasil = (RadioGroup) findViewById(R.id.rewardhasil);
        rewardsikap = (RadioGroup) findViewById(R.id.rewardsikap);

        rewardhasil1 = (RadioButton) findViewById(R.id.rewardhasil1);
        rewardhasil2 = (RadioButton) findViewById(R.id.rewardhasil2);
        rewardhasil3 = (RadioButton) findViewById(R.id.rewardhasil3);

        rewardsikap1 = (RadioButton) findViewById(R.id.rewardsikap1);
        rewardsikap2 = (RadioButton) findViewById(R.id.rewardsikap2);
        rewardsikap3 = (RadioButton) findViewById(R.id.rewardsikap3);

        button = (Button) findViewById(R.id.button);

        ApiServices.services_get.getGurusemuasiswa(sharedPreferences.getInt("idguru", 0)).enqueue(new Callback<GurusemuasiswaModel>() {
            @Override
            public void onResponse(Call<GurusemuasiswaModel> call, Response<GurusemuasiswaModel> response) {
                gurusemuasiswaModel = response.body();

                namaguru.setText(gurusemuasiswaModel.getNamaguru());
            }

            @Override
            public void onFailure(Call<GurusemuasiswaModel> call, Throwable t) {

            }
        });

        ApiServices.services_get.getMaterihalamansemuasiswa(idgenerate).enqueue(new Callback<MaterihalamansemuasiswaModel>() {
            @Override
            public void onResponse(Call<MaterihalamansemuasiswaModel> call, Response<MaterihalamansemuasiswaModel> response) {
                materihalamansemuasiswaModel = response.body();

                materi.setText(materihalamansemuasiswaModel.getMateri());
                //Toast.makeText(IsirapotActivity.this,"materi : " + materihalamanModel.getMateri(), Toast.LENGTH_SHORT).show();
                hal.setText(materihalamansemuasiswaModel.getHal()+"");
            }

            @Override
            public void onFailure(Call<MaterihalamansemuasiswaModel> call, Throwable t) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rewardhasil1.isChecked()){
                    nilai1 = Integer.parseInt(rewardhasil1.getText().toString());
                } else if (rewardhasil2.isChecked()){
                    nilai1 = Integer.parseInt(rewardhasil2.getText().toString());
                } else if (rewardhasil3.isChecked()){
                    nilai1 = Integer.parseInt(rewardhasil3.getText().toString());
                }

                if (rewardsikap1.isChecked()){
                    nilai2 = Integer.parseInt(rewardsikap1.getText().toString());
                } else if (rewardsikap2.isChecked()){
                    nilai2 = Integer.parseInt(rewardsikap2.getText().toString());
                } else if (rewardsikap3.isChecked()){
                    nilai2 = Integer.parseInt(rewardsikap3.getText().toString());
                }

                if(hasil.getText().toString().isEmpty() || catatanguru.getText().toString().isEmpty() || hal.getText().toString().isEmpty() || materi.getText().toString().isEmpty()) {
                    Toast.makeText(InputRapotActivity.this, "Mohon legkapi form", Toast.LENGTH_SHORT).show();
                }
                else {
                    String materi1 = materi.getText().toString();
                    Integer halk = Integer.parseInt(hal.getText().toString());
                    String hasilb = hasil.getText().toString();
                    String catatan = catatanguru.getText().toString();

                    ApiServices.services_post.rapotallsiswa(idgenerate, sharedPreferences.getInt("idguru", 0), materi1, halk, hasilb, catatan, nilai1, nilai2).enqueue(new Callback<InputrapotresultsemuasiswaModel>() {
                        @Override
                        public void onResponse(Call<InputrapotresultsemuasiswaModel> call, Response<InputrapotresultsemuasiswaModel> response) {
                            if(response.isSuccessful()) {
                                String status = response.body().getStatus();

                                if(status.equals("OK")) {
                                    Toast.makeText(InputRapotActivity.this, "Berhasil input rapot", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                                else {
                                    Toast.makeText(InputRapotActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<InputrapotresultsemuasiswaModel> call, Throwable t) {

                        }
                    });
                }
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
