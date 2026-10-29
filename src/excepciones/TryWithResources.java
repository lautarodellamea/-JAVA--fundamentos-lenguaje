package excepciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// 07. Exception con try-with-resources
// Un "recurso" es algo que hay que CERRAR después de usar (archivo, conexión, socket...).
// try-with-resources se encarga de cerrarlo AUTOMÁTICAMENTE, haya o no excepción,
// sin necesidad de escribir el finally del tema 02.
//
// Sintaxis: los recursos se declaran entre paréntesis después del try.
//
//   try (Recurso r = new Recurso()) {
//       // usar r
//   } catch (Exception e) {
//       // r ya está cerrado cuando se llega acá
//   }
//
// Requisito: el recurso tiene que implementar AutoCloseable (los de Java para archivos ya lo hacen).
public class TryWithResources {

    public static void main(String[] args) throws IOException {
        Path origen = Files.createTempFile("origen", ".txt");
        Path destino = Files.createTempFile("destino", ".txt");

        // Escribir: el BufferedWriter se cierra solo al terminar el bloque.
        try (BufferedWriter escritor = Files.newBufferedWriter(origen)) {
            escritor.write("hola\n");
            escritor.write("mundo\n");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }

        // Varios recursos: se separan con punto y coma y se cierran en ORDEN INVERSO al de apertura
        // (primero el último abierto).
        try (BufferedReader lector = Files.newBufferedReader(origen);
             BufferedWriter escritor = Files.newBufferedWriter(destino)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                escritor.write(linea.toUpperCase());
                escritor.newLine();
            }
            System.out.println("Copiado en mayúsculas");
        } catch (IOException e) {
            System.out.println("Error al copiar: " + e.getMessage());
        }

        System.out.println("Resultado: " + Files.readAllLines(destino)); // [HOLA, MUNDO]

        // Comparación:
        //   Con finally (tema 02): variable afuera, if (x != null), try-catch dentro del finally para cerrar.
        //   Con try-with-resources: una sola estructura, sin cierre manual y sin olvidos posibles.
        //
        // Ventaja extra: si falla el try Y falla el cierre, se conserva la excepción PRINCIPAL y la del cierre
        // queda como "suprimida" (se ve en el tema 08). Con finally, la del cierre pisaba a la original.

        // Desde Java 9 se puede usar una variable ya declarada si no se reasigna (effectively final):
        BufferedReader yaDeclarado = Files.newBufferedReader(destino);
        try (yaDeclarado) {
            System.out.println("Primera línea: " + yaDeclarado.readLine());
        }

        Files.deleteIfExists(origen);
        Files.deleteIfExists(destino);
    }
}
