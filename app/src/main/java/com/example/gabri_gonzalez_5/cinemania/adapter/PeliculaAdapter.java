package com.example.gabri_gonzalez_5.cinemania.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gabri_gonzalez_5.cinemania.ListaPeliculas;
import com.example.gabri_gonzalez_5.cinemania.R;
import com.example.gabri_gonzalez_5.cinemania.modelo.Pelicula;

import java.util.List;

/**
 * Created by gabri_gonzalez_5 on 14/12/16.
 */

public class PeliculaAdapter extends ArrayAdapter<Pelicula>{

    ListaPeliculas activity;

    private class PeliculaHolder{
        TextView titulo;
        TextView descripcion;

    }


    public PeliculaAdapter(Context context, int textViewResourceId, List<Pelicula> objects,ListaPeliculas activity) {
        super(context, textViewResourceId, objects);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PeliculaHolder vista;
        if(convertView == null){
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item_fila,parent,false);
            vista = new PeliculaHolder();
            vista.titulo = (TextView) convertView.findViewById(R.id.tv_nombre);
            vista.descripcion = (TextView) convertView.findViewById(R.id.tvdescripcion);
            convertView.setTag(vista);
        }else{
            vista = (PeliculaHolder) convertView.getTag();
        }
        final Pelicula pelicula = getItem(position);
        if(pelicula != null){
            vista.descripcion.setText(pelicula.getOverview());
            vista.titulo.setText(pelicula.getTitle());
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.verDetalle(pelicula.getId());
            }
        });
        return convertView;
    }

}
