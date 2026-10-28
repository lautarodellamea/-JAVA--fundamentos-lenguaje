package colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 01. Introducción a las estructuras de datos
//
// Una estructura de datos es una forma de ORGANIZAR y GUARDAR varios datos juntos
// para poder usarlos de manera eficiente (buscar, agregar, borrar, ordenar).
// Es la diferencia entre guardar 1000 nombres en 1000 variables sueltas o en una sola caja.
//
// Elegir la estructura correcta importa: cambia qué tan rápido anda el programa
// y qué tan simple queda el código.
//
// Mapa de lo que vamos a ver en esta sección:
//
//   Array (arreglo)  -> tamaño FIJO, forma más básica, viene con el lenguaje.
//
//   Collection (interfaz)
//     |-- List  -> ordenada por posición, permite repetidos   (ArrayList, LinkedList)
//     |-- Set   -> sin repetidos                              (HashSet, LinkedHashSet, TreeSet)
//
//   Map (interfaz aparte)
//     -> pares clave-valor, claves sin repetir                 (HashMap, LinkedHashMap, TreeMap)
public class IntroEstructurasDatos {
    public static void main(String[] args) {
        // Array: tamaño fijo, se declara con el tipo y los corchetes.
        int[] edades = {30, 25, 40};
        System.out.println("Array: primer elemento = " + edades[0] + " | tamaño = " + edades.length);

        // List: crece sola, mantiene el orden y acepta repetidos.
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");
        System.out.println("List (con repetidos): " + nombres);

        // Set: ignora los repetidos.
        Set<String> unicos = new HashSet<>(nombres);
        System.out.println("Set (sin repetidos): " + unicos.size() + " elementos");

        // Map: cada valor se busca por su clave.
        Map<String, Integer> edadPorNombre = new HashMap<>();
        edadPorNombre.put("Ana", 30);
        edadPorNombre.put("Luis", 25);
        System.out.println("Map: la edad de Luis es " + edadPorNombre.get("Luis"));
    }
}
