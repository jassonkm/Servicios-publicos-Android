package com.apple.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.apple.pagatodo.databinding.ActivityRecargarBinding;



import java.util.ArrayList;

public class ActivityRecargar extends AppCompatActivity {
    ActivityRecargarBinding binding;
    public Persona persona;
    private String newsaldo;
    private String saldo;
    private Integer saldoI;
    private Integer saldoF;
    private ArrayList<Persona> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecargarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        persona = (Persona) getIntent().getSerializableExtra("persona");

        irPagos();
    }
    public void irPagos(){
        binding.btnSistemRecarg.setOnClickListener(view -> {

            saldo=binding.recargarEdit.getText().toString();
            saldoI=Integer.valueOf(saldo);
            people=MainActivity.Personas;
            int pos=recibirPos();
            saldoF=people.get(pos).getSaldo()+saldoI;
            if (saldo.equals("")) {
                Toast.makeText(this,"Por favor ingresar datos",Toast.LENGTH_SHORT).show();
                binding.recargarEdit.requestFocus();
            }
            else if (saldoF<1000) {
                Toast.makeText(this,"Por favor ingresar una cantidad mayor a mil",Toast.LENGTH_SHORT).show();
                binding.recargarEdit.requestFocus();
            }
            else
            {
                newsaldo=saldoF.toString();
                people.get(pos).setSaldo(Integer.parseInt(newsaldo));
                Intent i = new Intent(this, ActivitySaldo.class);
                i.putExtra("position",pos);
                startActivity(i);
            }
        });
    }
    private int recibirPos(){
        Bundle extras=getIntent().getExtras();
        int dl= extras.getInt("position");
        return dl;
    }
}