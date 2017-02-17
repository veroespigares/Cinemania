package com.example.gabri_gonzalez_5.cinemania.modelo;

/**
 * Created by gabri_gonzalez_5 on 10/12/16.
 */

public class Pelicula {

    String title;
    String overview;
    float popularity;
    String original_language;
    String release_date;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Pelicula(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }
}
