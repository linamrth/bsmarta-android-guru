package com.linameritha.myapplication.Fitur.Siswa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.LoginForm.LoginForm;
import com.linameritha.myapplication.Fitur.LoginForm.Session;
import com.linameritha.myapplication.Fitur.Menu.AboutUs;
import com.linameritha.myapplication.Fitur.Menu.EditPassword;
import com.linameritha.myapplication.Model.Siswa.SiswaresultModel;
import com.linameritha.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiswaFragment extends Fragment {
    private ArrayList<SiswaresultModel> dataSiswa;
    private RecyclerView rv;
    private SiswaAdapter siswaAdapter;
    private TextView tvNama, tvKelas, tvProgramlevel, tvLevel;
    Session session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_siswa, null);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        rv = (RecyclerView) view.findViewById(R.id.rv);

        session = new Session(getActivity());
        if (!session.login()){
            logout();
        }

        ApiServices.services_get.getSiswa(sharedPreferences.getInt("idguru", 0)).enqueue(new Callback<SiswaresultModel>() {
            @Override
            public void onResponse(Call<SiswaresultModel> call, Response<SiswaresultModel> response) {
                SiswaresultModel resultModel = response.body();

                siswaAdapter = new SiswaAdapter(getActivity(), resultModel.getSiswabelajar());
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(siswaAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SiswaresultModel> call, Throwable t) {

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

////    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setMessage("Apakah anda yakin ingin keluar ?")
//                .setCancelable(false)
//                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        getActivity().finish();
//                    }
//                })
//                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alert = builder.create();
//        alert.show();
//    }

    private void logout(){
        session.setLogin(false, 0, 0);
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginForm.class));
    }
}
