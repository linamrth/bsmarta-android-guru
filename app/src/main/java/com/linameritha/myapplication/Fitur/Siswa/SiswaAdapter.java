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

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ItemRowHolder> {
    ArrayList<SiswaModel> dataSiswa;
    private Activity activity;

    public SiswaAdapter(Activity activity, ArrayList<SiswaModel> dataSiswa){
        this.dataSiswa = dataSiswa;
        this.activity = activity;
    }

    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_siswa_cardview, viewGroup, false);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(ItemRowHolder holder, int i) {

        holder.tvNama.setText(dataSiswa.get(i).getNama());
        holder.tvProgramlevel.setText(dataSiswa.get(i).getProgramlevel());
    }

    public int getItemCount() {
        return (null != dataSiswa ? dataSiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvProgramlevel;
        public ItemRowHolder(View view) {
            super(view);
            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvProgramlevel = (TextView)view.findViewById(R.id.tvprogramlevel);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), DetailsiswaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
