package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

// 11. Set: HashSet CRUD
// CRUD = Create (crear), Read (leer), Update (actualizar), Delete (borrar).
// Un Set no tiene posiciones: no existe get(i) ni set(i, x). Hay que adaptar cómo se hace cada operación.
public class HashSetCrud {

    // Dos productos son iguales si tienen el mismo código (el resto de los datos puede cambiar).
    static class Producto {
        final String codigo;
        String nombre;
        double precio;

        Producto(String codigo, String nombre, double precio) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return codigo.equals(((Producto) obj).codigo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(codigo);
        }

        @Override
        public String toString() {
            return codigo + ":" + nombre + "($" + precio + ")";
        }
    }

    public static void main(String[] args) {
        Set<Producto> productos = new HashSet<>();

        // CREATE: add. Devuelve false si ya existía un producto con ese código.
        productos.add(new Producto("A1", "Mate", 1500));
        productos.add(new Producto("B2", "Yerba", 3000));
        productos.add(new Producto("C3", "Termo", 25000));
        System.out.println("add repetido (código A1): " + productos.add(new Producto("A1", "Otro", 1)));

        // READ: no hay get(i). Se recorre, o se pregunta con contains.
        System.out.println("contains B2: " + productos.contains(new Producto("B2", "", 0)));
        for (Producto p : productos) {
            System.out.println("Leído: " + p);
        }
        System.out.println("Cantidad: " + productos.size());

        // UPDATE: se busca el elemento y se modifica un campo que NO participe en equals/hashCode.
        for (Producto p : productos) {
            if (p.codigo.equals("A1")) {
                p.precio = 1800; // el precio no es parte de equals/hashCode: es seguro
            }
        }
        System.out.println("Actualizado el precio de A1");

        // Si cambia el dato que define la igualdad (acá el código), el elemento queda "perdido"
        // en el Set: se hace borrar el viejo y agregar el nuevo.
        productos.remove(new Producto("C3", "", 0));
        productos.add(new Producto("C4", "Termo grande", 30000));

        // DELETE: remove por equivalencia, removeIf por condición, clear para vaciar.
        productos.remove(new Producto("B2", "", 0));
        productos.removeIf(p -> p.precio > 20000);
        System.out.println("Después de borrar: " + productos);

        // Borrar mientras se recorre: usar Iterator (con for-each daría ConcurrentModificationException).
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            if (it.next().codigo.equals("A1")) {
                it.remove();
            }
        }
        System.out.println("¿Vacío? " + productos.isEmpty());

        productos.clear();
    }
}
