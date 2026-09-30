package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int nroF;
    private LocalDate fecha;
    private double total;
    private Cliente cliente;
    private List<DetalleFactura> detalles;

    public Factura(int nroF, LocalDate fecha, Cliente cliente) {
        this.nroF = nroF;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public int getNroF() { return nroF; }
    public LocalDate getFecha() { return fecha; }
    public double getTotal() { return total; }
    public Cliente getCliente() { return cliente; }
    public List<DetalleFactura> getDetalles() { return detalles; }

    public void agregarDetalle(DetalleFactura d) {
        detalles.add(d);
    }

    public double calcularPrecioTotal() {
        double subtotal = 0;
        for (DetalleFactura d : detalles) {
            subtotal += d.getImporte();
        }
        total = cliente.calcularTotal(subtotal);
        return total;
    }

    public void mostrarFactura() {
        System.out.println("=======================================");
        System.out.println("FACTURA Nro. " + nroF + "   Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.getApellido() + ", " + cliente.getNombre());
        System.out.println("Direccion: " + cliente.getDireccion());
        System.out.println("---------------------------------------");
        System.out.printf("%-8s %-35s %12s %12s%n", "Cant.", "Detalle", "P. Unit.", "Importe");
        for (DetalleFactura d : detalles) {
            System.out.printf("%-8d %-35s %12.2f %12.2f%n", d.getCantidad(),
                    d.getProducto().getDescripcion(), d.getPrecioUnitario(), d.getImporte());
        }
        
        System.out.println("---------------------------------------");
        System.out.printf("TOTAL: $ %.2f%n", total);
        System.out.println("=======================================");
    }
}
