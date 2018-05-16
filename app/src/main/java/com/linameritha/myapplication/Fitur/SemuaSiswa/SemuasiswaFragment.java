package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class SemuasiswaFragment extends Fragment {

    private ArrayList<SemuasiswaModel> dataSemuasiswa = new ArrayList<>();
    private RecyclerView rv;
    private SemuasiswaAdapter siswa;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_semuasiswa, null);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        createDataSiswa();
        siswa = new SemuasiswaAdapter(getActivity(), dataSemuasiswa);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(siswa);
        return view;
    }

    private void createDataSiswa(){
        for (int i=0; i<10; i++){
            SemuasiswaModel siswa = new SemuasiswaModel("Ahmad Ardiansyah", "Cinta Matika - Level 1");
            dataSemuasiswa.add(siswa);
        }
    }
}
