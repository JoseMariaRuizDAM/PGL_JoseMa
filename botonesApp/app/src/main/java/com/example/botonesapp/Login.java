package com.example.botonesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button login = (Button) findViewById(R.id.btnLogin);
    EditText usuario;
    EditText password;
    String getUsuario;
    String getPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.txtUsuario);
        password = (EditText) findViewById(R.id.txtPassword);
    }

    public void doLogin(View view){
        getUsuario = usuario.getText().toString();
        getPass = password.getText().toString();


        Toast.makeText(getApplicationContext(),"Has entrado",Toast.LENGTH_SHORT).show();
    }

    public void volver(View view)
    {
        setContentView(R.layout.activity_main);
    }
}
