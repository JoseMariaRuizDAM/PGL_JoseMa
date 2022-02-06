package com.JoseMaria.institutoapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.JoseMaria.institutoapp.R;

public class MainActivity extends AppCompatActivity {

    /*

    AlumnosService alumnosService;
    ListView listView;
    List<Alumnos> list = new ArrayList<Alumnos>();


     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirAlumno = new Intent(getApplicationContext(), AlumnoActivity.class);
                startActivity(abrirAlumno);
            }
        });
    }

    /*
    public void getAlumnosList(View view){

        Call<List<Alumnos>> call = alumnosService.searchAll();
        call.enqueue(new Callback<List<Alumnos>>() {
            @Override
            public void onResponse(Call<List<Alumnos>> call, Response<List<Alumnos>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    listView.setAdapter(
                            new AlumnosAdapter(MainActivity.this,
                                    R.layout.alumnos_activity, list));
                }
            }

            @Override
            public void onFailure(Call<List<Alumnos>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
*/
}