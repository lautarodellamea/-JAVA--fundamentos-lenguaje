package objetos;

// 08. Atributo static VS atributo de instancia (ejecución)
public class EmpleadoMain {
    public static void main(String[] args) {
        // Un static se puede usar sin crear ningún objeto: se accede por el nombre de la clase.
        System.out.println("Empleados al inicio: " + Empleado.cantidadEmpleados);
        System.out.println("Empresa: " + Empleado.EMPRESA);

        Empleado ana = new Empleado("Ana");
        Empleado luis = new Empleado("Luis");
        Empleado marta = new Empleado("Marta");

        // Instancia: cada objeto tiene su propio id y nombre.
        System.out.println(ana);
        System.out.println(luis);
        System.out.println(marta);

        // Static: una sola copia, el valor es el mismo lo mires desde donde lo mires.
        System.out.println("Total de empleados: " + Empleado.cantidadEmpleados);

        // Cambiar un atributo de instancia afecta solo a ese objeto.
        ana.nombre = "Ana María";
        System.out.println("ana: " + ana.nombre + " | luis: " + luis.nombre);

        // Cambiar un static afecta a todos (por eso hay que tener cuidado).
        // Acceder a un static desde un objeto compila, pero engaña: mejor siempre por la clase.
        // ana.cantidadEmpleados = 100; // compila, pero cambia el valor para TODOS
        System.out.println("Visto desde marta: " + marta.cantidadEmpleados);
    }
}
