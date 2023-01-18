package com.josemaria.basedatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StockActivity extends AppCompatActivity {

    EditText etStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_editar);

        etStock = findViewById(R.id.etStockEditar);
        //Añade el stock que recoge de la ventana del main
        etStock.setText(getIntent().getStringExtra("stock"));
    }

    /**
     * Accion que se ejecuta cuando se presiona el boton modificar stock
     *Hara un cambio en la base de datos donde cambiara el stock del producto
     * según el codigo que tenga
     */
    public void modificarStock(View view){

        //Hace una conexion a la base de datos
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        //Recoge el codigo de la pantalla anterior para poder hacer la consulta a la DDBB
        int codigo = Integer.parseInt(getIntent().getStringExtra("codigo"));
        //Recoge el stock que ha introducido el usuario
        int stock = Integer.parseInt(etStock.getText().toString());
        //Comienza a añadir los valores en la base de datos
        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);
        registro.put("stock", stock);

        //Actualiza la base de datos con los cambios que ha recogido
        int cant = bd.update("productos",
                registro,"codigo='" + codigo + "'",null);
            if(cant > 0){
                Toast.makeText(this, "El stock del producto se ha editado correctamente", Toast.LENGTH_LONG).show();
                //Comienzo con el salto de ventana al Main con todos los cambios realizados.
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "El stock del producto NO se ha editado correctamente", Toast.LENGTH_LONG).show();
            }
        //Cierra la conexion a base de datos
        bd.close();
    }
}
