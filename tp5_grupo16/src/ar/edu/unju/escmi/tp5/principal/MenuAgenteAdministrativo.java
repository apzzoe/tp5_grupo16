package ar.edu.unju.escmi.tp5.principal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.collections.CollectionStock;
import ar.edu.unju.escmi.tp5.dominio.AgenteAdministrativo;
import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.ClienteMayor;
import ar.edu.unju.escmi.tp5.dominio.Factura;
import ar.edu.unju.escmi.tp5.dominio.Producto;
import ar.edu.unju.escmi.tp5.dominio.Stock;

public class MenuAgenteAdministrativo implements Menu {
    private Scanner sc;
    private AgenteAdministrativo agente;

    public MenuAgenteAdministrativo(Scanner sc, AgenteAdministrativo agente) {
        this.sc = sc;
        this.agente = agente;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENU AGENTE ADMINISTRATIVO ---");
        System.out.println("1 - Alta de producto");
        System.out.println("2 - Realizar venta");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
        case 1:
            altaProducto();
            break;
        case 2:
            realizarVenta();
            break;
        case 0:
            System.out.println("Volviendo al menu principal...");
            break;
        default:
            System.out.println("Opcion invalida.");
        }
    }

    private void altaProducto() {
        int codigo = Entrada.leerInt(sc, "Codigo de producto: ");
        if (CollectionProducto.buscarProducto(codigo) != null) {
            System.out.println("Ya existe un producto con ese codigo.");
            return;
        }
        String desc = Entrada.leerTexto(sc, "Descripcion: ");
        double precio = Entrada.leerDouble(sc, "Precio unitario: ");
        int descuento = Entrada.leerInt(sc, "Descuento (0, 25 o 30): ");
        if (descuento != 0 && descuento != 25 && descuento != 30) {
            System.out.println("Descuento invalido. Debe ser 0, 25 o 30.");
            return;
        }
        int stock = Entrada.leerInt(sc, "Stock inicial (unidades): ");
        if (stock < 0 || precio < 0) {
            System.out.println("Valores negativos no permitidos.");
            return;
        }
        agente.altaProducto(new Producto(codigo, desc, precio, descuento), stock);
        System.out.println("Producto cargado correctamente.");
    }

    private void realizarVenta() {
        int dni = Entrada.leerInt(sc, "DNI del cliente: ");
        Cliente cliente = CollectionCliente.buscarCliente(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        String unidad = (cliente instanceof ClienteMayor) ? "bultos (10 unidades c/u)" : "unidades";
        Map<Producto, Integer> items = new LinkedHashMap<>();
        int codigo;
        do {
            codigo = Entrada.leerInt(sc, "Codigo de producto (0 para terminar): ");
            if (codigo == 0) break;
            Producto p = CollectionProducto.buscarProducto(codigo);
            if (p == null) {
                System.out.println("Producto inexistente.");
                continue;
            }
            int cant = Entrada.leerInt(sc, "Cantidad en " + unidad + ": ");
            if (cant <= 0) {
                System.out.println("La cantidad debe ser mayor a 0.");
                continue;
            }
            int total = items.getOrDefault(p, 0) + cant;
            Stock s = CollectionStock.buscarStock(codigo);
            if (s == null || !s.consultaDeStock(cliente.calcularUnidades(total))) {
                System.out.println("Stock insuficiente (disponible: " + (s == null ? 0 : s.getCantidad()) + " unidades).");
                continue;
            }
            items.put(p, total);
            System.out.println("Producto agregado.");
        } while (true);

        Factura f = agente.realizarVenta(cliente, items);
        if (f == null) {
            System.out.println("No se pudo realizar la venta (sin productos o sin stock).");
        } else {
            f.mostrarFactura();
        }
    }
}
