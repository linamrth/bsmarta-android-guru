package com.linameritha.myapplication.Fitur.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.linameritha.myapplication.Fitur.Jadwal.JadwalFragment;
import com.linameritha.myapplication.Fitur.LoginForm.LoginForm;
import com.linameritha.myapplication.Fitur.LoginForm.Session;
import com.linameritha.myapplication.Fitur.Profil.ProfilFragment;
import com.linameritha.myapplication.Fitur.SemuaSiswa.SemuasiswaFragment;
import com.linameritha.myapplication.Fitur.Siswa.SiswaFragment;
import com.linameritha.myapplication.R;

public class ButtomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_navigation);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new JadwalFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.navigation_jadwal:
                fragment = new JadwalFragment();
                break;

            case  R.id.navigation_student:
                fragment = new SiswaFragment();
                break;

            case R.id.navigation_multistudent:
                fragment = new SemuasiswaFragment();
                break;

            case R.id.navigation_profil:
                fragment = new ProfilFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
