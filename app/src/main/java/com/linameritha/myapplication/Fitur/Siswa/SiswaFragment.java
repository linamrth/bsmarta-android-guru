package com.linameritha.myapplication.Fitur.Siswa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linameritha.myapplication.Model.Siswa.SiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class SiswaFragment extends Fragment {

    private ArrayList<SiswaModel> dataSiswa = new ArrayList<>();
    private RecyclerView rv;
    private SiswaAdapter siswa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_siswa, null);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        createDataSiswa();
        siswa = new SiswaAdapter(getActivity(), dataSiswa);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(siswa);
        return view;
    }

    private void createDataSiswa(){
        for (int i=0; i<10; i++){
            SiswaModel siswa = new SiswaModel("Lina Meritha", "Cinta Baca - Level 1");
            dataSiswa.add(siswa);
        }
    }
}
