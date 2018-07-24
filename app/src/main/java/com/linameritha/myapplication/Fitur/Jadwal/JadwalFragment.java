package com.linameritha.myapplication.Fitur.Jadwal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.LoginForm.LoginForm;
import com.linameritha.myapplication.Fitur.LoginForm.Session;
import com.linameritha.myapplication.Fitur.Menu.AboutUs;
import com.linameritha.myapplication.Fitur.Menu.EditPassword;
import com.linameritha.myapplication.Fitur.Siswa.SiswaAdapter;
import com.linameritha.myapplication.Model.Jadwal.JadwalModel;
import com.linameritha.myapplication.Model.Jadwal.JadwalModell;
import com.linameritha.myapplication.Model.Jadwal.JadwalresultModel;
import com.linameritha.myapplication.Model.Profil.ModelSkillProfile;
import com.linameritha.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalFragment extends Fragment {
    private JadwalresultModel jadwalresultModel;
    private RecyclerView rv;
    private JadwalAdapter jadwalAdapter;
    private Button btnSenin, btnSelasa, btnRabu, btnKamis, btnJumat, btnSabtu;
    private TextView hariharian;
    private RelativeLayout empty;
    Session session;
    Integer idguru;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal, null);

        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        idguru = sharedPreferences.getInt("idguru", 0);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        empty = (RelativeLayout) view.findViewById(R.id.empty);

        hariharian = (TextView) view.findViewById(R.id.tvhari);
        rv = (RecyclerView) view.findViewById(R.id.lv);
        btnSenin = (Button) view.findViewById(R.id.btn_senin);
        btnSelasa = (Button) view.findViewById(R.id.btn_selasa);
        btnRabu = (Button) view.findViewById(R.id.btn_rabu);
        btnKamis = (Button) view.findViewById(R.id.btn_kamis);
        btnJumat = (Button) view.findViewById(R.id.btn_jumat);
        btnSabtu = (Button) view.findViewById(R.id.btn_sabtu);

        session = new Session(getActivity());
        if (!session.login()){
            logout();
        }

        RecyclerView.LayoutManager lvManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lvManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        loadJadwal("Senin");

        btnSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJadwal("Senin");
            }
        });

        btnSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJadwal("Selasa");
            }
        });

        btnRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJadwal("Rabu");
            }
        });

        btnKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJadwal("Kamis");
            }
        });

        btnJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJadwal("Jumat");
            }
        });

        btnSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJadwal("Sabtu");
            }
        });

        return  view;
    }

    private void loadJadwal(String hari) {

//        ApiServices.services_get.getJadwal("1_"+hari).enqueue(new Callback<JadwalresultModel>()
        ApiServices.services_get.getJadwal( idguru+"_"+hari).enqueue(new Callback<JadwalresultModel>(){
            @Override
            public void onResponse(Call<JadwalresultModel> call, Response<JadwalresultModel> response) {
                //Untuk menampilkan hari
                JadwalresultModel resultModel = response.body();
                hariharian.setText(resultModel.getResults().getHari());

                //untuk menampilkan list jadwal
                jadwalAdapter = new JadwalAdapter(getActivity(), response.body().getResults());
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(jadwalAdapter);
                rv.getAdapter().notifyDataSetChanged();

                if (jadwalAdapter.getItemCount() == 0) {
                    empty.setVisibility(View.VISIBLE);
                } else {
                    empty.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<JadwalresultModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutus:
                Intent intent1 = new Intent(getActivity(), AboutUs.class);
                getActivity().startActivity(intent1);
                return true;
            case R.id.logout:
                logout();
                return true;
            case R.id.editpassword:
                Intent intent3 = new Intent(getActivity(), EditPassword.class);
                getActivity().startActivity(intent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        session.setLogin(false, 0, 0);
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginForm.class));
    }
}
