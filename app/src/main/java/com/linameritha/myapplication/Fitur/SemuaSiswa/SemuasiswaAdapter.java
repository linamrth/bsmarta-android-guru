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

public class SemuasiswaAdapter extends RecyclerView.Adapter<SemuasiswaAdapter.ItemRowHolder>{
    ArrayList<SemuasiswaModel> dataSemuasiswa;
    private Activity activity;

    public SemuasiswaAdapter(Activity activity, ArrayList<SemuasiswaModel> dataSemuasiswa){
        this.dataSemuasiswa = dataSemuasiswa;
        this.activity = activity;
    }

    public SemuasiswaAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_semuasiswa_cardview, viewGroup, false);
        SemuasiswaAdapter.ItemRowHolder mh = new SemuasiswaAdapter.ItemRowHolder(v);
        return mh;
    }

    public void onBindViewHolder(SemuasiswaAdapter.ItemRowHolder holder, int i) {

        holder.tvNama.setText(dataSemuasiswa.get(i).getNama());
        holder.tvProgramlevel.setText(dataSemuasiswa.get(i).getProgramlevel());
    }

    public int getItemCount() {
        return (null != dataSemuasiswa ? dataSemuasiswa.size() : 0);
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

                    Intent intent = new Intent(v.getContext(), DetailsemuasiswaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
