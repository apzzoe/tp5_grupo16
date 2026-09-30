package ar.edu.unju.escmi.tp5.dominio;

import java.time.LocalDate;
import java.util.Map;
import ar.edu.unju.escmi.tp5.collections.CollectionFactura;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;

public class AgenteAdmin extends Empleado {

    public AgenteAdmin(int dni, String nombre, String apellido, String direccion) {
        super(dni, nombre, apellido, direccion);
    }


    public boolean altaProducto(Producto producto, int stockInicial) {
        if (CollectionProducto.buscarProducto(producto.getCodigoP()) != null) {
            return false;
        }
        CollectionProducto.agregarProducto(producto);
        CollectionStock.agregarStock(new Stock(producto, stockInicial));
        return true;
    }

    public Factura realizarVenta(Cliente cliente, Map<Producto, Integer> items) {
        if (items.isEmpty()) {
            return null;
        }

        for (Map.Entry<Producto, Integer> e : items.entrySet()) {
            Stock s = CollectionStock.buscarStockPorCodigo(e.getKey().getCodigoP());
            int unidades = cliente.calcularUnidades(e.getValue());
            if (s == null || !s.consultaDeStock(unidades)) {
                return null;
            }
        }

        Factura factura = new Factura(CollectionFactura.siguienteNumero(), LocalDate.now(), cliente);
        for (Map.Entry<Producto, Integer> e : items.entrySet()) {
            Producto p = e.getKey();
            int unidades = cliente.calcularUnidades(e.getValue());
            double precio = cliente.calcularPrecioUnitario(p.calcularConDescuento());
            factura.agregarDetalle(new DetalleFactura(unidades, p, precio));
            CollectionStock.buscarStockPorCodigo(p.getCodigoP()).actualizarStock(unidades);
        }
        factura.calcularPrecioTotal();
        CollectionFactura.agregarFactura(factura);
        return factura;
    }
}
