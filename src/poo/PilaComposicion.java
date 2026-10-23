package poo;

import java.util.ArrayList;
import java.util.List;

// 07. Herencia vs composición - versión con COMPOSICIÓN (recomendada)
// La Pila TIENE UN ArrayList como detalle interno privado y solo expone lo que tiene sentido.
// Se reutiliza el código igual, pero la interfaz pública queda bajo control (encapsulación).
public class PilaComposicion<T> {
    private final List<T> elementos = new ArrayList<>();

    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    public T desapilar() {
        return elementos.remove(elementos.size() - 1);
    }

    public int tamanio() {
        return elementos.size();
    }
}
