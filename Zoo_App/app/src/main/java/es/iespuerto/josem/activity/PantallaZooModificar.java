package es.iespuerto.josem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.iespuerto.josem.R;

public class PantallaZooModificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_pantalla_modificar);
    }

    public void volverPantallaZoo(View view) {
        Intent PantallaZoo = new Intent(this,
                PantallaZoo.class);
        startActivity(PantallaZoo);
    }
}
