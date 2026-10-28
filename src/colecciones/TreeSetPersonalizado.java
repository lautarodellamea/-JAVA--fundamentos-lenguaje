package colecciones;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

// 14. Set: TreeSet con clases personalizadas
// Para ordenar objetos propios, TreeSet necesita saber CÓMO compararlos. Hay dos maneras:
//
//   1. Comparable: la propia clase implementa compareTo() -> ese es su "orden natural".
//   2. Comparator: un criterio externo que se le pasa al TreeSet al crearlo.
//
// compareTo(otro) devuelve: negativo si this va ANTES, 0 si son "iguales", positivo si va DESPUÉS.
//
// CUIDADO: TreeSet considera repetidos a los que dan compareTo == 0, aunque sean objetos distintos.
public class TreeSetPersonalizado {

    // Orden natural: por edad (de menor a mayor).
    static class Persona implements Comparable<Persona> {
        String nombre;
        int edad;

        Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public int compareTo(Persona otra) {
            return Integer.compare(this.edad, otra.edad);
        }

        @Override
        public String toString() {
            return nombre + "(" + edad + ")";
        }
    }

    // Una clase que NO implementa Comparable.
    static class Libro {
        String titulo;

        Libro(String titulo) {
            this.titulo = titulo;
        }

        @Override
        public String toString() {
            return titulo;
        }
    }

    public static void main(String[] args) {
        // 1. Comparable: el TreeSet usa compareTo de Persona.
        Set<Persona> personas = new TreeSet<>();
        personas.add(new Persona("Luis", 40));
        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Marta", 33));
        System.out.println("Por edad (Comparable): " + personas);

        // Trampa: comparar solo por edad hace que dos personas distintas con igual edad "se pisen".
        personas.add(new Persona("Otra Ana", 25));
        System.out.println("Con edad repetida: " + personas.size() + " elementos (la 'Otra Ana' no entró)");

        // 2. Comparator: otro criterio, sin tocar la clase. Acá por nombre.
        Set<Persona> porNombre = new TreeSet<>(Comparator.comparing(p -> p.nombre));
        porNombre.add(new Persona("Luis", 40));
        porNombre.add(new Persona("Ana", 25));
        porNombre.add(new Persona("Marta", 33));
        System.out.println("Por nombre (Comparator): " + porNombre);

        // Comparator con desempate: primero edad, y si empatan, por nombre. Ahora no se pierde ninguna.
        Set<Persona> edadYNombre = new TreeSet<>(
                Comparator.comparingInt((Persona p) -> p.edad).thenComparing(p -> p.nombre));
        edadYNombre.add(new Persona("Ana", 25));
        edadYNombre.add(new Persona("Otra Ana", 25));
        edadYNombre.add(new Persona("Luis", 40));
        System.out.println("Edad y nombre: " + edadYNombre);

        // Sin Comparable ni Comparator, falla en ejecución.
        Set<Libro> libros = new TreeSet<>();
        try {
            libros.add(new Libro("Martín Fierro"));
        } catch (ClassCastException e) {
            System.out.println("Libro no es Comparable: " + e.getClass().getSimpleName());
        }
    }
}
