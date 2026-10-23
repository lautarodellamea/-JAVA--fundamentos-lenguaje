package poo;

import java.util.ArrayList;

// 07. Herencia vs composición - versión con HERENCIA (problemática)
// Una Pila (LIFO) NO ES UN ArrayList: solo queremos reutilizar su código.
// Al heredar, la Pila recibe TODOS los métodos públicos de ArrayList: add(indice, x), remove(indice),
// clear()... y cualquiera puede romper la regla de "solo se saca por arriba".
public class PilaHerencia<T> extends ArrayList<T> {
    public void apilar(T elemento) {
        add(elemento);
    }

    public T desapilar() {
        return remove(size() - 1);
    }
}
