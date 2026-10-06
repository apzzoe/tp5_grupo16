package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;

import ar.edu.unju.escmi.tp5.collections.CollectionCliente;
import ar.edu.unju.escmi.tp5.collections.CollectionEmpleado;
import ar.edu.unju.escmi.tp5.collections.CollectionProducto;
import ar.edu.unju.escmi.tp5.dominio.Cliente;

public class Main {

    public static void main(String[] args) {
       
        CollectionEmpleado.precargarEmpleados();
        CollectionCliente.precargarClientes();
        CollectionProducto.precargarProductos();

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE VENTAS =====");
            System.out.println("1 - Encargado de ventas");
            System.out.println("2 - Agente administrativo");
            System.out.println("3 - Cliente");
            System.out.println("0 - Salir");
            opcion = Entrada.leerInt(sc, "Opcion: ");

            Menu menu = null;
            switch (opcion) {
            case 1:
                menu = new MenuEncargadoDeVentas(sc, CollectionEmpleado.obtenerEncargadoDeVentas());
                break;
            case 2:
                menu = new MenuAgenteAdministrativo(sc, CollectionEmpleado.obtenerAgenteAdministrativo());
                break;
            case 3:
                int dni = Entrada.leerInt(sc, "Ingrese su DNI: ");
                Cliente c = CollectionCliente.buscarCliente(dni);
                if (c == null) System.out.println("Cliente no registrado.");
                else menu = new MenuCliente(sc, c);
                break;
            case 0:
                System.out.println("Hasta luego.");
                break;
            default:
                System.out.println("Opcion invalida.");
            }
            if (menu != null) {
                ejecutar(menu, sc);
            }
        } while (opcion != 0);
        sc.close();
    }

    private static void ejecutar(Menu menu, Scanner sc) {
        int op;
        do {
            menu.mostrarMenu();
            op = Entrada.leerInt(sc, "Opcion: ");
            menu.ejecutarOpcion(op);
        } while (op != 0);
    }
}
