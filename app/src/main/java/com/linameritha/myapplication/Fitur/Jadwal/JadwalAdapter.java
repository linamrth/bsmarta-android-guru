package com.linameritha.myapplication.Fitur.Jadwal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linameritha.myapplication.Fitur.Profil.ProfilfragmentAdapter;
import com.linameritha.myapplication.Model.Jadwal.JadwalModel;
import com.linameritha.myapplication.Model.Jadwal.JadwalModell;
import com.linameritha.myapplication.Model.Profil.ModelSkillProfile;
import com.linameritha.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ItemRowHolder> {
    private JadwalModell dataJadwal;
    private Context activity;

    public JadwalAdapter(Context activity, JadwalModell dataJadwal){
        this.dataJadwal = dataJadwal;
        this.activity = activity;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_jadwalisi, viewGroup, false);
        JadwalAdapter.ItemRowHolder mh = new JadwalAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int i) {

        holder.tvJam.setText(dataJadwal.getJam().get(i));
        holder.tvJadwal.setText(dataJadwal.getJadwal().get(i));
    }

    @Override
    public int getItemCount() {
        return (dataJadwal.getJam() != null ) ? dataJadwal.getJam().size() : 0;
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvJam, tvJadwal;
        public ItemRowHolder(View view) {
            super(view);

            this.tvJam = (TextView) view.findViewById(R.id.tvjam);
            this.tvJadwal = (TextView) view.findViewById(R.id.tvjadwal);
        }
    }
}
