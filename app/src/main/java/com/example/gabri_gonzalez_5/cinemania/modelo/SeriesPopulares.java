package com.example.gabri_gonzalez_5.cinemania.modelo;

import java.util.ArrayList;

/**
 * Created by gabri_gonzalez_5 on 15/12/16.
 */

public class SeriesPopulares {

    int page;
    ArrayList<Serie> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Serie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Serie> results) {
        this.results = results;
    }
}
