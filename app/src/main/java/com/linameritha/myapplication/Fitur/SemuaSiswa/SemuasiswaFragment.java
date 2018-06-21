package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.Menu.AboutUs;
import com.linameritha.myapplication.Fitur.Menu.EditPassword;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaresultModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SemuasiswaFragment extends Fragment {
    private ArrayList<SemuasiswaresultModel> dataSemuasiswa;
    private RecyclerView rv;
    private SemuasiswaAdapter semuasiswaAdapter;
    private TextView tvNama, tvKelas, tvProgramlevel, tvLevel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_semuasiswa, null);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        rv = (RecyclerView) view.findViewById(R.id.rv);

        ApiServices.services_get.getSemuasiswa(sharedPreferences.getInt("idguru", 0)).enqueue(new Callback<SemuasiswaresultModel>() {
            @Override
            public void onResponse(Call<SemuasiswaresultModel> call, Response<SemuasiswaresultModel> response) {
                SemuasiswaresultModel resultModel = response.body();

                semuasiswaAdapter = new SemuasiswaAdapter(getActivity(), resultModel.getSiswabelajar());
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(semuasiswaAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SemuasiswaresultModel> call, Throwable t) {

            }
        });

        return view;
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
                Toast.makeText(getActivity(), "Log Out Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.editpassword:
                Intent intent3 = new Intent(getActivity(), EditPassword.class);
                getActivity().startActivity(intent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
