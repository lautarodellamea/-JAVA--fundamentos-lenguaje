package colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// 18. Iteradores y recorridos avanzados
// Iterator es el objeto que sabe recorrer una colección elemento por elemento.
// Todas las Collection lo ofrecen con iterator(), y el for-each lo usa por detrás.
//
// Métodos: hasNext() (¿queda alguno?), next() (dame el siguiente), remove() (borra el último devuelto).
public class IteradoresRecorridos {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        // 1. for clásico con índice (solo para List).
        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i) + " ");
        }
        System.out.println("<- for con índice");

        // 2. for-each: el más simple, sirve para cualquier Collection.
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println("<- for-each");

        // 3. Iterator explícito: permite BORRAR mientras se recorre de forma segura.
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            int numero = it.next();
            if (numero % 2 == 0) {
                it.remove(); // borra los pares
            }
        }
        System.out.println("Sin pares (Iterator.remove): " + numeros);

        // Borrar con la lista directamente DENTRO de un for-each rompe el recorrido.
        // (Ojo: si se borra justo el penúltimo elemento, el bucle termina sin avisar y no lanza error.
        // Es una rareza que hace este bug aún más traicionero: por eso nunca se hace.)
        try {
            for (int numero : numeros) {
                if (numero == 1) {
                    numeros.remove(Integer.valueOf(numero));
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException: no se puede modificar la lista mientras se recorre con for-each");
        }

        // 4. removeIf: la forma corta de borrar por condición.
        List<Integer> otra = new ArrayList<>(List.of(10, 15, 20, 25));
        otra.removeIf(n -> n > 18);
        System.out.println("removeIf: " + otra);

        // 5. forEach con lambda (Java 8+).
        otra.forEach(n -> System.out.println("forEach lambda: " + n));

        // Set: se recorre igual (no tiene índices).
        Set<String> nombres = new TreeSet<>(List.of("Marta", "Ana", "Luis"));
        for (String nombre : nombres) {
            System.out.print(nombre + " ");
        }
        System.out.println("<- Set");

        // --- Map: no es una Collection, se recorre por sus "vistas" ---
        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 25);
        edades.put("Luis", 40);
        edades.put("Marta", 33);

        // Solo claves
        for (String clave : edades.keySet()) {
            System.out.println("clave: " + clave);
        }
        // Solo valores
        for (int valor : edades.values()) {
            System.out.println("valor: " + valor);
        }
        // Clave y valor a la vez (la mejor opción: evita buscar con get() en cada vuelta).
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            System.out.println(entrada.getKey() + " tiene " + entrada.getValue());
        }
        // forEach del Map con lambda
        edades.forEach((nombre, edad) -> System.out.println("lambda: " + nombre + " -> " + edad));

        // Borrar entradas mientras se recorre: Iterator sobre el entrySet, o removeIf.
        edades.entrySet().removeIf(entrada -> entrada.getValue() > 35);
        System.out.println("Sin mayores de 35: " + edades.keySet().size() + " entradas");
    }
}
