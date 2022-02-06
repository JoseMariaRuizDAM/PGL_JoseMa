package com.JoseMaria.institutoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.JoseMaria.institutoapp.R;
import com.JoseMaria.institutoapp.model.Alumnos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaAlumnosAdapter extends RecyclerView.Adapter<ListaAlumnosAdapter.ViewHolder> implements View.OnClickListener{

    private List<Alumnos> dataset;
    private Context context;
    private View.OnClickListener listener;

    public ListaAlumnosAdapter(Context context, List<Alumnos> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    public ListaAlumnosAdapter(){
        dataset = new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumnos_lista, parent, false);
        view.setOnClickListener(this);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Alumnos p = dataset.get(position);
        holder.dniAlumno.setText(p.getDni());
        holder.nombreAlumno.setText(p.getNombre());
        holder.apellidosAlumno.setText(p.getApellidos());
        holder.nacimientoAlumno.setText(sdf.format(new Date(p.getFechaNacimiento())));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void anadirListaAlumnos(List<Alumnos> listaAlumnos) {
        dataset.addAll(listaAlumnos);
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView dniAlumno;
        private TextView nombreAlumno;
        private TextView apellidosAlumno;
        private TextView nacimientoAlumno;

        public ViewHolder(View itemView) {
            super(itemView);

            dniAlumno = itemView.findViewById(R.id.dni_alumno);
            nombreAlumno = itemView.findViewById(R.id.nombre_alumno);
            apellidosAlumno = itemView.findViewById(R.id.apellidos_alumno);
            nacimientoAlumno = itemView.findViewById(R.id.nacimiento_alumno);
        }


    }
}
