package ar.edu.unju.escmi.tp5.dominio;

import ar.edu.unju.escmi.tp5.collections.CollectionFactura;

public abstract class Cliente extends Persona {

    public Cliente(int dni, String nombre, String apellido, String direccion) {
        super(dni, nombre, apellido, direccion);
    }

    public abstract int calcularUnidades(int cantidad);
    public abstract double calcularPrecioUnitario(double precio);
    public abstract double calcularTotal(double subtotal);

    public Factura buscarFactura(int nroF) {
        Factura f = CollectionFactura.buscarFactura(nroF);
        if (f != null && f.getCliente() == this) {
            return f;
        }
        return null;
    }
}