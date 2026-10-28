package colecciones;

import java.util.HashSet;
import java.util.Set;

// 09. Set: HashSet con clases wrapper
// Un Set es un conjunto: NO permite elementos repetidos.
// HashSet es la implementación más rápida: agregar, buscar y borrar son casi instantáneos,
// porque usa una tabla hash (calcula el hashCode del elemento para saber dónde guardarlo).
//
// Contra: NO garantiza ningún orden (el orden en que se imprime puede no ser el de inserción).
//
// Con wrappers (Integer, String, Double...) funciona sin configurar nada, porque esas clases
// ya sobrescriben equals() y hashCode().
public class HashSetWrapper {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>();

        // add devuelve true si lo agregó y false si ya existía.
        System.out.println("add(10): " + numeros.add(10));
        System.out.println("add(20): " + numeros.add(20));
        System.out.println("add(10) repetido: " + numeros.add(10));
        System.out.println("Conjunto: " + numeros + " | size: " + numeros.size()); // 2 elementos

        // Buscar es muy rápido.
        System.out.println("contains(20): " + numeros.contains(20));

        // Borrar
        numeros.remove(20);
        System.out.println("Después de remove(20): " + numeros);

        // Quitar repetidos de una lista de Strings: el uso más común.
        Set<String> nombres = new HashSet<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");
        System.out.println("Nombres únicos: " + nombres.size());

        // HashSet acepta un null.
        nombres.add(null);
        System.out.println("Con null: " + nombres.size());

        // Operaciones de conjuntos.
        Set<Integer> a = new HashSet<>(Set.of(1, 2, 3, 4));
        Set<Integer> b = new HashSet<>(Set.of(3, 4, 5));

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);               // unión: todo lo de a y de b
        System.out.println("Unión: " + union);

        Set<Integer> interseccion = new HashSet<>(a);
        interseccion.retainAll(b);     // intersección: lo que está en los dos
        System.out.println("Intersección: " + interseccion);

        Set<Integer> diferencia = new HashSet<>(a);
        diferencia.removeAll(b);       // diferencia: lo que está en a y no en b
        System.out.println("Diferencia (a - b): " + diferencia);

        // Nota: el orden de impresión de un HashSet puede variar. No te apoyes en él.
    }
}
