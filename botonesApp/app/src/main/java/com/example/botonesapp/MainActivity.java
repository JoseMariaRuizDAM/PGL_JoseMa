package com.example.botonesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Siguiente(View view){
        setContentView(R.layout.activity_login);
    }

    public void Salir(View view){

        cerrarAplicacion();

    }



    public void Informacion(View view){

    }

    private void cerrarAplicacion() {
        new AlertDialog.Builder(this)
                //.setIcon(R.drawable.alacran)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {// un listener que al pulsar, cierra la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                        //finish(); Si solo quiere mandar la aplicación a segundo plano
                    }
                }).show();
    }


}