package com.example.gabri_gonzalez_5.cinemania;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gabri_gonzalez_5.cinemania.adapter.PeliculaAdapter;
import com.example.gabri_gonzalez_5.cinemania.api.CineAdapter;
import com.example.gabri_gonzalez_5.cinemania.modelo.Pelicula;
import com.example.gabri_gonzalez_5.cinemania.modelo.PeliculasPopulares;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaPeliculas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        //ListView listaPeliculas = (ListView) findViewById(R.id.listview);
        //listaPeliculas.setAdapter(new PeliculaAdapter(this,0,obtenerPeliculas()));
        obtenerPeliculasApi();
    }

    public ArrayList<Pelicula> obtenerPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas.add(new Pelicula ("Flopy","albertin tarari"));
        return peliculas;
    }

    public void obtenerPeliculasApi(){
        final ProgressDialog dialog = ProgressDialog.show(this, "", "Cargando", true);
        CineAdapter api = new CineAdapter();
        api.getPeliculas(new Callback<PeliculasPopulares>() {
            @Override
            public void onResponse(Call<PeliculasPopulares> call, Response<PeliculasPopulares> response) {
                if(response.isSuccessful()){
                    PeliculasPopulares pelis = response.body();
                    ListView listaPeliculas = (ListView) findViewById(R.id.listview);
                    listaPeliculas.setAdapter(new PeliculaAdapter(getApplicationContext(),0,pelis.getResults(),ListaPeliculas.this));
                }else{
                    Toast.makeText(getApplicationContext(), "no se pudieron obtener peliculas, intentelo mas tarde", Toast.LENGTH_SHORT).show();
                }
                dialog.cancel();

            }

            @Override
            public void onFailure(Call<PeliculasPopulares> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "no se pudieron obtener peliculas, intentelo mas tarde", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }

        });

    }
    public void verDetalle(int idPelicula){
        DetalleFragment detalle = new DetalleFragment();
        detalle.setIdPelicula(idPelicula);
        detalle.setListaPeliculas(this);
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        ft.add(R.id.frame1,detalle).commit();
    }

    public void quitarDetalle(){
        this.getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(R.id.frame1)).commit();
    }
}
