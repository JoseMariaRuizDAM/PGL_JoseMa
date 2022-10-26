package com.example.pruebasapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Mostrartxt extends AppCompatActivity {

    private TextInputEditText escribirVentana;
    private TextView mostrarTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrartxt);

        escribirVentana= findViewById(R.id.escribirVentana);
        mostrarTxt = findViewById(R.id.txtMostrar);

        String datos = getIntent().getExtras().getString("datos");
        mostrarTxt.setText(datos);
        /*Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null) {
            String datos = parametros.getString("datos");
            escribirVentana.setText(datos);
        }*/
/*
        Intent i = new Intent(this, MainActivity.class);
        i.putExtras(parametros);
        startActivity(i);*/
        /*
        String[] archivos = fileList();

        if(exist (archivos, "notas.txt")){
            try{
                FileWriter archivo = new FileWriter(getFileStreamPath("notas.txt"), true);
                archivo.write(String.valueOf(txtGuardar));
                archivo.close();

            }catch(IOException e){
                e.getMessage();
            }
        }*/
    }
}
