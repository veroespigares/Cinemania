package com.example.gabri_gonzalez_5.cinemania.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gabri_gonzalez_5.cinemania.R;
import com.example.gabri_gonzalez_5.cinemania.modelo.Pelicula;
import com.example.gabri_gonzalez_5.cinemania.modelo.Serie;

import java.util.List;

/**
 * Created by gabri_gonzalez_5 on 15/12/16.
 */

public class SerieAdapter extends ArrayAdapter<Serie> {

    private class SerieHolder{
        TextView titulo;
        TextView descripcion;
    }


    public SerieAdapter(Context context, int textViewResourceId, List<Serie> objects) {
        super(context, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SerieAdapter.SerieHolder vista;
        if(convertView == null){
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.item_fila,parent,false);
            vista = new SerieAdapter.SerieHolder();
            vista.titulo = (TextView) convertView.findViewById(R.id.tv_nombre);
            vista.descripcion = (TextView) convertView.findViewById(R.id.tvdescripcion);
            convertView.setTag(vista);
        }else{
            vista = (SerieAdapter.SerieHolder) convertView.getTag();
        }
        Serie serie = getItem(position);
        if(serie != null){
            vista.descripcion.setText(serie.getOverview());
            vista.titulo.setText(serie.getTitle());
        }
        return convertView;
    }

}

