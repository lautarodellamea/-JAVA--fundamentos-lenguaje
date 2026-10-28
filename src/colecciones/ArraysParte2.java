package colecciones;

import java.util.Arrays;

// 03. Arrays: parte 2
// Arrays multidimensionales y la clase de utilidades java.util.Arrays.
//
// Arrays "estáticos" vs "dinámicos":
// - Un array común es ESTÁTICO: el tamaño se fija al crearlo y no cambia.
// - Para tamaño que crece y se achica se usa una colección dinámica como ArrayList
//   (por dentro, ArrayList usa un array y lo reemplaza por uno más grande cuando se llena).
public class ArraysParte2 {
    public static void main(String[] args) {
        // Matriz (array de arrays): 2 filas y 3 columnas.
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("matriz[1][2] = " + matriz[1][2]); // fila 1, columna 2 -> 6
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println();
        }

        // Cada fila puede tener un largo distinto (array irregular).
        int[][] irregular = new int[3][];
        irregular[0] = new int[]{1};
        irregular[1] = new int[]{1, 2};
        irregular[2] = new int[]{1, 2, 3};
        System.out.println("irregular: " + Arrays.deepToString(irregular));

        // --- Clase Arrays: utilidades para trabajar con arrays ---
        int[] numeros = {5, 3, 9, 1, 7};

        // Imprimir un array: println(numeros) mostraría algo como [I@1b6d3586.
        System.out.println("toString: " + Arrays.toString(numeros));

        // Ordenar (modifica el array original).
        Arrays.sort(numeros);
        System.out.println("sort: " + Arrays.toString(numeros));

        // Buscar: binarySearch SOLO funciona si el array ya está ordenado.
        System.out.println("binarySearch(7): posición " + Arrays.binarySearch(numeros, 7));

        // Copiar: crea un array NUEVO (a diferencia de asignar con =).
        int[] copia = Arrays.copyOf(numeros, numeros.length);
        int[] ampliada = Arrays.copyOf(numeros, 8); // si es más grande, completa con ceros
        int[] parte = Arrays.copyOfRange(numeros, 1, 4); // desde 1 (incluido) hasta 4 (excluido)
        System.out.println("copyOf: " + Arrays.toString(copia));
        System.out.println("copyOf ampliada: " + Arrays.toString(ampliada));
        System.out.println("copyOfRange: " + Arrays.toString(parte));

        // Comparar: == compara referencias; Arrays.equals compara el contenido.
        System.out.println("copia == numeros: " + (copia == numeros));                   // false
        System.out.println("Arrays.equals: " + Arrays.equals(copia, numeros));           // true

        // Rellenar todas las posiciones con un valor.
        int[] relleno = new int[4];
        Arrays.fill(relleno, 7);
        System.out.println("fill: " + Arrays.toString(relleno));
    }
}
