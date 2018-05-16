package com.linameritha.myapplication.Fitur.Jadwal;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linameritha.myapplication.Model.Jadwal.JadwalModel;
import com.linameritha.myapplication.R;

import org.w3c.dom.Text;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.MyViewHolder> {
    private List<JadwalModel> dataJadwal;
    private Context context;

    public JadwalAdapter(Context context, List<JadwalModel> dataJadwal){
        this.dataJadwal = dataJadwal;
        this.context = context;
    }

    @Override
    public JadwalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_jadwalisi, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(JadwalAdapter.MyViewHolder holder, int position) {
        JadwalModel jadwalModel = dataJadwal.get(position);

        holder.clock.setText(jadwalModel.getJam());
        holder.nmsiswa.setText(jadwalModel.getNamasiswa());
        holder.nmprogramlevel.setText(jadwalModel.getProgramlevel());
        holder.statusk.setText(jadwalModel.getStatuskursus());
    }

    @Override
    public int getItemCount() {
        return dataJadwal.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView clock, nmsiswa, nmprogramlevel, statusk;

        public MyViewHolder(View itemView) {
            super(itemView);

            clock = (TextView) itemView.findViewById(R.id.tvjam);
            nmsiswa = (TextView) itemView.findViewById(R.id.tvnamasiswa);
            nmprogramlevel = (TextView) itemView.findViewById(R.id.tvprogramlevel);
            statusk = (TextView) itemView.findViewById(R.id.tvstatus);
        }
    }
}
