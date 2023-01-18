package com.josemaria.menubanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etId = null;
    EditText etNombre = null;
    EditText etPrecio = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = findViewById(R.id.IdEditText);
        etNombre = findViewById(R.id.nombreProductoEdittxt);
        etPrecio = findViewById(R.id.precioEditText);
    }

    public void insertar(View view){
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        String id = etId.getText().toString();
        String nombre= etNombre.getText().toString();
        String precio = etPrecio.getText().toString();

        if(!id.isEmpty() && !nombre.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("idProducto", id);
            registro.put("nombre", nombre);
            registro.put("precio", precio);

            bd.insert("productos", null, registro);
            bd.close();
            etId.setText("");
            etNombre.setText("");
            etPrecio.setText("");
            Toast.makeText(this, "Se ha guardado los datos correctamente",Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, "Debes de completar todos los campos",Toast.LENGTH_LONG).show();
        }
    }

    public void buscar(View view){
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        String id = etId.getText().toString();


        if(!id.isEmpty()){
            Cursor fila = bd.rawQuery("SELECT descripcion, precio FROM productos WHERE codigo= " + id
                    , null);
            if(fila.moveToFirst()==true){
                etNombre.setText(fila.getString(1));
                etPrecio.setText(fila.getString(2));
                bd.close();
            } else{
                etNombre.setText("");
                etPrecio.setText("");
                bd.close();
                Toast.makeText(this, "No se han encontrado ningún producto con ese ID en la base de datos"
                        ,Toast.LENGTH_LONG).show();
            }
        }

    }

    public void eliminar(View view){


    }
}