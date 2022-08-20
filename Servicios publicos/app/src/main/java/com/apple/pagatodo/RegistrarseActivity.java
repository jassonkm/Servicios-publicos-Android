package com.apple.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.apple.pagatodo.databinding.ActivityRegistrarseBinding;

import java.util.ArrayList;


public class RegistrarseActivity extends AppCompatActivity {
    ActivityRegistrarseBinding binding;
    private String name;
    private String id;
    private String pass;
    private Integer saldo;
    private ArrayList<Persona> personas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistrarseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        personas=MainActivity.Personas;
        binding.btnRegistrar.setOnClickListener(view -> verficarId());
    }
    public void irLogin(){
            name=binding.NameConf.getText().toString();
            id=binding.cedConfi.getText().toString();
            pass=binding.passConfi.getText().toString();
            if (name.equals("") || id.equals("") || pass.equals("")) {
                Toast.makeText(this,"Por favor ingresar datos",Toast.LENGTH_SHORT).show();
                binding.NameConf.requestFocus();
                binding.cedConfi.requestFocus();
                binding.passConfi.requestFocus();
            }

            else if (id.length()!=10) {
                Toast.makeText(this,"Por favor ingresar cedula correcta",Toast.LENGTH_SHORT).show();
                binding.NameConf.requestFocus();
            }
            else
            {
                Persona persona = new Persona();
                persona.setNombre(name);
                persona.setCedula(id);
                persona.setContras(pass);
                saldo=0;
                persona.setSaldo(saldo);
                MainActivity.Personas.add(persona);
                Intent intent = new Intent(this, IniciarSesionActivity.class);
                intent.putExtra("persona",persona);
                startActivity(intent);
            }
    }
    private int buscarP(String id) {
        int pos = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCedula().equals(id)) {
                pos=i;
                break;
            }
        }
        return pos;
    }
    private void verficarId(){
        if (personas.size() != 0) {
            id=binding.cedConfi.getText().toString();
            int pos=buscarP(id);
            if (id.equals(personas.get(pos).getCedula())){
                Toast.makeText(this,"Usuario Registrado, por favor inicie sesion",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, IniciarSesionActivity.class);
                startActivity(intent);
            }
            else{
                irLogin();
            }
        }
        else {
            irLogin();
        }

    }
}