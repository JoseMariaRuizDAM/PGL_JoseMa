package com.JoseMaria.institutoapp.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.JoseMaria.institutoapp.R;
import com.JoseMaria.institutoapp.adapter.ListaAlumnosAdapter;
import com.JoseMaria.institutoapp.model.Alumnos;
import com.JoseMaria.institutoapp.networking.ApiUtils;
import com.JoseMaria.institutoapp.networking.retrofit.AlumnosService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AlumnoActivity extends AppCompatActivity {

    private Retrofit retrofit;
    AlumnosService service;
    List<Alumnos> listaAlumnos = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListaAlumnosAdapter listaAlumnosAdapter;

    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumnos_activity);
        service = ApiUtils.getAlumnosService();



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        obtenerDatos(this);
    }

    private void obtenerDatos(Context context) {

        Call<List<Alumnos>> listCall = service.searchAll();

        listCall.enqueue(new Callback<List<Alumnos>>() {
            @Override
            public void onResponse(Call<List<Alumnos>> call, Response<List<Alumnos>> response) {

                if(response.isSuccessful()){
                    listaAlumnos = response.body();
                    listaAlumnosAdapter = new ListaAlumnosAdapter(context, listaAlumnos);
                    recyclerView.setAdapter(listaAlumnosAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Alumnos>> call, Throwable t) {
                aptoParaCargar = false;
            }
        });


    }
}
