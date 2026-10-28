package colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 08. Entendiendo el método equals()
//
// equals() responde: "¿estos dos objetos son IGUALES?"
// - == compara REFERENCIAS: ¿son exactamente el mismo objeto en memoria?
// - equals() compara el CONTENIDO... pero solo si la clase lo define.
//   Si no lo sobrescribís, Object.equals() se comporta igual que == (compara referencias).
//
// Es clave para las colecciones: contains(), indexOf(), remove(objeto) y los Set
// usan equals() para decidir si dos elementos son "el mismo".
public class MetodoEquals {

    // Sin equals: hereda el de Object (compara referencias).
    static class PersonaSinEquals {
        String nombre;
        int edad;

        PersonaSinEquals(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
    }

    // Con equals: dos personas son iguales si tienen el mismo nombre y edad.
    static class PersonaConEquals {
        String nombre;
        int edad;

        PersonaConEquals(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;                       // mismo objeto: seguro iguales
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;                      // null o de otra clase: distintos
            }
            PersonaConEquals otra = (PersonaConEquals) obj;
            return edad == otra.edad && Objects.equals(nombre, otra.nombre);
        }

        // ATAJO EN INTELLIJ: no hace falta escribir equals y hashCode a mano.
        // Con el cursor dentro de la clase: Alt + Insert > "equals() and hashCode()"
        // (o clic derecho > Generate...). Se eligen los atributos que definen la igualdad y lo genera.
        // En Mac: Cmd + N.
        //
        // Regla de oro: si sobrescribís equals, sobrescribí también hashCode.
        // Dos objetos iguales DEBEN dar el mismo hashCode (lo necesitan HashSet y HashMap).
        @Override
        public int hashCode() {
            return Objects.hash(nombre, edad);
        }
    }

    public static void main(String[] args) {
        // Con String y wrappers ya funciona por contenido (sus clases sobrescriben equals).
        String a = new String("hola");
        String b = new String("hola");
        System.out.println("String == : " + (a == b));          // false (objetos distintos)
        System.out.println("String equals: " + a.equals(b));    // true  (mismo contenido)

        // Con una clase propia SIN equals: iguales en contenido, pero distintos para Java.
        PersonaSinEquals p1 = new PersonaSinEquals("Ana", 30);
        PersonaSinEquals p2 = new PersonaSinEquals("Ana", 30);
        System.out.println("Sin equals: " + p1.equals(p2));     // false

        // Con equals sobrescrito: se comparan por contenido.
        PersonaConEquals c1 = new PersonaConEquals("Ana", 30);
        PersonaConEquals c2 = new PersonaConEquals("Ana", 30);
        PersonaConEquals c3 = new PersonaConEquals("Luis", 25);
        System.out.println("Con equals (mismos datos): " + c1.equals(c2));  // true
        System.out.println("Con equals (distintos datos): " + c1.equals(c3)); // false
        System.out.println("equals(null): " + c1.equals(null));              // false, nunca lanza error

        // Consecuencia en las colecciones: contains() usa equals().
        List<PersonaSinEquals> sin = new ArrayList<>();
        sin.add(new PersonaSinEquals("Ana", 30));
        System.out.println("contains sin equals: " + sin.contains(new PersonaSinEquals("Ana", 30))); // false

        List<PersonaConEquals> con = new ArrayList<>();
        con.add(new PersonaConEquals("Ana", 30));
        System.out.println("contains con equals: " + con.contains(new PersonaConEquals("Ana", 30))); // true

        // Contrato de equals: reflexivo (x.equals(x)), simétrico (x.equals(y) <-> y.equals(x)),
        // transitivo y consistente. Objects.equals(a, b) es una versión que tolera null.
    }
}
