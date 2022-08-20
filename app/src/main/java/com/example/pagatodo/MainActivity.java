package com.example.pagatodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText cedulaIniciar;
    EditText contraIni;
    EditText saldoIni;
    TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //fecha=findViewById(R.id.saldoHora);
        //fecha.setText(obtfecha());
    }

    public void irIniciar(View view) {
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);
    }

    public void irRegistrar(View view) {
        Intent i = new Intent(this, Registrarse.class);
        startActivity(i);
    }

    private void init() {
        cedulaIniciar = findViewById(R.id.cedulaIniciar);
        contraIni = findViewById(R.id.passwordIniciar);
        saldoIni=findViewById(R.id.recargarEdit);
    }
    public CharSequence obtfecha(){
        CharSequence time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        return time;
    }
}
class listasPersonas{
    private String cedula;
    private String contras;
    private Integer saldo;
    private final ArrayList<String> listCedulas;
    private final ArrayList<String> listContras;
    private ArrayList<Integer> listSaldo;

    public listasPersonas(String cedulaList, String passList, Integer saldoList, ArrayList<Integer> listSaldo) {
        this.cedula = cedulaList;
        this.contras=passList;
        this.saldo=saldoList;
        this.listSaldo = listSaldo;
        listCedulas= new ArrayList<>();
        listContras= new ArrayList<>();
    }
    public void addUsers(String cedulas,String passwords){
        listCedulas.add(cedulas);
        listContras.add(passwords);
    }
    public void addRecargar(Integer saldos){
        listSaldo.add(saldos);
    }
    public int compararUsers(String cedulas,String passwords){
        Boolean vali1=listCedulas.contains(cedulas);
        Boolean vali2=listContras.contains(passwords);
        if (vali1 && vali2){
            return 1;
        }
        return 0;
    }
    public int numeroUser(String cedulas){
        return listCedulas.indexOf(cedulas);
    }




}