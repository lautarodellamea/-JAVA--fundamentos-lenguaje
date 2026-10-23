package objetos;

// 10. Bloque static (ejecución)
public class ConfiguracionMain {
    public static void main(String[] args) {
        System.out.println("main arrancó: la clase Configuracion todavía NO se cargó");

        // Primer uso de la clase: la JVM la carga y corre el bloque static (una vez).
        System.out.println("Idioma: " + Configuracion.obtener("idioma"));

        // Cada new ejecuta el bloque de instancia + constructor, pero el bloque static NO se repite.
        System.out.println("--- primer objeto ---");
        new Configuracion();
        System.out.println("--- segundo objeto ---");
        new Configuracion();

        System.out.println("Moneda: " + Configuracion.obtener("moneda"));
    }
}
