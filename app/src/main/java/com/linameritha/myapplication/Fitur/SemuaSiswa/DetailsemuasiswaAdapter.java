package com.linameritha.myapplication.Fitur.SemuaSiswa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linameritha.myapplication.Model.SemuaSiswa.SemuasiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class DetailsemuasiswaAdapter extends RecyclerView.Adapter<DetailsemuasiswaAdapter.ItemRowHolder>{
    ArrayList<SemuasiswaModel> dataDetailsemuasiswa;
    private Activity activity;

    public DetailsemuasiswaAdapter(Activity activity, ArrayList<SemuasiswaModel> dataDetailsemuasiswa){
        this.dataDetailsemuasiswa = dataDetailsemuasiswa;
        this.activity = activity;
    }

    public DetailsemuasiswaAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detailsemuasiswa_cardview, viewGroup, false);
        DetailsemuasiswaAdapter.ItemRowHolder mh = new DetailsemuasiswaAdapter.ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(DetailsemuasiswaAdapter.ItemRowHolder holder, int i) {

        holder.tvTanggal.setText(dataDetailsemuasiswa.get(i).getTanggal());
        holder.tvNamaguru.setText(dataDetailsemuasiswa.get(i).getNamaguru());
        holder.tvStatusrapot.setText(dataDetailsemuasiswa.get(i).getStatusrapot());
    }

    public int getItemCount() {
        return (null != dataDetailsemuasiswa ? dataDetailsemuasiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvNamaguru, tvStatusrapot;
        public ItemRowHolder(View view) {
            super(view);
            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView)view.findViewById(R.id.tvnamaguru);
            this.tvStatusrapot = (TextView)view.findViewById(R.id.tvstatusrapot);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), ViewrapotActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
