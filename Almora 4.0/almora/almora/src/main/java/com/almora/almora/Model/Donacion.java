package com.almora.almora.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "donaciones")
public class Donacion {
    @Id
    private String id;
    private String usuarioId; // ID del donante que realiza la acción
    private String fechaDonacion;
    private List<String> productos; // Lista de strings (ej: ["Arroz - 5kg"])

    public Donacion() {
    }

    public Donacion(String id, String usuarioId, String fechaDonacion, List<String> productos) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaDonacion = fechaDonacion;
        this.productos = productos;
    }

    // Getters y Setters (Mantén los que ya tienes)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(String fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }
}