package colecciones;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

// 17. HashMap y TreeMap con clases personalizadas
// Hay dos situaciones distintas con clases propias:
//
//   A. La clase propia es el VALOR (lo más común): no se pide nada especial.
//      Ejemplo: Map<String, Empleado>, buscar un empleado por su legajo.
//
//   B. La clase propia es la CLAVE: la clave tiene que poder compararse.
//      - HashMap necesita equals() y hashCode() en la clase clave.
//      - TreeMap necesita Comparable en la clase clave, o un Comparator al crear el mapa.
public class MapPersonalizado {

    static class Empleado {
        String nombre;
        double sueldo;

        Empleado(String nombre, double sueldo) {
            this.nombre = nombre;
            this.sueldo = sueldo;
        }

        @Override
        public String toString() {
            return nombre + "($" + sueldo + ")";
        }
    }

    // Clase pensada para ser CLAVE: inmutable y con equals/hashCode/compareTo.
    // Atajo en IntelliJ para equals y hashCode: Alt + Insert > "equals() and hashCode()".
    static class Coordenada implements Comparable<Coordenada> {
        final int x;
        final int y;

        Coordenada(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Coordenada otra = (Coordenada) obj;
            return x == otra.x && y == otra.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Coordenada otra) {
            int porX = Integer.compare(x, otra.x);
            return porX != 0 ? porX : Integer.compare(y, otra.y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    // Clave SIN equals/hashCode, para mostrar el problema.
    static class ClaveRota {
        int id;

        ClaveRota(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        // A. Objeto propio como VALOR: se busca por la clave (legajo).
        Map<String, Empleado> empleados = new HashMap<>();
        empleados.put("L-001", new Empleado("Ana", 500000));
        empleados.put("L-002", new Empleado("Luis", 450000));
        System.out.println("Buscar L-002: " + empleados.get("L-002"));

        // Modificar el objeto guardado: se obtiene y se cambia (la referencia es la misma).
        empleados.get("L-001").sueldo = 550000;
        System.out.println("Ana con aumento: " + empleados.get("L-001"));

        // El mismo mapa ordenado por legajo.
        Map<String, Empleado> ordenado = new TreeMap<>(empleados);
        System.out.println("TreeMap por legajo: " + ordenado);

        // B. Objeto propio como CLAVE en HashMap: con equals/hashCode funciona por contenido.
        Map<Coordenada, String> mapa = new HashMap<>();
        mapa.put(new Coordenada(1, 2), "Tesoro");
        System.out.println("get con coordenada equivalente: " + mapa.get(new Coordenada(1, 2))); // Tesoro

        // Sin equals/hashCode, la misma clave "equivalente" no se encuentra.
        Map<ClaveRota, String> roto = new HashMap<>();
        roto.put(new ClaveRota(1), "valor");
        System.out.println("get con clave sin equals/hashCode: " + roto.get(new ClaveRota(1))); // null

        // B. Objeto propio como CLAVE en TreeMap: usa compareTo (Comparable).
        Map<Coordenada, String> ordenadas = new TreeMap<>();
        ordenadas.put(new Coordenada(3, 1), "C");
        ordenadas.put(new Coordenada(1, 5), "A");
        ordenadas.put(new Coordenada(1, 2), "B");
        System.out.println("TreeMap ordenado por x y luego y: " + ordenadas);

        // O con un Comparator, sin necesidad de que la clase sea Comparable.
        Map<Empleado, String> porSueldo = new TreeMap<>(Comparator.comparingDouble(e -> e.sueldo));
        porSueldo.put(new Empleado("Ana", 550000), "Gerencia");
        porSueldo.put(new Empleado("Luis", 450000), "Ventas");
        System.out.println("TreeMap ordenado por sueldo: " + porSueldo);

        // Regla práctica: usá claves INMUTABLES. Si cambiás un campo de la clave después de
        // insertarla, el mapa ya no la encuentra donde la guardó.
    }
}
