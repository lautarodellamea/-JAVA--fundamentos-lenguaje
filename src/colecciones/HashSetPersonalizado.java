package colecciones;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 10. Set: HashSet con clases personalizadas
// Un HashSet decide si dos elementos son "el mismo" usando hashCode() y equals().
// Con clases propias hay que sobrescribir AMBOS, si no el Set deja pasar repetidos.
//
// Cómo trabaja HashSet al hacer add(x):
//   1. Calcula x.hashCode() para elegir un "casillero".
//   2. Si en ese casillero ya hay algo con el mismo hashCode, usa equals() para ver si son iguales.
//   3. Si son iguales, lo rechaza. Si no, lo guarda.
public class HashSetPersonalizado {

    // Sin equals ni hashCode: cada objeto es único para Java.
    static class AlumnoSinEquals {
        String nombre;
        int legajo;

        AlumnoSinEquals(String nombre, int legajo) {
            this.nombre = nombre;
            this.legajo = legajo;
        }
    }

    // Con equals y hashCode: dos alumnos son iguales si tienen el mismo legajo.
    // Atajo en IntelliJ para generarlos: Alt + Insert > "equals() and hashCode()"
    // (en el asistente, elegir solo los atributos que definen la igualdad, acá "legajo").
    static class Alumno {
        String nombre;
        int legajo;

        Alumno(String nombre, int legajo) {
            this.nombre = nombre;
            this.legajo = legajo;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Alumno otro = (Alumno) obj;
            return legajo == otro.legajo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(legajo);
        }

        @Override
        public String toString() {
            return nombre + " (" + legajo + ")";
        }
    }

    public static void main(String[] args) {
        // Sin equals/hashCode: el mismo alumno "dos veces" entra como si fueran distintos.
        Set<AlumnoSinEquals> malo = new HashSet<>();
        malo.add(new AlumnoSinEquals("Ana", 1));
        malo.add(new AlumnoSinEquals("Ana", 1));
        System.out.println("Sin equals/hashCode: " + malo.size() + " elementos (repetido colado)"); // 2

        // Con equals/hashCode: el segundo se rechaza.
        Set<Alumno> bueno = new HashSet<>();
        System.out.println("add Ana: " + bueno.add(new Alumno("Ana", 1)));
        System.out.println("add Ana repetida: " + bueno.add(new Alumno("Ana", 1)));
        System.out.println("add Luis: " + bueno.add(new Alumno("Luis", 2)));
        System.out.println("Con equals/hashCode: " + bueno.size() + " elementos");

        // contains y remove también usan equals/hashCode: sirve un objeto "equivalente".
        System.out.println("contains legajo 2: " + bueno.contains(new Alumno("cualquiera", 2)));
        bueno.remove(new Alumno("cualquiera", 1));
        System.out.println("Después de remove legajo 1: " + bueno);
    }
}
