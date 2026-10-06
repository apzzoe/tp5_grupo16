package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

public class EncargadoDeVentas extends Empleado {

    public EncargadoDeVentas(int dni, String nombre, String apellido, String direccion) {
        super(dni, nombre, apellido, direccion);
    }

    public void mostrarVentas() {
        if (CollectionFactura.facturas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Factura f : CollectionFactura.facturas) {
            f.mostrarFactura();
        }
    }

    public double mostrarTotalVentas() {
        double suma = 0;
        for (Factura f : CollectionFactura.facturas) {
            suma += f.getTotal();
        }
        return suma;
    }

    public int verificarStock(int codigoP) {
        Stock s = CollectionStock.buscarStock(codigoP);
        return (s == null) ? -1 : s.getCantidad();
    }
}
