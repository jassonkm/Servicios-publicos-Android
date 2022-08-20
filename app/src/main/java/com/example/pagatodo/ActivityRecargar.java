package com.example.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityRecargar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recargar);
    }
    public void irPagos(View view){
        Intent i = new Intent(this, ActivityPagos.class);
        startActivity(i);
    }
}