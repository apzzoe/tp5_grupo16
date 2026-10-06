package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp5.dominio.Stock;

public class CollectionStock {
    public static List<Stock> stocks = new ArrayList<>();

    public static void agregarStock(Stock stock) {
        stocks.add(stock);
    }

    public static Stock buscarStock(int codigoP) {
        for (Stock s : stocks) {
            if (s.getProducto().getCodigoP() == codigoP) return s;
        }
        return null;
    }
}