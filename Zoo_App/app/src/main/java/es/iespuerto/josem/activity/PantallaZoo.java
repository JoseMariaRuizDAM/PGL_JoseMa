package es.iespuerto.josem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import es.iespuerto.josem.R;
import es.iespuerto.josem.activity.layer.ZooFragment;

public class PantallaZoo extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_pantalla_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void cambioPantallaCrearZoo(View view) {
        Intent PantallaCrear = new Intent(this,
                PantallaZooCrear.class);
        startActivity(PantallaCrear);
    }
    public void cambioPantallaModificarZoo(View view) {
        Intent PantallaModificar = new Intent(this,
                PantallaZooCrear.class);
        startActivity(PantallaModificar);
    }
    public void cambioPantallaPrincipal(View view) {
        Intent PantallaPrincipal = new Intent(this,
                MainActivity.class);
        startActivity(PantallaPrincipal);
    }


}
