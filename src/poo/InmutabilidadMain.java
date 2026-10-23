package poo;

import java.util.ArrayList;
import java.util.List;

// 04. Inmutabilidad de clases (ejecución)
public class InmutabilidadMain {
    public static void main(String[] args) {
        // Dinero: sumar NO modifica los originales, crea un objeto nuevo.
        Dinero a = new Dinero(100, "ARS");
        Dinero b = new Dinero(50, "ARS");
        Dinero total = a.sumar(b);
        System.out.println("a = " + a + " | b = " + b + " | total = " + total);
        // a.monto = 0;   // NO compila: es private final y no hay setter.

        // String es el ejemplo clásico de clase inmutable.
        String texto = "hola";
        texto.toUpperCase();
        System.out.println("texto sigue igual: " + texto);

        // Pedido: la copia defensiva protege el estado interno.
        List<String> lista = new ArrayList<>();
        lista.add("Pizza");
        Pedido pedido = new Pedido("Lauta", lista);

        lista.add("Gaseosa"); // modificamos la lista ORIGINAL desde afuera
        System.out.println("El pedido no se enteró: " + pedido);

        // La lista que devuelve el getter no se puede modificar.
        try {
            pedido.getItems().add("Postre");
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar desde afuera");
        }

        // Para "cambiar", se obtiene un pedido nuevo; el anterior queda intacto.
        Pedido pedido2 = pedido.conItem("Postre");
        System.out.println("Original: " + pedido);
        System.out.println("Nuevo:    " + pedido2);
    }
}
