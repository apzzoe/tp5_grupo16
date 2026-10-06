package ar.edu.unju.escmi.tp5.dominio;

public abstract class Persona {
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    
    public Persona(int dni, String nombre, String apellido, String direccion) {
    	this.dni = dni;
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.direccion = direccion;
    	}

    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDireccion() { return direccion; }
    
}
