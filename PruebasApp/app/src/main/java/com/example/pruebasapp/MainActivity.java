package com.example.pruebasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txtGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGuardar = findViewById(R.id.txtGuardar);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null) {
            String datos = parametros.getString("datos");
            txtGuardar.setText(datos);
        }

        Intent i = new Intent(this, Mostrartxt.class);
        i.putExtras(parametros);
        startActivity(i);
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

    private boolean exist(String[] archivos, String archivo){
        for(int i = 0; i < archivos.length; i++){
            if(archivo.equals(archivos[i])) {
                return true;
            }
        }
        return false;
    }

    public void escribirArchivo(View view){


        //String guardartxt =
       /* try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE));
            archivo.write(txtGuardar.getText().toString());
            archivo.flush();
            archivo.close();
        } catch(IOException e){

        }
        Toast t = Toast.makeText(this, "Los datos fueron grabados",Toast.LENGTH_SHORT);
        t.show();
        finish();*/
    }

    public void Siguiente(View view){

        setContentView(R.layout.activity_nuevo);
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