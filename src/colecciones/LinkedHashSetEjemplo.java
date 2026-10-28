package colecciones;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// 12. LinkedHashSet con clases wrapper y clases personalizadas
// LinkedHashSet = HashSet + ORDEN DE INSERCIÓN.
// Sigue sin permitir repetidos, pero recuerda en qué orden agregaste los elementos
// (por dentro mantiene una lista enlazada que une los elementos).
//
// Comparación:
//   HashSet        -> sin orden garantizado, el más rápido.
//   LinkedHashSet  -> orden de inserción, un poco más lento y con algo más de memoria.
//   TreeSet        -> orden por valor (ordenado), el más lento de los tres (se ve a continuación).
public class LinkedHashSetEjemplo {

    static class Ciudad {
        String nombre;
        String pais;

        Ciudad(String nombre, String pais) {
            this.nombre = nombre;
            this.pais = pais;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Ciudad otra = (Ciudad) obj;
            return Objects.equals(nombre, otra.nombre) && Objects.equals(pais, otra.pais);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre, pais);
        }

        @Override
        public String toString() {
            return nombre + " (" + pais + ")";
        }
    }

    public static void main(String[] args) {
        // Con wrappers: mantiene el orden en que se agregó, y descarta el repetido.
        Set<Integer> numeros = new LinkedHashSet<>();
        numeros.add(30);
        numeros.add(10);
        numeros.add(20);
        numeros.add(10); // repetido, se ignora y NO cambia el orden
        System.out.println("LinkedHashSet<Integer>: " + numeros); // [30, 10, 20]

        // Para comparar: un HashSet con los mismos datos puede mostrarlos en otro orden.
        Set<Integer> hash = new HashSet<>(numeros);
        System.out.println("HashSet<Integer> (orden no garantizado): " + hash);

        // Con clases personalizadas: igual que HashSet, necesita equals y hashCode.
        Set<Ciudad> ciudades = new LinkedHashSet<>();
        ciudades.add(new Ciudad("Rosario", "Argentina"));
        ciudades.add(new Ciudad("Lima", "Perú"));
        ciudades.add(new Ciudad("Rosario", "Argentina")); // repetida: se descarta
        ciudades.add(new Ciudad("Quito", "Ecuador"));

        for (Ciudad ciudad : ciudades) {
            System.out.println("Ciudad: " + ciudad);
        }
        System.out.println("Cantidad: " + ciudades.size());
    }
}
