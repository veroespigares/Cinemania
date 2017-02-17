package com.example.gabri_gonzalez_5.cinemania;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by gabri_gonzalez_5 on 10/12/16.
 */

public class ActivitySeleccionar extends AppCompatActivity {

    public static int REQUEST_SERIES = 10;
    public static int REQUEST_PELICULAS = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar);

        Button btPeliculas = (Button) findViewById(R.id.bt_peliculas);
        btPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivitySeleccionar.this,ListaPeliculas.class);
                startActivityForResult(i,REQUEST_PELICULAS);
            }
        });

        Button btSeries = (Button) findViewById(R.id.bt_series);
        btSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivitySeleccionar.this,ListaSeries.class);
                startActivityForResult(i,REQUEST_SERIES);
            }
        });
    }
}
