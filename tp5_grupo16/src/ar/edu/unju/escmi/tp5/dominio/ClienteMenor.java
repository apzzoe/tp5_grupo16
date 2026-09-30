package ar.edu.unju.escmi.tp5.dominio;

public class ClienteMenor extends Cliente {
    public static final double DESCUENTO_PAMI = 0.10;
    protected String obraSocial;
    protected boolean presentaDni;

    public ClienteMenor(int dni, String nombre, String apellido, String direccion,
                        String obraSocial, boolean presentaDni) {
        super(dni, nombre, apellido, direccion);
        this.obraSocial = obraSocial;
        this.presentaDni = presentaDni;
    }

    public String getObraSocial() { return obraSocial; }

    @Override
    public int calcularUnidades(int cantidad) {
        return cantidad;
    }

    @Override
    public double calcularPrecioUnitario(double precio) {
        return precio;
    }

    @Override
    public double calcularTotal(double subtotal) {
        if (presentaDni && "PAMI".equalsIgnoreCase(obraSocial)) {
            return subtotal - (subtotal * DESCUENTO_PAMI);
        }
        return subtotal;
    }
}