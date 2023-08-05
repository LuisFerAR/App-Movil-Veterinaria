package com.example.veterinaria_movil.clases;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {

    private int idCliente;
    private String nombre;
    private String dni;
    private String celular;
    private String correo;
    private String clave;

    public Cliente() {

    }

    public Cliente(int idCliente, String nombre, String dni, String celular, String correo, String clave){
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
        this.clave = clave;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
