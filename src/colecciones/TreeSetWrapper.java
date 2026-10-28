package colecciones;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

// 13. Set: TreeSet con clases wrapper
// TreeSet mantiene los elementos ORDENADOS siempre (por orden natural), sin repetidos.
// Por dentro usa un árbol balanceado (rojo-negro): agregar/buscar/borrar cuesta O(log n),
// más lento que HashSet pero siempre ordenado.
//
// Reglas:
// - Los elementos deben ser comparables entre sí (Integer, String, Double ya lo son).
// - Dos elementos son "el mismo" si compareTo() da 0 (no usa equals/hashCode).
// - No acepta null.
public class TreeSetWrapper {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(50);
        numeros.add(10);
        numeros.add(30);
        numeros.add(10); // repetido, ignorado
        System.out.println("Ordenado automáticamente: " + numeros); // [10, 30, 50]

        // Métodos extra por ser ordenado (si la variable es TreeSet).
        System.out.println("first: " + numeros.first()); // el menor
        System.out.println("last: " + numeros.last());   // el mayor
        System.out.println("lower(30): " + numeros.lower(30));     // el mayor que sea MENOR a 30 -> 10
        System.out.println("higher(30): " + numeros.higher(30));   // el menor que sea MAYOR a 30 -> 50
        System.out.println("floor(35): " + numeros.floor(35));     // mayor que sea <= 35 -> 30
        System.out.println("ceiling(35): " + numeros.ceiling(35)); // menor que sea >= 35 -> 50

        // Subconjuntos.
        System.out.println("headSet(30): " + numeros.headSet(30));         // menores a 30
        System.out.println("tailSet(30): " + numeros.tailSet(30));         // mayores o iguales a 30
        System.out.println("subSet(10, 50): " + numeros.subSet(10, 50));   // desde 10 (incl.) a 50 (excl.)

        // Orden inverso.
        System.out.println("descendingSet: " + numeros.descendingSet());

        // Con Strings: orden alfabético. Ojo: las MAYÚSCULAS van antes que las minúsculas.
        Set<String> nombres = new TreeSet<>();
        nombres.add("luis");
        nombres.add("Marta");
        nombres.add("ana");
        nombres.add("Ana");
        System.out.println("Strings: " + nombres); // [Ana, Marta, ana, luis]

        // Con un orden distinto: se pasa un Comparator al crearlo.
        Set<Integer> mayorAMenor = new TreeSet<>(Collections.reverseOrder());
        mayorAMenor.addAll(numeros);
        System.out.println("Mayor a menor: " + mayorAMenor);

        // numeros.add(null); // lanzaría NullPointerException: TreeSet no acepta null
    }
}
