package com.josemaria.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCodigo;
    EditText etDescripcion;
    EditText etPrecio;
    EditText etStock;
    TableLayout tlProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCodigo = findViewById(R.id.IdEditText);
        etDescripcion = findViewById(R.id.nombreProductoEdittxt);
        etPrecio = findViewById(R.id.precioEditText);
        etStock = findViewById(R.id.stockEditText);
        tlProductos = findViewById(R.id.tlProducto);

        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        Cursor total = bd.rawQuery("SELECT * FROM productos", null);
        if(total.moveToFirst()){
            llenarTabla();
        }
        try{

        }catch(Exception e){
            con.onCreate(bd);
        }

    }

    //Añadir que si esta el codigo en la base de datos como no se creara el producto hay que mandar un mensaje al usuario
    public void insertar(View view){
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();

        //con.eliminarTabla(bd);
        if(!etCodigo.getText().toString().isEmpty() && !etPrecio.getText().toString().isEmpty()){
            int codigo = Integer.parseInt(etCodigo.getText().toString());
            String descripcion = etDescripcion.getText().toString();
            double precio = Double.parseDouble(etPrecio.getText().toString());
            int stock = Integer.parseInt(etStock.getText().toString());

            if (codigo > 0 && !descripcion.isEmpty() && precio > 0.00){
                ContentValues registro = new ContentValues();
                registro.put("codigo", codigo);
                registro.put("descripcion", descripcion);
                registro.put("precio", precio);
                registro.put("stock", stock);
                bd.insert("productos", null, registro);

                etCodigo.setText("");
                etDescripcion.setText("");
                etPrecio.setText("");
                etStock.setText("");
                Toast.makeText(this, "Se ha guardado los datos correctamente",Toast.LENGTH_LONG).show();
            }

        } else{
            Toast.makeText(this, "Debes de completar todos los campos",Toast.LENGTH_LONG).show();
        }
        bd.close();
        llenarTabla();
    }

    /**
     * Metodo que busca por el codigo que añamos puesto en el EditText
     * busca el codigo en la DDBB y añade los datos en los edittext
     * @param view
     */
    public void buscar(View view){
        //conectamos con la base de datos
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        //recoger
        int codigo = Integer.parseInt(etCodigo.getText().toString());

        if(codigo > 0){
            Cursor fila = bd.rawQuery("SELECT descripcion, precio, stock FROM productos WHERE codigo= " + codigo
                    , null);
            if(fila.moveToFirst()==true){
                etDescripcion.setText(fila.getString(0));
                etPrecio.setText(fila.getString(1));
                etStock.setText(fila.getString(2));
                bd.close();
            } else{
                etDescripcion.setText("");
                etPrecio.setText("");
                etStock.setText("");
                bd.close();
                Toast.makeText(this, "No se han encontrado ningún producto con ese ID en la base de datos"
                        ,Toast.LENGTH_LONG).show();
            }
        }
        llenarTabla();
    }

    /**
     * Metodo que elimina un dato de la ddbb
     * Recogera el dato que le añamos puesto el codigo en el EditText
     * @param view
     */
    public void eliminar(View view){
        //conectamos con la base de datos
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
          etStock.setText("");
        } else {
        Toast.makeText(this, "El campo codigo no puede estar vacio", Toast.LENGTH_LONG).show();
        }
        bd.close();
        llenarTabla();
    }

    /**
     * Metodo que edita los datos en la DDBB que se recogen en los edittext
     * @param view
     */
    public void editar(View view){
        //conectamos con la base de datos
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
        bd.close();
        llenarTabla();
    }

    /**
     * Funcion que se usa para rellenar la tabla con los datos de la DDBB
     */
    public void llenarTabla(){
        tlProductos.removeAllViews(); //Elimina los datos anteriores si los hubiera
        //Comienza la conexion a la DDBB
        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();
        //Consulta sql a la base de datos para recoger todos los datos de la tabla productos
        Cursor fila = bd.rawQuery("SELECT * from productos",null);
        fila.moveToFirst(); //El puntero se pone en la primera fila

        do{
            View registro = LayoutInflater.from(this).inflate(R.layout.item_table_layout_pr, null, false);

            //Instancia las variables con las posiciones de la tabla
            TextView tvCodigo = registro.findViewById(R.id.tvCodigo);
            TextView tvDescripcion = registro.findViewById(R.id.tvDescripcion);
            TextView tvPrecio = registro.findViewById(R.id.tvPrecio);
            TextView tvStock = registro.findViewById(R.id.tvStock);

            //Añade los datos a la tabla
            tvCodigo.setText(fila.getString(0));
            tvDescripcion.setText(fila.getString(1));
            tvPrecio.setText(fila.getString(2));
            tvStock.setText(fila.getString(3));
            tlProductos.addView(registro);

        }while(fila.moveToNext()); //Condicional que cambia de fila en la tabla productos
    }


//Funcion que hara que cuando presiones en un producto en la tabla, aparezca los datos en los campos
    public void clickRegistroProducto(View view){
        resetColorRegistros(); //Cambia el color d ela tabla a blanco
        view.setBackgroundColor(Color.GRAY); //Añade gris a la posicion de la tabla presionado
        TableRow registro = (TableRow) view;
        TextView controlCodigo =(TextView) registro.getChildAt(0);
        String codigo = controlCodigo.getText().toString();

        SQLite con = new SQLite(this, "tienda",null,1);
        SQLiteDatabase bd = con.getWritableDatabase();

        if(!codigo.isEmpty()){
            Cursor fila = bd.rawQuery("SELECT codigo, descripcion, precio, stock from productos where codigo= "
                    + codigo,null);
            //Recoge los datos de la base de datos y los envia a los edittext
            if(fila.moveToFirst()){
                etCodigo.setText(fila.getString(0));
                etDescripcion.setText(fila.getString(1));
                etPrecio.setText(fila.getString(2));
                etStock.setText(fila.getString(3));
            }else{
                etCodigo.setText("");
                etDescripcion.setText("");
                etPrecio.setText("");
                etStock.setText("");
                Toast.makeText(this, "No se han encontrado los registros", Toast.LENGTH_LONG).show();
            }
        }
    }
    /**
     * Metodo para cambiar el color de los registros
     * Volveran a color blanco cuando no esten seleccionados
     */

    public void resetColorRegistros(){
        for(int i= 0; i < tlProductos.getChildCount(); i++){
            tlProductos.getChildAt(i).setBackgroundColor(Color.WHITE);
        }
    }

    /**
     * Metodo para cambiar de pantalla recogiendo los datos de stock
     * del producto seleccionado en la tabla
     * @param view
     */

    public void pasarPantallaStock(View view){
        //Recoge los datos de los edittext que se encuentran en el Main
        String stockModi = etStock.getText().toString();
        String codigoModi = etCodigo.getText().toString();
        //Comienzo con el salto de ventana
        Intent intent = new Intent(this, StockActivity.class);
        intent.putExtra("stock", stockModi); //Añade los datos de stock en el intent
        intent.putExtra("codigo",codigoModi);//Añade los datos de codigo en el intent
        startActivity(intent);
    }
}