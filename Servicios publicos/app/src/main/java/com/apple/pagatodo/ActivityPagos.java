package com.apple.pagatodo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.apple.pagatodo.databinding.ActivityPagosBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityPagos extends AppCompatActivity {
    ActivityPagosBinding binding;
    private Integer pagoCant;
    private Integer saldof;
    private String factura;
    private String pagar;
    private ArrayList<Persona> people;
    private String newsaldo;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPagosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        spinnerView();
        binding.textHoraSalid.setText(obtfecha());
        pagarM();
    }

    public void pagarM() {
        binding.btnPagar.setOnClickListener(view -> {
            pagar = binding.textPagosPago.getText().toString();
            factura=binding.TextFactura.getText().toString();
            pagoCant = Integer.valueOf(pagar);
            people = MainActivity.Personas;
            pos = recibirPos();
            saldof = people.get(pos).getSaldo() - pagoCant;
            newsaldo = saldof.toString();
            if (saldof < 0) {
                Toast.makeText(this, "Saldo insuficiente, por favor recargue", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, ActivityRecargar.class);
                startActivity(i);
            } else if (pagar.equals("")) {
                Toast.makeText(this, "Por favor ingresar datos", Toast.LENGTH_SHORT).show();
                binding.textPagosPago.requestFocus();
            }else if (factura.length()<10){
                Toast.makeText(this, "Ingrese un numero de factura valido ", Toast.LENGTH_SHORT).show();
                binding.TextFactura.requestFocus();
            }
            else if (pagoCant<1000){
                Toast.makeText(this, "Ingrese una cantidad mayor a 1000 ", Toast.LENGTH_SHORT).show();
                binding.textPagosPago.requestFocus();
            }
            else {
                people.get(pos).setSaldo(Integer.parseInt(newsaldo));
                dialogoSaldo().show();

            }
        });
    }
    private int recibirPos(){
        Bundle extras=getIntent().getExtras();
        return extras.getInt("position");
    }

    private AlertDialog.Builder dialogoSaldo() {
     return  new AlertDialog
                .Builder(this)
                .setTitle("Transaccion finalizada").
                setMessage("Pago completado satisfactoriamente").setMessage("Saldo restante "+people.get(pos).getSaldo())
                .setPositiveButton(R.string.not, (dialogInterface, i) -> salir());
    }



    public void salir(){
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void spinnerView(){
        ArrayList<String> services =new ArrayList<>();
        services.add("CENS");
        services.add("AGUAS KAPITAL");
        services.add("VEOLIA");
        services.add("DIRECTV");
        services.add("CANAL EXITO");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,services);
        binding.spinnerId.setAdapter(adapter);

    }
    public String obtfecha(){
        return new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime());
    }


}