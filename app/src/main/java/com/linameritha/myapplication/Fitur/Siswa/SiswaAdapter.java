package com.linameritha.myapplication.Fitur.Siswa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linameritha.myapplication.Model.Siswa.SiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ItemRowHolder> {
    ArrayList<SiswaModel> dataSiswa;
    private Context activity;

    public SiswaAdapter(Context activity, ArrayList<SiswaModel> dataSiswa){
        this.dataSiswa = dataSiswa;
        this.activity = activity;
    }

    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_siswa_cardview, viewGroup, false);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(ItemRowHolder holder, int i) {
        final SiswaModel siswaModel = dataSiswa.get(i);

        holder.tvNama.setText(dataSiswa.get(i).getNamalengkap());
        holder.tvKelas.setText(dataSiswa.get(i).getKelas());
        holder.tvProgram.setText(dataSiswa.get(i).getNamaprogram());
        holder.tvLevel.setText("Level " + dataSiswa.get(i).getLevel());
        holder.cvSiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailsiswaActivity.class);
                intent.putExtra("idsiswabelajar", siswaModel.getIdsiswabelajar());
                activity.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return (null != dataSiswa ? dataSiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgram, tvLevel;
        protected CardView cvSiswa;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgram = (TextView) view.findViewById(R.id.tvprogram);
            this.tvLevel = (TextView) view.findViewById(R.id.tvlevel);
            this.cvSiswa = (CardView) view.findViewById(R.id.cvsiswa);
        }
    }
}
