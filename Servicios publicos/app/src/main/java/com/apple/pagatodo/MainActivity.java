package com.apple.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.apple.pagatodo.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static ArrayList<Persona> Personas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        irIniciar();
        irRegistrar();
    }

    public void irIniciar() {
        binding.iniciarSesionPant.setOnClickListener(view -> {
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);
        });
    }
    public void irRegistrar() {
        binding.RegistrarPantalla.setOnClickListener(view ->  {
                Intent i = new Intent(this, RegistrarseActivity.class);
                startActivity(i);
        });
    }
}
