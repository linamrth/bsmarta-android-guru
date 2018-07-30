package com.linameritha.myapplication.Fitur.Profil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.LoginForm.LoginForm;
import com.linameritha.myapplication.Fitur.LoginForm.Session;
import com.linameritha.myapplication.Fitur.Menu.AboutUs;
import com.linameritha.myapplication.Fitur.Menu.EditPassword;
import com.linameritha.myapplication.Model.Profil.ModelResultProfile;
import com.linameritha.myapplication.Model.Profil.ModelSkillProfile;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilFragment extends Fragment {

    private ModelResultProfile modelResultProfile;
    private ProfilfragmentAdapter profilfragmentAdapter;
    private TextView tvNamaguru,tvNamacabang,tvTelepon,tvAlamat;
    private ImageView ivProfil;
    private RecyclerView rv;
    Session session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profil,container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        Log.d("idguru", String.valueOf(sharedPreferences.getInt("idguru",0)));
        rv = (RecyclerView) view.findViewById(R.id.rv);

        ivProfil = view.findViewById(R.id.ivprofilguru);
        tvNamaguru = view.findViewById(R.id.tv_namaguru);
        tvNamacabang = view.findViewById(R.id.tv_namacabang);
        tvTelepon = view.findViewById(R.id.tv_telepon);
        tvAlamat = view.findViewById(R.id.tv_alamat);

        session = new Session(getActivity());
        if (!session.login()){
            logout();
        }

        ApiServices.services_get.getProfile(sharedPreferences.getInt("idguru",0)).enqueue(new Callback<ModelResultProfile>() {
            @Override
            public void onResponse(Call<ModelResultProfile> call, Response<ModelResultProfile> response) {
                modelResultProfile = response.body();

                profilfragmentAdapter = new ProfilfragmentAdapter(getActivity(), (ArrayList<ModelSkillProfile>) modelResultProfile.getResults().getProgram());
                rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                rv.setAdapter(profilfragmentAdapter);
                rv.getAdapter().notifyDataSetChanged();

                Glide.with(view).load(modelResultProfile.getResults().getFoto()).into(ivProfil);
                tvNamaguru.setText(modelResultProfile.getResults().getNamaguru());
                tvNamacabang.setText(modelResultProfile.getResults().getNamacabang());
                tvTelepon.setText(modelResultProfile.getResults().getTelepon());
                tvAlamat.setText(modelResultProfile.getResults().getAlamat());
            }

            @Override
            public void onFailure(Call<ModelResultProfile> call, Throwable t) {

            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutus:
                Intent intent1 = new Intent(getActivity(), AboutUs.class);
                getActivity().startActivity(intent1);
                return true;
            case R.id.logout:
                logout();
                return true;
            case R.id.editpassword:
                Intent intent3 = new Intent(getActivity(), EditPassword.class);
                getActivity().startActivity(intent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        session.setLogin(false, 0, 0);
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginForm.class));
    }
}
