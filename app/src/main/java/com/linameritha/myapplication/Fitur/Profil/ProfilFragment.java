package com.linameritha.myapplication.Fitur.Profil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.LoginForm.LoginForm;
import com.linameritha.myapplication.Fitur.LoginForm.Session;
import com.linameritha.myapplication.Fitur.Menu.ButtomNavigation;
import com.linameritha.myapplication.Model.Profil.ModelResultProfile;
import com.linameritha.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilFragment extends Fragment {

    private ModelResultProfile modelResultProfile;
    private TextView tvNamaguru,tvNamacabang,tvTelepon,tvAlamat;
    private Button btnlogout;
    Session session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profil,null);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        Log.d("idguru", String.valueOf(sharedPreferences.getInt("idguru",0)));
        tvNamaguru = view.findViewById(R.id.tv_namaguru);
        tvNamacabang = view.findViewById(R.id.tv_namacabang);
        tvTelepon = view.findViewById(R.id.tv_telepon);
        tvAlamat = view.findViewById(R.id.tv_alamat);
        btnlogout = view.findViewById(R.id.btnlogout);

        session = new Session(getActivity());
        if (!session.login()){
            logout();
        }

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        ApiServices.services_get.getProfile(sharedPreferences.getInt("idguru",0)).enqueue(new Callback<ModelResultProfile>() {
            @Override
            public void onResponse(Call<ModelResultProfile> call, Response<ModelResultProfile> response) {
                modelResultProfile = response.body();

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

    private void logout(){
        session.setLogin(false, 0);
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginForm.class));
    }
}
