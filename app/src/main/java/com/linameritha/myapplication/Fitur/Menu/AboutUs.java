
package com.linameritha.myapplication.Fitur.Menu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.linameritha.myapplication.R;

public class AboutUs extends AppCompatActivity {
    private ImageView Logo;
    private TextView tvAplikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        setTitle("About Us");

        Logo = (ImageView) findViewById(R.id.logo);
        tvAplikasi = (TextView) findViewById(R.id.tentangaplikasi);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
