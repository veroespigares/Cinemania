package com.example.gabri_gonzalez_5.cinemania;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabri_gonzalez_5.cinemania.api.CineAdapter;
import com.example.gabri_gonzalez_5.cinemania.modelo.Pelicula;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gabri_gonzalez_5 on 14/2/17.
 */

public class DetalleFragment extends Fragment {

    int idPelicula;
    ListaPeliculas listaPeliculas;

    public void setListaPeliculas(ListaPeliculas listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle,container,false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CineAdapter api = new CineAdapter();
        api.getDetallePelicula(idPelicula, new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                if(response.isSuccessful()){
                    Pelicula pelicula = response.body();
                    TextView fecha = (TextView) view.findViewById(R.id.tvfecha);
                    fecha.setText(pelicula.getRelease_date());
                    TextView idioma = (TextView) view.findViewById(R.id.tvidioma);
                    idioma.setText(pelicula.getOriginal_language());
                    TextView popularidad = (TextView) view.findViewById(R.id.tvpopularidad);
                    popularidad.setText(pelicula.getPopularity() + "");
                    Button quitar =(Button) view.findViewById(R.id.btquitar);
                    quitar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listaPeliculas.quitarDetalle();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {

            }
        });
    }
}
