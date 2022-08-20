package com.example.pagatodo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;


public class IniciarSesionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
    }
    public void  irSaldo(View view){
        Intent i = new Intent(this,ActivitySaldo.class);
        startActivity(i);
    }
}
