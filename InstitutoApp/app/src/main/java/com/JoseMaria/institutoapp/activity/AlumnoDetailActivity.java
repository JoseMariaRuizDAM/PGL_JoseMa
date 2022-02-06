package com.JoseMaria.institutoapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.JoseMaria.institutoapp.R;
import com.JoseMaria.institutoapp.model.Alumnos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlumnoDetailActivity  extends AppCompatActivity {

    private Alumnos alumno;

    private TextView txtNombreApellidos;
    private TextView txtDni;
    private TextView txtFecha;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_detail);
        Bundle bundle = getIntent().getExtras();
        alumno = (Alumnos) bundle.get("alumno");
        init();
    }

    private void init() {
        txtNombreApellidos = findViewById(R.id.nombreAlumno);
        txtDni = findViewById(R.id.dni);
        txtFecha = findViewById(R.id.fechaNacimiento);
        recycler = findViewById(R.id.recycler);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtNombreApellidos.setText(alumno.getNombre() + " " + alumno.getApellidos());
        txtDni.setText("DNI: " + alumno.getDni());
        txtFecha.setText("Fecha de Nacimiento: " + sdf.format(new Date(alumno.getFechaNacimiento())));
    }

    public void onDeleteClicked(View view) {
        /*
        new DeleteAlumnoTask(getApplicationContext(), alumno, this).execute(null, null, null);
        Intent intent = new Intent(AlumnoDetails.this, MainActivity.class);
        startActivity(intent);*/
    }

    public void onEditarClicked(View view) {
        /*
        Intent intent = new Intent(AlumnoDetails.this, AddEditAlumno.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("alumno", alumno);
        intent.putExtras(bundle);
        startActivity(intent);*/
    }

    /*
    @Override
    public void onTaskCompleted(Object result) {
        matriculas = new ArrayList<>();
        Response response = (Response) result;
        if (response.getMessage() != null && !response.getMessage().isEmpty())
            runOnUiThread( () -> Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_SHORT).show());
        if (response.getBody() == null) return;
        try {
            matriculas.addAll((Collection<? extends Matricula>) response.getBody());
        } catch (ClassCastException ex) {
            matriculas.add((Matricula) response.getBody());
        }
        MatriculaListAdapter adapter = new MatriculaListAdapter((ArrayList<Matricula>) matriculas);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlumnoDetails.this, MatriculaDetails.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alumno", alumno);
                bundle.putSerializable("matricula", matriculas.get(recycler.getChildAdapterPosition(view)));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        runOnUiThread(() -> {
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setAdapter(adapter);
            if (matriculas.isEmpty())
                Toast.makeText(getApplicationContext(), R.string.no_results, Toast.LENGTH_LONG).show();
        });
    }*/
}
