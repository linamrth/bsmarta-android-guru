package com.linameritha.myapplication.Fitur.Profil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linameritha.myapplication.Model.Profil.ModelSkillProfile;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

public class ProfilfragmentAdapter extends RecyclerView.Adapter<ProfilfragmentAdapter.ItemRowHolder>{
    ArrayList<ModelSkillProfile> dataSkill;
    private Context activity;

    public ProfilfragmentAdapter (Context activity, ArrayList<ModelSkillProfile> dataSkill){
        this.dataSkill = dataSkill;
        this.activity = activity;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_profil_skill, viewGroup, false);
        ProfilfragmentAdapter.ItemRowHolder mh = new ProfilfragmentAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int i) {
        final ModelSkillProfile modelSkillProfile = dataSkill.get(i);

        holder.tvNamaprogram.setText(dataSkill.get(i).getNamaprogram());
        holder.tvLevel.setText("Level " + dataSkill.get(i).getLevel());
    }

    @Override
    public int getItemCount() {
        return (null != dataSkill ? dataSkill.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNamaprogram, tvLevel;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNamaprogram = (TextView) view.findViewById(R.id.tvnamaprogram);
            this.tvLevel = (TextView) view.findViewById(R.id.tvlevel);
        }
    }
}
