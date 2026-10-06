package ar.edu.unju.escmi.tp5.dominio;

public class Producto {
    private int codigoP;
    private String descripcion;
    private double precioLista;
    private double descuento; 

    public Producto(int codigoP, String descripcion, double precioLista, double descuento) {
        this.codigoP = codigoP;
        this.descripcion = descripcion;
        this.precioLista = precioLista;
        this.descuento = descuento;
    }

    public int getCodigoP() { return codigoP; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioLista() { return precioLista; }
    public double getDescuento() { return descuento; }

    public double calcularConDescuento() {
        return precioLista - (precioLista * descuento / 100);
    }
}