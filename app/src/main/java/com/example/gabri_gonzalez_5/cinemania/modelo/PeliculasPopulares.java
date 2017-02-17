package com.example.gabri_gonzalez_5.cinemania.modelo;

import java.util.ArrayList;

/**
 * Created by gabri_gonzalez_5 on 14/12/16.
 */

public class PeliculasPopulares {

    int page;
    ArrayList<Pelicula> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Pelicula> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pelicula> results) {
        this.results = results;
    }
}
