package excepciones;

// 08. try-with-resources con AutoCloseable
// try-with-resources funciona con CUALQUIER clase que implemente la interfaz AutoCloseable,
// no solo con las de archivos. Esa interfaz tiene un único método:
//
//   void close() throws Exception;
//
// Al terminar el try (bien o con error), Java llama a close() de cada recurso.
// Sirve para cualquier cosa que haya que "soltar": conexiones, bloqueos, medidores de tiempo...
//
// (Closeable es una variante para recursos de entrada/salida: su close() lanza IOException.)
public class AutoCloseableEjemplo {

    // Recurso propio: implementa AutoCloseable.
    static class Conexion implements AutoCloseable {
        private final String nombre;

        Conexion(String nombre) {
            this.nombre = nombre;
            System.out.println("Abriendo conexión " + nombre);
        }

        void consultar(String consulta) {
            System.out.println("[" + nombre + "] ejecutando: " + consulta);
        }

        @Override
        public void close() { // se puede quitar el "throws Exception" al sobrescribir
            System.out.println("Cerrando conexión " + nombre);
        }
    }

    // Recurso cuyo cierre falla, para ver qué pasa con dos errores a la vez.
    static class ConexionProblematica implements AutoCloseable {
        @Override
        public void close() {
            throw new IllegalStateException("falló el cierre");
        }
    }

    public static void main(String[] args) {
        // 1. Uso normal: se abre, se usa y se cierra solo.
        try (Conexion conexion = new Conexion("BD-1")) {
            conexion.consultar("SELECT * FROM usuarios");
        }

        System.out.println("-----");

        // 2. Con varios recursos: se cierran en orden inverso (BD-3 y después BD-2).
        try (Conexion primera = new Conexion("BD-2");
             Conexion segunda = new Conexion("BD-3")) {
            primera.consultar("consulta A");
            segunda.consultar("consulta B");
        }

        System.out.println("-----");

        // 3. Con una excepción adentro: el recurso se cierra igual ANTES de entrar al catch.
        try (Conexion conexion = new Conexion("BD-4")) {
            conexion.consultar("consulta que falla");
            throw new RuntimeException("falló la consulta");
        } catch (RuntimeException e) {
            System.out.println("Capturada: " + e.getMessage() + " (la conexión ya está cerrada)");
        }

        System.out.println("-----");

        // 4. Dos errores a la vez: falla el cuerpo y también el close().
        // La excepción PRINCIPAL es la del cuerpo; la del cierre queda "suprimida" dentro de ella.
        try (ConexionProblematica recurso = new ConexionProblematica()) {
            throw new RuntimeException("falló el cuerpo");
        } catch (RuntimeException e) {
            System.out.println("Principal: " + e.getMessage());
            for (Throwable suprimida : e.getSuppressed()) {
                System.out.println("Suprimida: " + suprimida.getMessage());
            }
        }
    }
}
