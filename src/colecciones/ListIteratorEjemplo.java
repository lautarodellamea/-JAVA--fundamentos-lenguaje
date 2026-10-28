package colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// 19. La interfaz: ListIterator
// ListIterator es un Iterator MEJORADO que solo existe para List. Permite:
// - Recorrer en AMBAS direcciones (hacia adelante y hacia atrás).
// - Saber la posición actual (nextIndex / previousIndex).
// - MODIFICAR (set), AGREGAR (add) y BORRAR (remove) mientras se recorre.
//
// Imaginalo como un cursor ubicado ENTRE dos elementos:
//
//   Ana  Luis  Marta        el cursor empieza antes de Ana
//  ^    ^     ^     ^        next() devuelve el de la derecha y avanza
//                            previous() devuelve el de la izquierda y retrocede
public class ListIteratorEjemplo {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(List.of("Ana", "Luis", "Marta"));

        // Hacia adelante
        ListIterator<String> it = nombres.listIterator();
        while (it.hasNext()) {
            int indice = it.nextIndex();
            System.out.println("adelante [" + indice + "] " + it.next());
        }

        // Hacia atrás: el cursor quedó al final, así que podemos retroceder.
        while (it.hasPrevious()) {
            int indice = it.previousIndex();
            System.out.println("atrás [" + indice + "] " + it.previous());
        }

        // Modificar con set(): reemplaza el último elemento devuelto por next() o previous().
        it = nombres.listIterator();
        while (it.hasNext()) {
            String nombre = it.next();
            if (nombre.equals("Luis")) {
                it.set("Luis (modificado)");
            }
        }
        System.out.println("Después de set: " + nombres);

        // Agregar con add(): inserta ANTES de la posición del cursor, sin romper el recorrido.
        it = nombres.listIterator();
        while (it.hasNext()) {
            if (it.next().equals("Ana")) {
                it.add("Beto"); // queda justo después de Ana
            }
        }
        System.out.println("Después de add: " + nombres);

        // Borrar con remove(): borra el último elemento devuelto.
        it = nombres.listIterator();
        while (it.hasNext()) {
            if (it.next().startsWith("Marta")) {
                it.remove();
            }
        }
        System.out.println("Después de remove: " + nombres);

        // Empezar desde una posición concreta: listIterator(indice).
        ListIterator<String> desdeElFinal = nombres.listIterator(nombres.size());
        System.out.print("Recorrido inverso: ");
        while (desdeElFinal.hasPrevious()) {
            System.out.print(desdeElFinal.previous() + " ");
        }
        System.out.println();
    }
}
