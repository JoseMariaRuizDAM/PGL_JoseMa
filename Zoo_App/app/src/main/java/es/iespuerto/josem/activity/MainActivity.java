package es.iespuerto.josem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import es.iespuerto.josem.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irPantallaZoo(View view) {
        Intent PantallaZoo = new Intent(this,
                PantallaZoo.class);
        startActivity(PantallaZoo);
    }
    public void irPantallaAnimal(View view) {
        Intent PantallaAnimal = new Intent(this,
                PantallaAnimal.class);
        startActivity(PantallaAnimal);
    }
    public void irPantallaEspecie(View view) {
        Intent PantallaEspecie = new Intent(this,
                PantallaEspecie.class);
        startActivity(PantallaEspecie);
    }


}