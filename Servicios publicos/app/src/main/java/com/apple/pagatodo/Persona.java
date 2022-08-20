package com.apple.pagatodo;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String cedula;
    private String contras;
    private Integer saldo;




    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContras() {
        return contras;
    }

    public void setContras(String contras) {
        this.contras = contras;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombres) {
        this.nombre = nombres;
    }


}
