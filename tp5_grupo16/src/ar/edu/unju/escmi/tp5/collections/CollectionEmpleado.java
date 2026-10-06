package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.dominio.Empleado;
import ar.edu.unju.escmi.tp5.dominio.EncargadoDeVentas;

public class CollectionEmpleado {
    public static List<Empleado> empleados = new ArrayList<>();

    public static void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public static void precargarEmpleados() {
        agregarEmpleado(new EncargadoDeVentas(30111222, "Maria", "Lopez", "Belgrano 123"));
        agregarEmpleado(new AgenteAdministrativo(28999888, "Juan", "Perez", "Alvear 456"));
    }

    public static EncargadoDeVentas obtenerEncargadoDeVentas() {
        for (Empleado e : empleados) {
            if (e instanceof EncargadoDeVentas) return (EncargadoDeVentas) e;
        }
        return null;
    }

    public static AgenteAdministrativo obtenerAgenteAdministrativo() {
        for (Empleado e : empleados) {
            if (e instanceof AgenteAdministrativo) return (AgenteAdministrativo) e;
        }
        return null;
    }
}