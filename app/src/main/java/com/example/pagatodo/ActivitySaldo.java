package com.example.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ActivitySaldo extends AppCompatActivity {
    TextView fecha;
    Spinner options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);
        options =findViewById(R.id.spinnerId);
        ArrayList<String> services =new ArrayList<>();
        services.add("CENS");
        services.add("AGUAS KAPITAL");
        services.add("VEOLIA");
        services.add("DIRECTV");
        services.add("CANAL EXITO");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,services);
        options.setAdapter(adapter);
    }
    public void  irPagos(View view){
        Intent i = new Intent(this,ActivityPagos.class);
        startActivity(i);

    }public void  irRecargar(View view){
        Intent i = new Intent(this,ActivityRecargar.class);
        startActivity(i);

    }


}