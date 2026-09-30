package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.AgenteAdmin;
import ar.edu.unju.escmi.tp5.dominio.AgenteVentas;
import ar.edu.unju.escmi.tp5.dominio.Empleado;

public class CollectionEmpleado {
    public static List<Empleado> collection = new ArrayList<>();

    public static void agregarEmpleado(Empleado empleado) {
        collection.add(empleado);
    }

    public static void precargarEmpleados() {
        agregarEmpleado(new AgenteVentas(30111222, "Maria", "Lopez", "Belgrano 123"));
        agregarEmpleado(new AgenteAdmin(28999888, "Juan", "Perez", "Alvear 456"));
    }

    public static AgenteVentas obtenerAgenteVentas() {
        for (Empleado e : collection) {
            if (e instanceof AgenteVentas) return (AgenteVentas) e;
        }
        return null;
    }

    public static AgenteAdmin obtenerAgenteAdmin() {
        for (Empleado e : collection) {
            if (e instanceof AgenteAdmin) return (AgenteAdmin) e;
        }
        return null;
    }
}
