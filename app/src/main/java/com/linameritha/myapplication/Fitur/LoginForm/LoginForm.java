package com.linameritha.myapplication.Fitur.LoginForm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.linameritha.myapplication.Api.ApiServices;
import com.linameritha.myapplication.Fitur.Menu.ButtomNavigation;
import com.linameritha.myapplication.Model.Login.ModelResultLogin;
import com.linameritha.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginForm extends AppCompatActivity {

    private ModelResultLogin modelResultLogin;
    private EditText etUsername,etPassword;
    Session session;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        session = new Session(this);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        Button bt = (Button) findViewById(R.id.bt);

        if (session.login()){
            startActivity(new Intent(LoginForm.this, ButtomNavigation.class));
            finish();
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiServices.services_post.login(etUsername.getText().toString(),etPassword.getText().toString()).enqueue(new Callback<ModelResultLogin>() {
                    @Override
                    public void onResponse(Call<ModelResultLogin> call, Response<ModelResultLogin> response) {
                        modelResultLogin = response.body();

                            session.setLogin(true, modelResultLogin.getResult().getIdguru());

                            Log.d("username", modelResultLogin.getResult().getUsername());
                            Log.d("email", modelResultLogin.getResult().getEmail());
                            Log.d("idguru", String.valueOf(modelResultLogin.getResult().getIdguru()));


                            Intent intent = new Intent(LoginForm.this, ButtomNavigation.class);
                            startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ModelResultLogin> call, Throwable t) {
                        Toast.makeText(LoginForm.this, "Akun belum terdaftar !", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
