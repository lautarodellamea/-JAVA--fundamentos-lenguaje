package objetos;

// 08. Atributo static VS atributo de instancia
public class Empleado {
    // static: pertenece a la CLASE. Hay una sola copia compartida por todos los objetos.
    static int cantidadEmpleados = 0;
    static final String EMPRESA = "Acme S.A."; // static + final: una constante compartida

    // Instancia: pertenece a cada OBJETO. Cada empleado tiene su propia copia.
    int id;
    String nombre;

    Empleado(String nombre) {
        // Cada vez que se crea un objeto, el contador compartido sube y el id toma ese valor.
        cantidadEmpleados++;
        this.id = cantidadEmpleados;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{id=" + id + ", nombre='" + nombre + "', empresa='" + EMPRESA + "'}";
    }
}
