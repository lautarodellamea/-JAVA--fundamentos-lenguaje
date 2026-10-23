package fundamentos;

import java.util.Locale;
import java.util.Scanner;

public class EntradaDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // fuerza el punto como separador decimal, sin importar el Locale del sistema.

        System.out.print("Ingresá tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingresá tu edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // nextInt() no consume el salto de línea; hay que limpiarlo antes de otro nextLine().

        System.out.print("Ingresá tu promedio: ");
        double promedio = scanner.nextDouble();

        System.out.println();
        System.out.println("Hola " + nombre + ", tenés " + edad + " años y tu promedio es " + promedio);

        scanner.close();
    }
}
