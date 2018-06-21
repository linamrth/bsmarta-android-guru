package com.linameritha.myapplication.Fitur.Siswa;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.linameritha.myapplication.Model.Siswa.DetailsiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class DetailsiswaAdapter extends RecyclerView.Adapter<DetailsiswaAdapter.ItemRowHolder> {
    ArrayList<DetailsiswaModel> dataDetailsiswa;
    private Context activity;

    public DetailsiswaAdapter(Context activity, ArrayList<DetailsiswaModel> dataDetailsiswa){
        this.dataDetailsiswa = dataDetailsiswa;
        this.activity = activity;
    }

    public DetailsiswaAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detailsiswa_cardview, viewGroup, false);
        DetailsiswaAdapter.ItemRowHolder mh = new DetailsiswaAdapter.ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(ItemRowHolder holder, final int i) {
        final DetailsiswaModel detailsiswaModel = dataDetailsiswa.get(i);

        holder.tvHari.setText(dataDetailsiswa.get(i).getHari());
        holder.tvTanggal.setText(dataDetailsiswa.get(i).getTanggal());
        holder.tvNamaguru.setText(dataDetailsiswa.get(i).getNamaguru());
        String status;
        if(dataDetailsiswa.get(i).getStatusrapotkursus().equals("S")){
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
                if(detailsiswaModel.getStatusrapotkursus().equals("S")){
                    Intent intent = new Intent(activity, LihatrapotActivity.class);
                    intent.putExtra("idgenerate", detailsiswaModel.getIdgenerate());
                    activity.startActivity(intent);
                } else {
                    if (DateParser.now().after(DateParser.parseToDate(dataDetailsiswa.get(i).getTanggal()))){
                        Intent intent = new Intent(activity, IsirapotActivity.class);
                        intent.putExtra("idgenerate", detailsiswaModel.getIdgenerate()+"_"+(i+1));
                        activity.startActivity(intent);
                    } else {
                        Toast.makeText(activity, "Belum Saatnya Mengisi Rapot Kursus", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataDetailsiswa ? dataDetailsiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvHari, tvTanggal, tvNamaguru, tvStatus;
        protected ImageView logo;
        protected LinearLayout llStatusrapot;
        public ItemRowHolder(View view) {
            super(view);

            this.tvHari = (TextView) view.findViewById(R.id.tvhari);
            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatus);
            this.logo = (ImageView) view.findViewById(R.id.logostatus);
            this.llStatusrapot = (LinearLayout) view.findViewById(R.id.llstatusrapot);
        }
    }
}
