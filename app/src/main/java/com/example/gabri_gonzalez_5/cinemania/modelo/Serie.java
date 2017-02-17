package com.example.gabri_gonzalez_5.cinemania.modelo;

/**
 * Created by gabri_gonzalez_5 on 10/12/16.
 */

public class Serie {

    String title;
    String overview;

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

    public Serie(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }
}
