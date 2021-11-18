package es.iespuerto.josem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.iespuerto.josem.R;

public class PantallaEspecie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_pantalla_principal);
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
