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
                    /*
                    listaAlumnosAdapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Context context = view.getContext();
                            Intent intent = new Intent(context, AlumnoDetailActivity.class);
                            /*
                            intent.putExtra("dni", listaAlumnos.get(getAbsoluteAdapterPosition()).getNumber());
                            intent.putExtra("nombre", listaAlumnos.get();
                            intent.putExtra("apellidos", listaAlumnos.get(getAbsoluteAdapterPosition()).getDescription());
                            startActivity(intent);

                            Alumnos alumno = listaAlumnos.get(recyclerView.getChildAdapterPosition(view));
                            Intent intent = new Intent(AlumnoActivity.this, AlumnoDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("alumno", (Serializable) listaAlumnos);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });*/
                }
            }

            @Override
            public void onFailure(Call<List<Alumnos>> call, Throwable t) {
                aptoParaCargar = false;
            }
        });


    }
}
