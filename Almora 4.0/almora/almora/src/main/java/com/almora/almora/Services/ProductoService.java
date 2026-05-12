package com.almora.almora.Services;

import com.almora.almora.Model.Producto;
import java.util.List;

public interface ProductoService {
    Producto agregarProducto(Producto producto);

    List<Producto> listarProductos();

    Producto buscarPorNombre(String nombreProducto);

    boolean actualizarCantidad(String nombreProducto, int nuevaCantidad);

    boolean eliminarProducto(String id); // Cambié Long → String

    Producto obtenerPorId(String id); // Cambié Long → String

    Producto actualizarProducto(String id, Producto productoActualizado); // Cambié Long → String
}
