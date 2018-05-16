package com.linameritha.myapplication.Fitur.Siswa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linameritha.myapplication.Model.Siswa.SiswaModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class DetailsiswaAdapter extends RecyclerView.Adapter<DetailsiswaAdapter.ItemRowHolder> {
    ArrayList<SiswaModel> dataDetailsiswa;
    private Activity activity;

    public DetailsiswaAdapter(Activity activity, ArrayList<SiswaModel> dataDetailsiswa){
        this.dataDetailsiswa = dataDetailsiswa;
        this.activity = activity;
    }

    public DetailsiswaAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detailsiswa_cardview, viewGroup, false);
        DetailsiswaAdapter.ItemRowHolder mh = new DetailsiswaAdapter.ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(DetailsiswaAdapter.ItemRowHolder holder, int i) {

        holder.tvTanggal.setText(dataDetailsiswa.get(i).getTanggal());
        holder.tvNamaguru.setText(dataDetailsiswa.get(i).getNamaguru());
        holder.tvStatusrapot.setText(dataDetailsiswa.get(i).getStatusrapot());
    }

    @Override
    public int getItemCount() {
        return (null != dataDetailsiswa ? dataDetailsiswa.size() : 0);
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

                    Intent intent = new Intent(v.getContext(), InputrapotActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
