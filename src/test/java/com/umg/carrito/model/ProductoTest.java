package com.umg.carrito.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void testGettersAndSetters() {
        Producto producto = new Producto();
        producto.setIdProducto(1L);
        producto.setCodigo("MON01");
        producto.setNombre("Monitor Gamer");
        producto.setPrecio(new BigDecimal("1850.00"));
        producto.setImagen("https://imagen.com/mon.jpg");

        assertEquals(1L, producto.getIdProducto());
        assertEquals("MON01", producto.getCodigo());
        assertEquals("Monitor Gamer", producto.getNombre());
        assertEquals(new BigDecimal("1850.00"), producto.getPrecio());
        assertEquals("https://imagen.com/mon.jpg", producto.getImagen());
    }

    @Test
    void testConstructorParametrizado() {
        Producto producto = new Producto(2L, "TECL01", "Teclado", new BigDecimal("350.00"), "img.jpg");

        assertNotNull(producto);
        assertEquals(2L, producto.getIdProducto());
        assertEquals("TECL01", producto.getCodigo());
    }
}
