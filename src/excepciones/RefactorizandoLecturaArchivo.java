package excepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

// 03. Refactorizando ejemplo de lectura de archivo
// En el tema anterior un solo método hacía TODO: abrir, leer, mostrar, manejar errores y cerrar.
// Refactorizar = mejorar el código sin cambiar lo que hace. Acá aplicamos dos ideas:
//
//   1. SEPARAR responsabilidades:
//        - un método que LEE y, si falla, deja pasar la excepción (throws);
//        - otro método que decide QUÉ HACER con el error (el que conoce el contexto).
//   2. Usar las clases modernas (java.nio.file.Files), que abren y cierran el archivo solas.
//
// Regla práctica: se maneja la excepción donde se sabe qué hacer con ella.
// Un método de bajo nivel normalmente no sabe si conviene avisar al usuario, reintentar o abortar.
public class RefactorizandoLecturaArchivo {

    public static void main(String[] args) throws IOException {
        Path temporal = Files.createTempFile("ejemplo", ".txt");
        Files.writeString(temporal, "Primera línea\nSegunda línea\nTercera línea\n");

        mostrarArchivo(temporal);
        mostrarArchivo(Path.of("archivo_que_no_existe.txt"));

        Files.deleteIfExists(temporal);
    }

    // Capa de LECTURA: hace una sola cosa y no decide qué hacer ante el error.
    // "throws IOException" avisa que puede fallar y obliga a quien lo llame a decidir.
    static List<String> leerLineas(Path ruta) throws IOException {
        return Files.readAllLines(ruta); // abre, lee y cierra el archivo por su cuenta
    }

    // Capa de USO: sabe qué mostrarle al usuario según el tipo de error.
    static void mostrarArchivo(Path ruta) {
        try {
            List<String> lineas = leerLineas(ruta);
            System.out.println("Archivo con " + lineas.size() + " líneas:");
            lineas.forEach(linea -> System.out.println("  " + linea));
        } catch (NoSuchFileException e) {
            // Más específica: el archivo no existe.
            System.out.println("No existe el archivo: " + ruta);
        } catch (IOException e) {
            // Cualquier otro problema de entrada/salida.
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

    // Comparación con el tema 02:
    //   Antes:   ~25 líneas, variable declarada afuera, finally con otro try-catch, todo mezclado.
    //   Ahora:   un método de 1 línea que lee y otro que decide qué mostrar; sin cierre manual.
}
