package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Factura;

public class CollectionFactura {
    public static List<Factura> collection = new ArrayList<>();

    public static void agregarFactura(Factura factura) {
        collection.add(factura);
    }

    public static Factura buscarFactura(int nroF) {
        for (Factura f : collection) {
            if (f.getNroF() == nroF) return f;
        }
        
        return null;
    }

    public static int siguienteNumero() {
        return collection.size() + 1;
    }
    
}



