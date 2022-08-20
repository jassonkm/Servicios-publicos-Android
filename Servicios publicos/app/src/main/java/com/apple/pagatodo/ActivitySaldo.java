package com.apple.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;



import com.apple.pagatodo.databinding.ActivitySaldoBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivitySaldo extends AppCompatActivity {
    private ActivitySaldoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySaldoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        irPagos();
        irRecargar();
        ArrayList<Persona> personas = MainActivity.Personas;
        int posicion = recibirPos();
        String saldo = String.valueOf(personas.get(posicion).getSaldo());
        binding.PagoUser.setText(personas.get(posicion).getNombre());
        binding.PagoSaldo.setText(saldo);
        binding.saldoHora.setText(obtfecha());

    }

    public void  irPagos(){
        binding.btnPagoRealizar.setOnClickListener(view ->{
                Intent i = new Intent(this, ActivityPagos.class);
                i.putExtra("position",recibirPos());
                startActivity(i);
    });
    }
    private int recibirPos(){
        Bundle extras=getIntent().getExtras();
        return extras.getInt("position");
    }
    public void  irRecargar() {
        binding.btnSaldoRecarg.setOnClickListener(view -> {
            Intent i = new Intent(this, ActivityRecargar.class);
            i.putExtra("position",recibirPos());
            startActivity(i);

        });
    }
    public String obtfecha(){
        return new SimpleDateFormat("yyyy/MM/dd H:mm:ss").format(Calendar.getInstance().getTime());
    }
}