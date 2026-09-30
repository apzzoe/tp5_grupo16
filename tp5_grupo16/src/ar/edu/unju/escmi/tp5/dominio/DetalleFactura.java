package ar.edu.unju.escmi.tp5.dominio;

public class DetalleFactura {
    private int cantidad; // en unidades
    private Producto producto;
    private double precioUnitario;
    private double importe;

    public DetalleFactura(int cantidad, Producto producto, double precioUnitario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.importe = calcularImporte();
    }

    public int getCantidad() { return cantidad; }
    public Producto getProducto() { return producto; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getImporte() { return importe; }

    public double calcularImporte() {
        return cantidad * precioUnitario;
    }
}