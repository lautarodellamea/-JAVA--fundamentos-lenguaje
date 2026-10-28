package colecciones;

import java.util.LinkedList;
import java.util.List;

// 06. List: LinkedList
// LinkedList guarda cada elemento en un NODO que apunta al anterior y al siguiente
// (lista doblemente enlazada), como los vagones de un tren enganchados entre sí.
//
//   null <- [Ana] <-> [Luis] <-> [Marta] -> null
//
// Fortalezas:  agregar/borrar al principio o al final es MUY rápido (solo se cambian enlaces).
// Debilidades: acceder por índice es lento (hay que recorrer los nodos desde un extremo)
//              y cada nodo ocupa más memoria que una posición de array.
//
// Además de List, implementa Deque: se puede usar como cola o pila.
public class ListaLinkedList {
    public static void main(String[] args) {
        // Con la interfaz List se usa igual que un ArrayList (add, get, remove, size...).
        List<String> nombres = new LinkedList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        System.out.println("Como List: " + nombres + " | get(1): " + nombres.get(1));

        // Declarada como LinkedList se acceden los métodos propios de los extremos.
        LinkedList<String> fila = new LinkedList<>();
        fila.add("Luis");
        fila.addFirst("Ana");   // al principio
        fila.addLast("Marta");  // al final
        System.out.println("Fila: " + fila);

        System.out.println("getFirst: " + fila.getFirst());
        System.out.println("getLast: " + fila.getLast());

        System.out.println("removeFirst: " + fila.removeFirst()); // saca y devuelve el primero
        System.out.println("removeLast: " + fila.removeLast());   // saca y devuelve el último
        System.out.println("Queda: " + fila);

        // Como COLA (primero en entrar, primero en salir): offer + poll.
        LinkedList<String> cola = new LinkedList<>();
        cola.offer("Primero");
        cola.offer("Segundo");
        System.out.println("peek (mira sin sacar): " + cola.peek());
        System.out.println("poll (saca): " + cola.poll());

        // Como PILA (último en entrar, primero en salir): push + pop.
        LinkedList<String> pila = new LinkedList<>();
        pila.push("Plato 1");
        pila.push("Plato 2");
        System.out.println("pop: " + pila.pop()); // Plato 2
    }
}
