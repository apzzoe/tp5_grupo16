package ar.edu.unju.escmi.tp5.dominio;

public abstract class Empleado extends Persona {
    public Empleado(int dni, String nombre, String apellido, String direccion) {
        super(dni, nombre, apellido, direccion);
    }
}