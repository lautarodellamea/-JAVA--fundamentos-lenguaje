package colecciones;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

// 15. TreeMap, HashMap y LinkedHashMap
// Un Map guarda PARES clave -> valor. La clave es única y se usa para buscar el valor
// (como un diccionario o una agenda: buscás por nombre y obtenés el teléfono).
// Map NO es una Collection, es una interfaz aparte.
//
// Las tres implementaciones se diferencian igual que los Set (de hecho, por dentro un HashSet usa un HashMap):
//
//   Implementación | Orden de las claves        | Velocidad            | null como clave
//   ---------------|----------------------------|----------------------|----------------
//   HashMap        | sin orden garantizado      | la más rápida        | 1 permitida
//   LinkedHashMap  | orden de INSERCIÓN         | un poco más lenta    | 1 permitida
//   TreeMap        | ORDENADAS por clave        | la más lenta, O(log n)| no permitida
public class MapsIntroduccion {
    public static void main(String[] args) {
        // Se cargan los mismos datos en los tres para comparar.
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        String[] claves = {"Marta", "Ana", "Luis"};
        int[] edades = {33, 25, 40};
        for (int i = 0; i < claves.length; i++) {
            hashMap.put(claves[i], edades[i]);
            linkedHashMap.put(claves[i], edades[i]);
            treeMap.put(claves[i], edades[i]);
        }

        System.out.println("HashMap (sin orden garantizado): " + hashMap);
        System.out.println("LinkedHashMap (orden de inserción): " + linkedHashMap); // Marta, Ana, Luis
        System.out.println("TreeMap (ordenado por clave): " + treeMap);             // Ana, Luis, Marta

        // Comportamiento común a los tres:
        // put con una clave que ya existe REEMPLAZA el valor y devuelve el valor anterior.
        Integer anterior = hashMap.put("Ana", 26);
        System.out.println("Valor anterior de Ana: " + anterior + " | ahora: " + hashMap.get("Ana"));

        // get de una clave inexistente devuelve null (no lanza error).
        System.out.println("get de clave inexistente: " + hashMap.get("Nadie"));

        // Las claves no se repiten, los valores sí.
        hashMap.put("Pedro", 40); // el valor 40 ya lo tiene Luis
        System.out.println("Tamaño: " + hashMap.size());

        // null como clave: HashMap sí, TreeMap no.
        hashMap.put(null, 0);
        System.out.println("HashMap con clave null: " + hashMap.get(null));
        // treeMap.put(null, 0); // lanzaría NullPointerException
    }
}
