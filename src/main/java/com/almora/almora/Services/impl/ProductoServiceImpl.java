package com.almora.almora.Services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.almora.almora.Model.Producto;
import com.almora.almora.Repository.ProductoRepository;
import com.almora.almora.Services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarPorNombre(String nombreProducto) {
        return productoRepository.findByNombreProducto(nombreProducto);
    }

    @Override
    public boolean actualizarCantidad(String nombreProducto, int nuevaCantidad) {
        Producto producto = productoRepository.findByNombreProducto(nombreProducto);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            productoRepository.save(producto);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarProducto(String id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Producto obtenerPorId(String id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto actualizarProducto(String id, Producto productoActualizado) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombreProducto(productoActualizado.getNombreProducto());
            producto.setCantidad(productoActualizado.getCantidad());
            producto.setTipoProducto(productoActualizado.getTipoProducto());
            producto.setFechaCaducidad(productoActualizado.getFechaCaducidad());
            return productoRepository.save(producto);
        }).orElse(null);
    }
}
