package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Producto;
import ar.edu.unju.escmi.tp5.dominio.Stock;

public class CollectionProducto {
    public static List<Producto> productos = new ArrayList<>();

    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public static Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigoP() == codigo) return p;
        }
        return null;
    }

  
    public static void precargarProductos() {
        cargar(new Producto(1001, "Fideo Knorr Spaghetti x 500 gr", 1200.00, 0), 5000);
        cargar(new Producto(1002, "Arroz Gallo Oro x 1 kg", 1500.00, 25), 3000);
        cargar(new Producto(1003, "Aceite Cocinero x 900 ml", 2500.00, 30), 2000);
        cargar(new Producto(1004, "Yerba Taragui x 1 kg", 3200.00, 0), 1500);
    }

    private static void cargar(Producto producto, int stock) {
        agregarProducto(producto);
        CollectionStock.agregarStock(new Stock(producto, stock));
    }
}