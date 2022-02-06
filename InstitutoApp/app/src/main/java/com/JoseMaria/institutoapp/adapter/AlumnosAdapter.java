package com.JoseMaria.institutoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.JoseMaria.institutoapp.R;
import com.JoseMaria.institutoapp.model.Alumnos;

import java.util.List;

public class AlumnosAdapter extends ArrayAdapter<Alumnos> {

    private Context context;
    private List<Alumnos> alumnosList;

    public AlumnosAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Alumnos> objects) {
        super(context, resource, objects);
        this.context = context;
        this.alumnosList = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.alumnos_lista, parent, false);

        TextView dniAlumno = (TextView) rowView.findViewById(R.id.dni_alumno);
        TextView nombreAlumno = (TextView) rowView.findViewById(R.id.nombre_alumno);
        TextView apellidosAlumno = (TextView) rowView.findViewById(R.id.apellidos_alumno);
        TextView nacimientoAlumno = (TextView) rowView.findViewById(R.id.nacimiento_alumno);

        dniAlumno.setText(String.format("DNI: %s", alumnosList.get(pos).getDni()));
        nombreAlumno.setText(String.format("USER NAME: %s", alumnosList.get(pos).getNombre()));
        apellidosAlumno.setText(String.format("Apellidos: %s", alumnosList.get(pos).getApellidos()));
        nacimientoAlumno.setText(String.format("Fecha de Nacimiento NAME: %s", alumnosList.get(pos).getFechaNacimiento()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                /*Intent intent = new Intent(context, AlumnoActivity.class);
                intent.putExtra("Alumno_dni", String.valueOf(alumnosList.get(pos).getDni()));
                intent.putExtra("Alumno_nombre", alumnosList.get(pos).getNombre());
                context.startActivity(intent);*/
            }
        });
        return rowView;
    }
}
