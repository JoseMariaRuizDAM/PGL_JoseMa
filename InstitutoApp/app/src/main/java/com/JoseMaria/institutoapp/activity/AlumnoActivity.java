package com.JoseMaria.institutoapp.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
/*
        if (aptoParaCargar) {
            aptoParaCargar = false;
            obtenerDatos();
        }

        retrofit = new Retrofit.Builder()
                .baseUrl("https://rest-instituto.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;*/
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

        /*
            @Override
            public void onResponse(Call call, Response response) {
                aptoParaCargar = true;
                if(response.isSuccessful()){
                    AlumnosFetchResults AlumnoRespuesta = response.body();
                    ArrayList<Alumnos> listaPokemon = AlumnoRespuesta.getResults();

                    listaAlumnosAdapter.addListPokemon(listaPokemon);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        pokemonRespuestaCall.enqueue(new Callback<PokemonFetchResults>() {
            @Override
            public void onResponse(Call<PokemonFetchResults> call, Response<PokemonFetchResults> response) {
                aptoParaCargar = true;
                if (response.isSuccessful()) {

                    PokemonFetchResults pokemonRespuesta = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

                    listaAlumnosAdapter.addListPokemon(listaPokemon);

                }
            }

            @Override
            public void onFailure(Call<PokemonFetchResults> call, Throwable t) {
                aptoParaCargar = true;
            }

        });
    }
    /*

    AlumnosService alumnosService;
    ListView listView;
    List<Alumnos> list = new ArrayList<Alumnos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumnos_activity);
        alumnosService = ApiUtils.getAlumnosService();
        listView = findViewById(R.id.listaAlumnos);
        getAlumnosList(listView);
    }

    public void getAlumnosList(View view){

        Call<List<Alumnos>> call = alumnosService.searchAll();
        call.enqueue(new Callback<List<Alumnos>>() {
            @Override
            public void onResponse(Call<List<Alumnos>> call, Response<List<Alumnos>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(
                            new AlumnosAdapter(AlumnoActivity.this,
                                    R.layout.alumnos_activity, list));
                }
            }

            @Override
            public void onFailure(Call<List<Alumnos>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
    */
    }
}
