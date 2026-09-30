package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

public class AgenteVentas extends Empleado {

    public AgenteVentas(int dni, String nombre, String apellido, String direccion) {
        super(dni, nombre, apellido, direccion);
    }

    public void mostrarVentas() {
        if (CollectionFactura.collection.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Factura f : CollectionFactura.collection) {
            f.mostrarFactura();
        }
    }

    public double mostrarTotalVentas() {
        double suma = 0;
        for (Factura f : CollectionFactura.collection) {
            suma += f.getTotal();
        }
        return suma;
    }

    public int verificarStock(int codigoP) {
        Stock s = CollectionStock.buscarStockPorCodigo(codigoP);
        return (s == null) ? -1 : s.getCantidad();
    }
}
