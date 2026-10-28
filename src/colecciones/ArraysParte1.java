package colecciones;

// 02. Arrays: parte 1
// Un array (arreglo) guarda VARIOS valores del MISMO tipo, en posiciones numeradas desde 0.
// Su tamaño se define al crearlo y NO puede cambiar después.
public class ArraysParte1 {
    public static void main(String[] args) {
        // Forma 1: indicar el tamaño. Todas las posiciones arrancan con el valor por defecto del tipo.
        int[] numeros = new int[5];
        System.out.println("Valor por defecto de int: " + numeros[0]);        // 0
        String[] textos = new String[2];
        System.out.println("Valor por defecto de String: " + textos[0]);       // null
        boolean[] banderas = new boolean[2];
        System.out.println("Valor por defecto de boolean: " + banderas[0]);    // false

        // Forma 2: indicar los valores directamente (el tamaño se deduce).
        String[] dias = {"Lunes", "Martes", "Miércoles"};

        // Acceso y modificación por índice: el primero es 0, el último es length - 1.
        numeros[0] = 10;
        numeros[4] = 50;
        System.out.println("Primer día: " + dias[0] + " | último día: " + dias[dias.length - 1]);

        // length es un atributo (sin paréntesis, a diferencia de String.length()).
        System.out.println("Tamaño del array: " + numeros.length);

        // Recorrido con for clásico: sirve cuando necesitás el índice.
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("numeros[" + i + "] = " + numeros[i]);
        }

        // Recorrido con for-each: más simple cuando solo importa el valor.
        for (String dia : dias) {
            System.out.println("Día: " + dia);
        }

        // Salirse del rango lanza una excepción en ejecución.
        try {
            numeros[5] = 1; // el último índice válido es 4
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Los arrays son OBJETOS: la variable guarda una referencia, no los datos.
        // Asignar un array a otra variable NO copia: ambas apuntan al mismo array.
        int[] original = {1, 2, 3};
        int[] alias = original;
        alias[0] = 99;
        System.out.println("original[0] después de modificar el alias: " + original[0]); // 99
    }
}
