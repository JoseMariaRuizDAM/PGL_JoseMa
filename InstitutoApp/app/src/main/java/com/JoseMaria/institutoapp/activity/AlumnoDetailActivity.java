package com.JoseMaria.institutoapp.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.JoseMaria.institutoapp.R;
import com.JoseMaria.institutoapp.model.Alumnos;

public class AlumnoDetailActivity  extends AppCompatActivity {

    private Alumnos alumno;

    private TextView dni;
    private TextView nombreAlumno;
    private TextView apellidos;
    private TextView fechaNacimiento;
    private RecyclerView recycler;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumno_detail);

        Bundle bundle = getIntent().getExtras();
        //alumno = (Alumnos) bundle.get("alumno");
        dni = findViewById(R.id.dni_alumno);
        nombreAlumno = findViewById(R.id.nombre_alumno);
        apellidos = findViewById(R.id.apellidos_alumno);
        fechaNacimiento = findViewById(R.id.nacimiento_alumno);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                nombre = (null);
            } else {
                nombre = extras.getString("nombre");
            }
        } else {
            nombre = (String) savedInstanceState.getSerializable("nombre");
        }

        dni.setText(this.getIntent().getStringExtra("dni"));
        nombreAlumno.setText(this.getIntent().getStringExtra("nombre"));
        apellidos.setText("prueba");
        fechaNacimiento.setText("hola");
    }
        /*
        Bundle bundle = getIntent().getExtras();
        alumno = (Alumnos) bundle.get("alumno");
        init();
    }

    private void init() {
        dni = findViewById(R.id.dni_alumno);
        nombreAlumno = findViewById(R.id.nombre_alumno);
        apellidos = findViewById(R.id.apellidos_alumno);
        fechaNacimiento = findViewById(R.id.nacimiento_alumno);
        recycler = findViewById(R.id.recyclerView);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        nombreAlumno.setText(alumno.getNombre());
        apellidos.setText(alumno.getApellidos());
        dni.setText("DNI: " + alumno.getDni());
        fechaNacimiento.setText("Fecha de Nacimiento: " + sdf.format(new Date(alumno.getFechaNacimiento())));
    }*/
}
