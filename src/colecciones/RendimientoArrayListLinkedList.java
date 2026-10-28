package colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 07. Comparación de rendimientos: ArrayList y LinkedList
//
// Resumen teórico (n = cantidad de elementos):
//
//   Operación                       | ArrayList        | LinkedList
//   --------------------------------|------------------|------------------
//   get(i) / set(i)                 | rápido, O(1)     | lento, O(n)
//   add al final                    | rápido, O(1)*    | rápido, O(1)
//   add / remove al principio       | lento, O(n)      | rápido, O(1)
//   add / remove en el medio        | lento, O(n)      | lento, O(n) (hay que llegar hasta ahí)
//   memoria                         | menos            | más (un nodo por elemento)
//
//   * a veces tiene que agrandar el array interno.
//
// En la práctica, ArrayList gana en la mayoría de los casos.
// LinkedList conviene cuando se agrega/saca seguido por los extremos (colas, pilas).
//
// Este programa lo mide. Los tiempos dependen de tu computadora y cambian en cada
// ejecución: sirven para ver la DIFERENCIA RELATIVA, no los números exactos.
public class RendimientoArrayListLinkedList {
    static final int CANTIDAD = 50_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // 1. Agregar al final
        medir("Agregar al final", arrayList, linkedList, lista -> {
            for (int i = 0; i < CANTIDAD; i++) {
                lista.add(i);
            }
        });

        // 2. Leer por índice (recorriendo todas las posiciones)
        medir("Leer por índice", arrayList, linkedList, lista -> {
            for (int i = 0; i < CANTIDAD; i++) {
                lista.get(i);
            }
        });

        // 3. Insertar al principio
        medir("Insertar al principio", arrayList, linkedList, lista -> {
            for (int i = 0; i < CANTIDAD; i++) {
                lista.add(0, i);
            }
        });

        // 4. Borrar del principio
        medir("Borrar del principio", arrayList, linkedList, lista -> {
            for (int i = 0; i < CANTIDAD; i++) {
                lista.remove(0);
            }
        });
    }

    // Ejecuta la misma operación sobre las dos listas y muestra cuánto tardó cada una.
    private static void medir(String operacion, List<Integer> arrayList, List<Integer> linkedList,
                              java.util.function.Consumer<List<Integer>> accion) {
        long msArray = tiempoEnMs(arrayList, accion);
        long msLinked = tiempoEnMs(linkedList, accion);
        System.out.println(operacion + " -> ArrayList: " + msArray + " ms | LinkedList: " + msLinked + " ms");
    }

    private static long tiempoEnMs(List<Integer> lista, java.util.function.Consumer<List<Integer>> accion) {
        long inicio = System.nanoTime();
        accion.accept(lista);
        return (System.nanoTime() - inicio) / 1_000_000;
    }
}
