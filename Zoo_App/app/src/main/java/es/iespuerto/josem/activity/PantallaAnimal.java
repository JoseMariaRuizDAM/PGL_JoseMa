package es.iespuerto.josem.activity;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaAnimal extends AppCompatActivity {

    public void cambioPantallaPrincipal(View view) {
        Intent PantallaPrincipal = new Intent(this,
                MainActivity.class);
        startActivity(PantallaPrincipal);
    }

    public void irPantallaZoo(View view) {
        Intent PantallaZoo = new Intent(this,
                PantallaZoo.class);
        startActivity(PantallaZoo);
    }
}
