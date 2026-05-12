package com.almora.almora.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios") // Es mejor usar la misma colección y filtrar por 'rol'
public class Donante extends Usuario {

    public Donante() {
        super();
    }

    public Donante(String idUsuario, String nombre, String correo, String password, String rol, String telefono) {
        // Llama al constructor de Usuario para asignar todos los campos
        super(idUsuario, nombre, correo, password, rol, telefono);
    }
}