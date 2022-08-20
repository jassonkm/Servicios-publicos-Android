package com.apple.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.apple.pagatodo.databinding.ActivityIniciarSesionBinding;

import java.util.ArrayList;

public class IniciarSesionActivity extends AppCompatActivity {
    private ActivityIniciarSesionBinding binding;
    private  String id;
    private  String pass;
    private ArrayList<Persona> personas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIniciarSesionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        irSaldo();
    }
    public void  irSaldo(){
        binding.btnLogin.setOnClickListener(view ->{
            id=binding.cedulaIniciar.getText().toString();
            pass=binding.passwordIniciar.getText().toString();
            personas=MainActivity.Personas;
            int pos=buscarP(id);
            Log.d("Pos",String.valueOf(pos));
            if (id.equals("") || pass.equals("")) {
                Toast.makeText(this,"Por favor ingresar datos",Toast.LENGTH_SHORT).show();
                binding.cedulaIniciar.requestFocus();
                binding.passwordIniciar.requestFocus();
            }
            else if (personas.size()==0) {
                Toast.makeText(this,"Ningun usuario registrado, por favor registre uno",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,RegistrarseActivity.class);
                startActivity(i);
            }
            else if (id.equals(personas.get(pos).getCedula()) && pass.equals(personas.get(pos).getContras())){
                Intent i = new Intent(this,ActivitySaldo.class);
                i.putExtra("position",pos);
                startActivity(i);
            }
            else{
                Toast.makeText(this,"Usuario o contraseña incorrectas ",Toast.LENGTH_SHORT).show();
                binding.cedulaIniciar.requestFocus();
                binding.passwordIniciar.requestFocus();
            }
        });
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
}

