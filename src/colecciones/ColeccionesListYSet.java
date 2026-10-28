package colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 04. Collection: List y Set
//
// Collection es la interfaz base de las colecciones de un solo valor por elemento.
// De ella salen dos ramas principales:
//
//   Collection
//     |-- List: mantiene el ORDEN de inserción, acepta REPETIDOS y se accede por ÍNDICE.
//     |-- Set : NO acepta repetidos y (en general) no se accede por índice.
//
// Map NO forma parte de Collection: guarda pares clave-valor (se ve más adelante).
//
// A diferencia de un array, las colecciones CRECEN solas y solo guardan OBJETOS
// (para tipos primitivos se usan las clases wrapper: List<Integer>, no List<int>).
public class ColeccionesListYSet {
    public static void main(String[] args) {
        // Métodos comunes de TODA Collection: add, size, isEmpty, contains, remove, clear, addAll.
        // Como List y Set implementan Collection, se pueden usar con la misma variable.
        Collection<String> lista = new ArrayList<>();
        Collection<String> conjunto = new HashSet<>();

        for (String nombre : new String[]{"Ana", "Luis", "Ana", "Marta"}) {
            lista.add(nombre);
            // add devuelve boolean: false si el Set ya tenía ese elemento.
            boolean agregado = conjunto.add(nombre);
            if (!agregado) {
                System.out.println("El Set rechazó el repetido: " + nombre);
            }
        }

        System.out.println("List (acepta repetidos): " + lista + " -> " + lista.size() + " elementos");
        System.out.println("Set (sin repetidos):     " + conjunto.size() + " elementos");
        System.out.println("¿La lista contiene a Luis? " + lista.contains("Luis"));
        System.out.println("¿Está vacío el conjunto? " + conjunto.isEmpty());

        // Solo la List permite acceder por posición (necesitás declararla como List).
        List<String> listaConIndices = new ArrayList<>(lista);
        System.out.println("Posición 1 de la lista: " + listaConIndices.get(1));
        // conjunto.get(1); // NO existe: un Set no tiene posiciones.

        // Se pueden convertir entre sí: pasar una lista a Set es la forma típica de quitar repetidos.
        Set<String> sinRepetidos = new HashSet<>(lista);
        System.out.println("Lista sin repetidos: " + sinRepetidos.size() + " elementos");

        // Qué elegir:
        // - ¿Orden por posición o repetidos? -> List.
        // - ¿Unicidad o preguntar "¿está?" rápido? -> Set.
    }
}
