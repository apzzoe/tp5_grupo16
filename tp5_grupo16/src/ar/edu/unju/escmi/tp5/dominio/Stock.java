package ar.edu.unju.escmi.tp5.dominio;

public class Stock {
    private Producto producto;
    private int cantidad;

    public Stock(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    public void actualizarStock(int cantidad) {
        this.cantidad -= cantidad;
    }

    public boolean consultaDeStock(int cantidad) {
        return this.cantidad >= cantidad;
    }
}