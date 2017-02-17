package com.example.gabri_gonzalez_5.cinemania.api;


import android.util.Log;

import com.example.gabri_gonzalez_5.cinemania.modelo.Pelicula;
import com.example.gabri_gonzalez_5.cinemania.modelo.PeliculasPopulares;
import com.example.gabri_gonzalez_5.cinemania.modelo.SeriesPopulares;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CineAdapter {
    protected final String TAG = getClass().getSimpleName();
    protected Retrofit mRestAdapter;
    protected CineApi mApi;
    static final String URL="https://api.themoviedb.org/3/";
    static final String APIKEY = "ea7ac738cceb66ccc09169062dc35782";

    public CineAdapter() {
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = mRestAdapter.create(CineApi.class); // create the interface

    }

    public void getPeliculas(Callback<PeliculasPopulares> callback){
        mApi.getPeliculas(APIKEY, "es").enqueue(callback);
    }
    public void getSeries(Callback<SeriesPopulares> callback){
        mApi.getSeries(APIKEY, "es").enqueue(callback);
    }
    public void getDetallePelicula(int idPelicula,Callback<Pelicula>callback){
        mApi.getDetallePelicula(idPelicula,APIKEY).enqueue(callback);
    }


}
