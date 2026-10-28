package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 05. List: ArrayList
// ArrayList es la lista más usada. Por dentro guarda los datos en un ARRAY común.
// Cuando el array se llena, crea uno más grande y copia todo (por eso "crece sola").
//
// Fortalezas:  acceder por índice (get/set) es MUY rápido.
// Debilidades: insertar o borrar en el medio es lento, porque hay que correr los elementos siguientes.
public class ListaArrayList {
    public static void main(String[] args) {
        // Se declara con la interfaz (List) y se crea con la implementación (ArrayList).
        // <String> indica el tipo de dato que guarda (genéricos).
        List<String> frutas = new ArrayList<>();

        // Agregar
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Uva");
        frutas.add(1, "Banana"); // en una posición específica: corre los demás
        System.out.println("Lista: " + frutas);

        // Leer y modificar por índice
        System.out.println("get(0): " + frutas.get(0));
        frutas.set(0, "Frutilla"); // reemplaza, no inserta
        System.out.println("Después de set: " + frutas);

        // Consultar
        System.out.println("size: " + frutas.size());
        System.out.println("contains(\"Uva\"): " + frutas.contains("Uva"));
        System.out.println("indexOf(\"Uva\"): " + frutas.indexOf("Uva")); // -1 si no existe

        // Borrar por índice o por objeto
        frutas.remove(0);       // por posición
        frutas.remove("Uva");   // por contenido (usa equals)
        System.out.println("Después de borrar: " + frutas);

        // Ordenar
        frutas.add("Ananá");
        Collections.sort(frutas);
        System.out.println("Ordenada: " + frutas);

        // Sublista: una vista de un tramo (desde incluido, hasta excluido).
        System.out.println("subList(0, 2): " + frutas.subList(0, 2));

        // Vaciar
        frutas.clear();
        System.out.println("¿Vacía? " + frutas.isEmpty());

        // TRAMPA con List<Integer>: remove(int) borra por ÍNDICE, remove(Object) borra por VALOR.
        List<Integer> numeros = new ArrayList<>(List.of(10, 20, 30, 1));
        numeros.remove(1);                     // borra la posición 1 (el 20)
        System.out.println("remove(1): " + numeros);
        numeros.remove(Integer.valueOf(1));    // borra el valor 1
        System.out.println("remove(Integer.valueOf(1)): " + numeros);
    }
}
