package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;

import ar.edu.unju.escmi.tp5.dominio.AgenteVentas;

public class MenuAgenteVentas implements Menu {
    private Scanner sc;
    private AgenteVentas agente;

    public MenuAgenteVentas(Scanner sc, AgenteVentas agente) {
        this.sc = sc;
        this.agente = agente;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENU ENCARGADO DE VENTAS ---");
        System.out.println("1 - Mostrar las ventas");
        System.out.println("2 - Mostrar el total de todas las ventas");
        System.out.println("3 - Verificar stock de un producto");
        System.out.println("0 - Volver");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
        case 1:
            agente.mostrarVentas();
            break;
        case 2:
            System.out.printf("Total de todas las ventas: $ %.2f%n", agente.mostrarTotalVentas());
            break;
        case 3:
            int codigo = Entrada.leerInt(sc, "Codigo de producto: ");
            int stock = agente.verificarStock(codigo);
            if (stock < 0) System.out.println("El producto no existe.");
            else System.out.println("Stock disponible: " + stock + " unidades.");
            break;
        case 0:
            System.out.println("Volviendo al menu principal...");
            break;
        default:
            System.out.println("Opcion invalida.");
        }
    }
}

