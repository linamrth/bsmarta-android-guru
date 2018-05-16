package com.linameritha.myapplication.Fitur.Jadwal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.linameritha.myapplication.Fitur.SemuaSiswa.ViewrapotAdapter;
import com.linameritha.myapplication.Model.Jadwal.JadwalModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class JadwalFragment extends Fragment {
    private List<JadwalModel> dataJadwal = new ArrayList<>();
    private RecyclerView lv;
    private Button btnSenin, btnSelasa, btnRabu, btnKamis, btnJumat, btnSabtu;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal, null);

        lv = (RecyclerView) view.findViewById(R.id.lv);
        btnSenin = (Button) view.findViewById(R.id.btn_senin);
        btnSelasa = (Button) view.findViewById(R.id.btn_selasa);
        btnRabu = (Button) view.findViewById(R.id.btn_rabu);
        btnKamis = (Button) view.findViewById(R.id.btn_kamis);
        btnJumat = (Button) view.findViewById(R.id.btn_jumat);
        btnSabtu = (Button) view.findViewById(R.id.btn_sabtu);

        RecyclerView.LayoutManager lvManager = new LinearLayoutManager(getContext());
        lv.setLayoutManager(lvManager);
        lv.setItemAnimator(new DefaultItemAnimator());
        lv.setAdapter(new JadwalAdapter(getContext(), dataJadwal));

        btnSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataJadwalSenin();
            }
        });

        btnSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataJadwalSelasa();
            }
        });

        btnRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataJadwalRabu();
            }
        });

        btnKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataJadwalKamis();
            }
        });

        btnJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataJadwalJumat();
            }
        });

        btnSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataJadwalSabtu();
            }
        });

        return  view;
    }

    private void setDataJadwalSenin() {
        dataJadwal.clear();

        JadwalModel model = new JadwalModel(
                "10.00 - 11.00",
                "Lina Meritha",
                "Cinta Matika - 1",
                "Kursus"
        );
        dataJadwal.add(model);

        model = new JadwalModel(
                "10.00 - 11.00",
                "Sherly Febrina Luhukay",
                "Cinta Baca - 1",
                "Kursus"
        );
        dataJadwal.add(model);

        model = new JadwalModel(
                "10.00 - 11.00",
                "Lina Meritha",
                "Cinta Bahasa - 1",
                "Kursus"
        );
        dataJadwal.add(model);

        model = new JadwalModel(
                "10.00 - 11.00",
                "Raditya Putranto",
                "Cinta Bahasa - 1",
                "Trial"
        );
        dataJadwal.add(model);

        model = new JadwalModel(
                "10.00 - 11.00",
                "Kila Kiantari Katasya",
                "Cinta Bahasa - 1",
                "Kursus"
        );
        dataJadwal.add(model);

        lv.getAdapter().notifyDataSetChanged();
    }

    private void setDataJadwalSelasa() {
        dataJadwal.clear();

        JadwalModel model = new JadwalModel(
                "10.00 - 11.00",
                "Ahmad Ardiansyah",
                "Cinta Kamu - 4ever",
                "Private"
        );
        dataJadwal.add(model);

        lv.getAdapter().notifyDataSetChanged();
    }

    private void setDataJadwalRabu() {
        dataJadwal.clear();

        JadwalModel model = new JadwalModel(
                "10.00 - 11.00",
                "Muhammad Fadhil Akbar",
                "Cinta Kamu - 4ever",
                "Private"
        );
        dataJadwal.add(model);

        lv.getAdapter().notifyDataSetChanged();
    }

    private void setDataJadwalKamis() {
        dataJadwal.clear();

        JadwalModel model = new JadwalModel(
                "10.00 - 11.00",
                "Muhibush Sulhi Muhammad",
                "Cinta Kamu - 4ever",
                "Private"
        );
        dataJadwal.add(model);

        lv.getAdapter().notifyDataSetChanged();
    }

    private void setDataJadwalJumat() {
        dataJadwal.clear();

        JadwalModel model = new JadwalModel(
                "10.00 - 11.00",
                "Muhammad Ali Rodhi",
                "Cinta Kamu - 4ever",
                "Private"
        );
        dataJadwal.add(model);

        lv.getAdapter().notifyDataSetChanged();
    }

    private void setDataJadwalSabtu() {
        dataJadwal.clear();

        JadwalModel model = new JadwalModel(
                "10.00 - 11.00",
                "Shela Ernita Sari",
                "Cinta Kamu - 4ever",
                "Private"
        );
        dataJadwal.add(model);

        lv.getAdapter().notifyDataSetChanged();
    }
}