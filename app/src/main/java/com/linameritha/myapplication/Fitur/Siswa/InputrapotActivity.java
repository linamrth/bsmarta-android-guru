package com.linameritha.myapplication.Fitur.Siswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.linameritha.myapplication.Model.Siswa.SiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class InputrapotActivity extends AppCompatActivity {
    private EditText evnmguru;
    private EditText evmateri;
    private EditText evhasil;
    private EditText evhalketercapaian;
    private EditText evcatatanguru;
    private CheckBox cbrewardhasil1, cbrewardhasil2, cbrewardhasil3, cbrewardsikap1, cbrewardsikap2, cbrewardsikap3;
    private String nmguru, materi, hasil, halketercapaian, catatanguru, rewardhasil, rewardsikap;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputrapot);
        setTitle("Input Rapot Kursus");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        evnmguru = (EditText) findViewById(R.id.nmguru);
        evmateri = (EditText) findViewById(R.id.materi);
        evhasil = (EditText) findViewById(R.id.hasil);
        evhalketercapaian = (EditText) findViewById(R.id.halketercapaian);
        evcatatanguru = (EditText) findViewById(R.id.catatanguru);
        cbrewardhasil1 = (CheckBox) findViewById(R.id.cbrewardhasil1);
        cbrewardhasil2 = (CheckBox) findViewById(R.id.cbrewardhasil2);
        cbrewardhasil3 = (CheckBox) findViewById(R.id.cbrewardhasil3);
        cbrewardsikap1 = (CheckBox) findViewById(R.id.cbrewardsikap1);
        cbrewardsikap2 = (CheckBox) findViewById(R.id.cbrewardsikap2);
        cbrewardsikap3 = (CheckBox) findViewById(R.id.cbrewardsikap3);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputnilai();
                Intent intent = new Intent(view.getContext(), DetailsiswaActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    public  void inputnilai(){
        initialize();
        if(!validate()){
            Toast.makeText(this,"Input Tidak Falid", Toast.LENGTH_SHORT).show();
        }
        else {
            inputsukses();
        }
    }

    public void inputsukses(){

    }

    public boolean validate(){
        boolean valid = true;
        if (nmguru.isEmpty()){
            evnmguru.setError("Nama Guru Belum Terisi");
            valid = false;
        }
        if (materi.isEmpty()){
            evmateri.setError("Materi Belum Terisi");
            valid = false;
        }
        if (hasil.isEmpty()){
            evhasil.setError("Hasil Belajar Belum Terisi");
            valid = false;
        }
        if (halketercapaian.isEmpty()){
            evhalketercapaian.setError("Halaman Ketercapaian Belum Terisi");
            valid = false;
        }
        if (catatanguru.isEmpty()){
            evcatatanguru.setError("Catatan Guru Belum Terisi");
            valid = false;
        }
        return valid;
    }

    public void initialize(){
        nmguru = evnmguru.getText().toString().trim();
        materi = evmateri.getText().toString().trim();
        hasil = evhasil.getText().toString().trim();
        halketercapaian = evhalketercapaian.getText().toString().trim();
        catatanguru = evcatatanguru.getText().toString().trim();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
