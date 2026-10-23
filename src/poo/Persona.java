package poo;

// 02. Encapsulación
// Encapsular es proteger el estado interno de un objeto: los atributos son privados
// y solo se leen o modifican por métodos públicos que controlan las reglas.
// Así el objeto nunca queda en un estado inválido (por ejemplo, una edad negativa).
public class Persona {
    private final String dni;   // final + sin setter: se asigna una vez y no cambia (inmutable)
    private String nombre;
    private int edad;

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        // Se usan los setters también en el constructor para aplicar las mismas validaciones.
        setNombre(nombre);
        setEdad(edad);
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("Edad inválida: " + edad);
        }
        this.edad = edad;
    }

    // Método con lógica: el estado interno se usa sin exponerlo directamente.
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    // @Override: es una anotación que le dice al compilador "este método SOBRESCRIBE uno heredado".
    // Todas las clases heredan de Object, que ya trae un toString() (el que imprime "poo.Persona@1b6d3586").
    // Acá lo reemplazamos por uno propio que muestra los valores de los atributos.
    // Para qué sirve escribirla: si te equivocás en el nombre o en los parámetros
    // (por ejemplo "tostring()"), el compilador marca error en vez de crear un método nuevo sin avisar.
    // Es opcional, pero se recomienda siempre. (Se verá en profundidad con herencia.)
    @Override
    public String toString() {
        return "Persona{dni='" + dni + "', nombre='" + nombre + "', edad=" + edad + "}";
    }
}
