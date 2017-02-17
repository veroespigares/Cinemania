package com.example.gabri_gonzalez_5.cinemania.api;

import com.example.gabri_gonzalez_5.cinemania.modelo.Pelicula;
import com.example.gabri_gonzalez_5.cinemania.modelo.PeliculasPopulares;
import com.example.gabri_gonzalez_5.cinemania.modelo.Serie;
import com.example.gabri_gonzalez_5.cinemania.modelo.SeriesPopulares;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CineApi {
    @GET("movie/popular")
    Call<PeliculasPopulares> getPeliculas(
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("tv/popular")
    Call<SeriesPopulares> getSeries(
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("movie/{movie_id}")
    Call<Pelicula> getDetallePelicula(
            @Path("movie_id") int idPelicula,
            @Query("api_key") String apiKey);
}


