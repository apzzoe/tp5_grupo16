package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;

public class Entrada {
    public static int leerInt(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }
}

