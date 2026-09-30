package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayor;
import ar.edu.unju.escmi.tp5.dominio.ClienteMenor;

public class CollectionCliente {
    public static List<Cliente> collection = new ArrayList<>();

    public static void agregarCliente(Cliente cliente) {
        collection.add(cliente);
    }

    public static Cliente buscarCliente(int dni) {
        for (Cliente c : collection) {
            if (c.getDni() == dni) return c;
        }
        return null;
    }

    public static void precargarClientes() {
        agregarCliente(new ClienteMayor(40111222, "Carlos", "Gomez", "Av. Bolivia 100", 1));
        agregarCliente(new ClienteMayor(41222333, "Lucia", "Fernandez", "Av. Fascio 200", 2));
        agregarCliente(new ClienteMenor(35222333, "Ana", "Torres", "Lamadrid 55", "PAMI", true));
        agregarCliente(new ClienteMenor(36333444, "Pedro", "Ruiz", "Necochea 77", "Sin obra social", true));
    }
}
