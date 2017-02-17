package com.example.gabri_gonzalez_5.cinemania;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gabri_gonzalez_5.cinemania.adapter.PeliculaAdapter;
import com.example.gabri_gonzalez_5.cinemania.adapter.SerieAdapter;
import com.example.gabri_gonzalez_5.cinemania.api.CineAdapter;
import com.example.gabri_gonzalez_5.cinemania.modelo.Pelicula;
import com.example.gabri_gonzalez_5.cinemania.modelo.PeliculasPopulares;
import com.example.gabri_gonzalez_5.cinemania.modelo.Serie;
import com.example.gabri_gonzalez_5.cinemania.modelo.SeriesPopulares;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaSeries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        //ListView listaPeliculas = (ListView) findViewById(R.id.listview);
        //listaPeliculas.setAdapter(new PeliculaAdapter(this,0,obtenerPeliculas()));
        obtenerSeriesApi();
    }

    public ArrayList<Serie> obtenerSeries() {
        ArrayList<Serie> series = new ArrayList<Serie>();
        series.add(new Serie ("Flopy","albertin tarari"));
        return series;
    }

    public void obtenerSeriesApi(){
        final ProgressDialog dialog = ProgressDialog.show(this, "", "Cargando", true);
        CineAdapter api = new CineAdapter();
        api.getSeries(new Callback<SeriesPopulares>() {
            @Override
            public void onResponse(Call<SeriesPopulares> call, Response<SeriesPopulares> response) {
                if(response.isSuccessful()){
                    SeriesPopulares seriecillas = response.body();
                    ListView listaSeries = (ListView) findViewById(R.id.listview);
                    listaSeries.setAdapter(new SerieAdapter(getApplicationContext(),0,seriecillas.getResults()));
                }else{
                    Toast.makeText(getApplicationContext(), "no se pudieron obtener series, intentelo mas tarde", Toast.LENGTH_SHORT).show();
                }
                dialog.cancel();

            }

            @Override
            public void onFailure(Call<SeriesPopulares> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "no se pudieron obtener series, intentelo mas tarde", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
    }
}

