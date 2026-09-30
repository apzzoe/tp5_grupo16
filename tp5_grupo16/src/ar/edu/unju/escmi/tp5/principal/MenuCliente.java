package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import ar.edu.unju.escmi.tp5.dominio.Factura;

public class MenuCliente implements Menu {
    private Scanner sc;
    private Cliente cliente;

    public MenuCliente(Scanner sc, Cliente cliente) {
        this.sc = sc;
        this.cliente = cliente;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENU CLIENTE ---");
        System.out.println("1 - Buscar factura");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
        case 1:
            int nro = Entrada.leerInt(sc, "Numero de factura: ");
            Factura f = cliente.buscarFactura(nro);
            if (f == null) System.out.println("No se encontro esa factura para usted.");
            else f.mostrarFactura();
            break;
        case 0:
            System.out.println("Volviendo al menu principal...");
            break;
        default:
            System.out.println("Opcion invalida.");
        }
    }
}

