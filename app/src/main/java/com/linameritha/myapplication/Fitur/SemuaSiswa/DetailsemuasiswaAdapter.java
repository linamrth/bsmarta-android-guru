package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linameritha.myapplication.Fitur.Siswa.IsirapotActivity;
import com.linameritha.myapplication.Model.SemuaSiswa.DetailsemuasiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class DetailsemuasiswaAdapter extends RecyclerView.Adapter<DetailsemuasiswaAdapter.ItemRowHolder>{
    ArrayList<DetailsemuasiswaModel> dataDetailsemuasiswa;
    private Context activity;

    public DetailsemuasiswaAdapter(Context activity, ArrayList<DetailsemuasiswaModel> dataDetailsemuasiswa){
        this.dataDetailsemuasiswa = dataDetailsemuasiswa;
        this.activity = activity;
    }

    public DetailsemuasiswaAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detailsemuasiswa_cardview, viewGroup, false);
        DetailsemuasiswaAdapter.ItemRowHolder mh = new DetailsemuasiswaAdapter.ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(DetailsemuasiswaAdapter.ItemRowHolder holder, final int i) {
        final DetailsemuasiswaModel detailsemuasiswaModel = dataDetailsemuasiswa.get(i);

        holder.tvHari.setText(dataDetailsemuasiswa.get(i).getHari());
        holder.tvTanggal.setText(dataDetailsemuasiswa.get(i).getTanggal());
        holder.tvNamaguru.setText(dataDetailsemuasiswa.get(i).getNamaguru());
        String status;
        if(dataDetailsemuasiswa.get(i).getStatusrapotkursus().equals("S")){
            status = "Sudah Terisi";
        } else {
            status = "Belum Terisi";
        }
        holder.tvStatus.setText(status);
        holder.llStatusrapot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(detailsemuasiswaModel.getStatusrapotkursus().equals("S")){
                    Intent intent = new Intent(activity, ViewrapotActivity.class);
                    intent.putExtra("idgenerate", detailsemuasiswaModel.getIdgenerate());
                    activity.startActivity(intent);
                } else {
                    Intent intent = new Intent(activity, InputRapotActivity.class);
                    intent.putExtra("idgenerate", detailsemuasiswaModel.getIdgenerate()+"_"+(i+1));
                    activity.startActivity(intent);
                }
            }
        });
    }

    public int getItemCount() {
        return (null != dataDetailsemuasiswa ? dataDetailsemuasiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvHari, tvTanggal, tvNamaguru, tvStatus;
        protected LinearLayout llStatusrapot;
        public ItemRowHolder(View view) {
            super(view);

            this.tvHari = (TextView) view.findViewById(R.id.tvhari);
            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatusrapot);
            this.llStatusrapot = (LinearLayout) view.findViewById(R.id.llstatusrapot);
        }
    }
}
