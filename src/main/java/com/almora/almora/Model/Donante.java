package com.almora.almora.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "donantes")
public class Donante extends Usuario {

    private String telefono;

    public Donante() {
        super();
    }

    public Donante(String idUsuario, String nombre, String correo, String password, String rol, String telefono) {
        super(idUsuario, nombre, correo, password, rol);
        this.telefono = telefono;
    }

    // GETTERS & SETTERS
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
