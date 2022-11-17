package com.josemaria.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCodigo;
    EditText etDescripcion;
    EditText etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCodigo = findViewById(R.id.IdEditText);
        etDescripcion = findViewById(R.id.nombreProductoEdittxt);
        etPrecio = findViewById(R.id.precioEditText);
    }

    public void insertar(View view){
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();

        if(!etCodigo.getText().toString().isEmpty() && !etPrecio.getText().toString().isEmpty()){
            int codigo = Integer.parseInt(etCodigo.getText().toString());
            String descripcion = etDescripcion.getText().toString();
            double precio = Double.parseDouble(etPrecio.getText().toString());
            if (codigo > 0 && !descripcion.isEmpty() && precio > 0.00){
                ContentValues registro = new ContentValues();
                registro.put("codigo", codigo);
                registro.put("descripcion", descripcion);
                registro.put("precio", precio);
                bd.insert("productos", null, registro);

                etCodigo.setText("");
                etDescripcion.setText("");
                etPrecio.setText("");
                Toast.makeText(this, "Se ha guardado los datos correctamente",Toast.LENGTH_LONG).show();
            }

        } else{
            Toast.makeText(this, "Debes de completar todos los campos",Toast.LENGTH_LONG).show();
        }
        bd.close();
    }

    public void buscar(View view){
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        int codigo = Integer.parseInt(etCodigo.getText().toString());


        if(codigo > 0){
            Cursor fila = bd.rawQuery("SELECT descripcion, precio FROM productos WHERE codigo= " + codigo
                    , null);
            if(fila.moveToFirst()==true){
                etDescripcion.setText(fila.getString(0));
                etPrecio.setText(fila.getString(1));
                bd.close();
            } else{
                etDescripcion.setText("");
                etPrecio.setText("");
                bd.close();
                Toast.makeText(this, "No se han encontrado ningún producto con ese ID en la base de datos"
                        ,Toast.LENGTH_LONG).show();
            }
        }

    }

    public void eliminar(View view){
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        int codigo = Integer.parseInt(etCodigo.getText().toString());
        if(codigo > 0){
          int cant = bd.delete("productos","codigo='" + codigo + "'", null);

          if(cant > 0){
              Toast.makeText(this, "Se ha eliminado el producto con codigo: " + codigo +" en la base de datos"
                      ,Toast.LENGTH_LONG).show();
          } else{
              Toast.makeText(this, "No se ha podido eliminar el producto con codigo: " + codigo + " en la base de datos"
                      ,Toast.LENGTH_LONG).show();
          }
          etCodigo.setText("");
          etDescripcion.setText("");
          etPrecio.setText("");
        } else {
        Toast.makeText(this, "El campo codigo no puede estar vacio", Toast.LENGTH_LONG).show();
        }
    }

    public void editar(View view){
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        int codigo = Integer.parseInt(etCodigo.getText().toString());
        String descripcion = etDescripcion.getText().toString();
        double precio = Double.parseDouble(etPrecio.getText().toString());

        if (codigo > 0 && !descripcion.isEmpty() && precio > 0.00){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cant = bd.update("productos",
                    registro,"codigo='" + codigo + "'",null);
            if(cant > 0){
                Toast.makeText(this, "El producto se ha editado correctamente", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "El producto NO se ha editado correctamente", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "No has introducido todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}