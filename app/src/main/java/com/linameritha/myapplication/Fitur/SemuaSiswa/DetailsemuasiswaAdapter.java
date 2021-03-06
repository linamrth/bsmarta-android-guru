package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linameritha.myapplication.Fitur.Siswa.DateParser;
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

        holder.tvPertemuanke.setText("Pertemuan Ke "+ String.valueOf(i + 1));
        holder.tvHari.setText(dataDetailsemuasiswa.get(i).getHari());
        holder.tvTanggal.setText(dataDetailsemuasiswa.get(i).getTanggal());
        holder.tvNamaguru.setText(dataDetailsemuasiswa.get(i).getNamaguru());
        String status;
        if(dataDetailsemuasiswa.get(i).getStatusrapotkursus().equals("S")){
            status = "Sudah Terisi";
            holder.logo.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
        } else {
            status = "Belum Terisi";
            holder.logo.setBackgroundResource(R.drawable.ic_add_circle_black_24dp);
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
                    if (com.linameritha.myapplication.Fitur.Siswa.DateParser.now().after(DateParser.parseToDate(dataDetailsemuasiswa.get(i).getTanggal()))) {
                        Intent intent = new Intent(activity, InputRapotActivity.class);
                        intent.putExtra("idgenerate", detailsemuasiswaModel.getIdgenerate()+"_"+(i+1));
                        activity.startActivity(intent);
                    } else {
                        Toast.makeText(activity, "Belum Saatnya Mengisi Rapot Kursus", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public int getItemCount() {
        return (null != dataDetailsemuasiswa ? dataDetailsemuasiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvPertemuanke, tvHari, tvTanggal, tvNamaguru, tvStatus;
        protected ImageView logo;
        protected LinearLayout llStatusrapot;
        public ItemRowHolder(View view) {
            super(view);

            this.tvPertemuanke = (TextView) view.findViewById(R.id.tvpertemuanke);
            this.tvHari = (TextView) view.findViewById(R.id.tvhari);
            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatus);
            this.logo = (ImageView) view.findViewById(R.id.logostatus);
            this.llStatusrapot = (LinearLayout) view.findViewById(R.id.llstatusrapot);
        }
    }
}
