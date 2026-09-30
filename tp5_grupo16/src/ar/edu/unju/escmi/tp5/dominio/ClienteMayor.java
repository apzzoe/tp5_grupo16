package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMayor extends Cliente {
    public static final int UNIDADES_POR_BULTO = 10;
    protected int id; 
    public ClienteMayor(int dni, String nombre, String apellido, String direccion, int id) {
        super(dni, nombre, apellido, direccion);
        this.id = id;
    }

    public int getId() { return id; }

    @Override
    public int calcularUnidades(int cantidad) {
        return cantidad * UNIDADES_POR_BULTO;
    }

    @Override
    public double calcularPrecioUnitario(double precio) {
        return precio / 2;
    }

    @Override
    public double calcularTotal(double subtotal) {
        return subtotal;
    }
}