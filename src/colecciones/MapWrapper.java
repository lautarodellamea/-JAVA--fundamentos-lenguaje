package colecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// 16. Map con wrapper: HashMap y TreeMap
// Operaciones principales de un Map usando tipos wrapper (String, Integer) como claves y valores.
public class MapWrapper {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        // Agregar / reemplazar
        stock.put("Mate", 10);
        stock.put("Yerba", 25);
        stock.put("Termo", 5);

        // Leer
        System.out.println("get(Yerba): " + stock.get("Yerba"));
        System.out.println("getOrDefault(Azúcar, 0): " + stock.getOrDefault("Azúcar", 0)); // evita el null

        // Consultar
        System.out.println("containsKey(Mate): " + stock.containsKey("Mate"));
        System.out.println("containsValue(5): " + stock.containsValue(5));
        System.out.println("size: " + stock.size());

        // Agregar solo si no existe / reemplazar solo si existe
        stock.putIfAbsent("Mate", 999);     // ya existe: no cambia
        stock.putIfAbsent("Bombilla", 40);  // no existe: lo agrega
        stock.replace("Termo", 8);          // existe: lo cambia
        System.out.println("Stock: " + stock);

        // Borrar
        stock.remove("Bombilla");

        // Recorrer: claves, valores o ambos (entrySet, lo más usado).
        System.out.println("Claves: " + stock.keySet());
        System.out.println("Valores: " + stock.values());
        for (Map.Entry<String, Integer> entrada : stock.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        // Caso típico: contar repeticiones. merge suma 1 si la clave existe, o pone 1 si no.
        String[] palabras = {"java", "mapa", "java", "set", "java", "mapa"};
        Map<String, Integer> conteo = new HashMap<>();
        for (String palabra : palabras) {
            conteo.merge(palabra, 1, Integer::sum);
        }
        System.out.println("Conteo de palabras: " + conteo);

        // TreeMap: igual interfaz, pero ordenado por clave y con métodos de navegación.
        TreeMap<Integer, String> notas = new TreeMap<>();
        notas.put(90, "Excelente");
        notas.put(60, "Aprobado");
        notas.put(40, "Desaprobado");
        System.out.println("TreeMap ordenado: " + notas);
        System.out.println("firstKey: " + notas.firstKey());
        System.out.println("lastKey: " + notas.lastKey());
        System.out.println("floorKey(75): " + notas.floorKey(75));     // mayor clave <= 75 -> 60
        System.out.println("ceilingKey(75): " + notas.ceilingKey(75)); // menor clave >= 75 -> 90
        System.out.println("headMap(60): " + notas.headMap(60));       // claves menores a 60
        System.out.println("tailMap(60): " + notas.tailMap(60));       // claves mayores o iguales a 60
        System.out.println("Nota 75 -> " + notas.floorEntry(75).getValue()); // rango: la que le corresponde
    }
}
