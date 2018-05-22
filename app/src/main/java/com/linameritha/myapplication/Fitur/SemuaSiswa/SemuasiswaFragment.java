package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.Siswa.SiswaAdapter;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaModel;
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
}
