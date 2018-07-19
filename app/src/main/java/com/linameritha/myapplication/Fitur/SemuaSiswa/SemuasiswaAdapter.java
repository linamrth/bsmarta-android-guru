package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.linameritha.myapplication.Fitur.Siswa.DetailsiswaActivity;
import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaModel;
import com.linameritha.myapplication.Model.Siswa.SiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class SemuasiswaAdapter extends RecyclerView.Adapter<SemuasiswaAdapter.ItemRowHolder>{
    ArrayList<SemuasiswaModel> dataSemuasiswa;
    private Context activity;

    public SemuasiswaAdapter(Context activity, ArrayList<SemuasiswaModel> dataSemuasiswa){
        this.dataSemuasiswa = dataSemuasiswa;
        this.activity = activity;
    }

    public SemuasiswaAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_semuasiswa_cardview, viewGroup, false);
        SemuasiswaAdapter.ItemRowHolder mh = new SemuasiswaAdapter.ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(SemuasiswaAdapter.ItemRowHolder holder, int i) {
        final SemuasiswaModel semuasiswaModel = dataSemuasiswa.get(i);

        holder.tvNama.setText(dataSemuasiswa.get(i).getNamalengkap());
        holder.tvKelas.setText(dataSemuasiswa.get(i).getKelas());
        holder.tvProgram.setText(dataSemuasiswa.get(i).getNamaprogram());
        holder.tvLevel.setText("Level " + dataSemuasiswa.get(i).getLevel());
        holder.cvSemuasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailsemuasiswaActivity.class);
                intent.putExtra("idsiswabelajar", semuasiswaModel.getIdsiswabelajar());
                activity.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return (null != dataSemuasiswa ? dataSemuasiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgram, tvLevel;
        protected ImageView imgNama, imgKelas, imgProgram, imgLevel;
        protected CardView cvSemuasiswa;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgram = (TextView) view.findViewById(R.id.tvprogram);
            this.tvLevel = (TextView) view.findViewById(R.id.tvlevel);
            this.imgNama = (ImageView) view.findViewById(R.id.imgnama);
            this.imgKelas = (ImageView) view.findViewById(R.id.imgkelas);
            this.imgProgram = (ImageView) view.findViewById(R.id.imgprogram);
            this.imgLevel = (ImageView) view.findViewById(R.id.imglevel);
            this.cvSemuasiswa = (CardView) view.findViewById(R.id.cvsemuasiswa);
        }
    }
}
