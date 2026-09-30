package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private int codigoP;
    private String descripcion;
    private double precioUnitario;
    private double descuento; 

    public Producto(int codigoP, String descripcion, double precioUnitario, double descuento) {
        this.codigoP = codigoP;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
    }

    public int getCodigoP() { return codigoP; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getDescuento() { return descuento; }

    public double calcularConDescuento() {
        return precioUnitario - (precioUnitario * descuento / 100);
    }
}