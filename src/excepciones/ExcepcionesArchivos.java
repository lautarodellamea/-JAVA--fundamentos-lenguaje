package excepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// 02. Manejo de excepciones con archivos
// Trabajar con archivos es el caso clásico de excepciones: el archivo puede no existir,
// no tener permisos, o fallar la lectura a mitad de camino. Por eso Java OBLIGA a manejarlas.
//
// Estas son excepciones CHECKED ("verificadas"): el compilador exige o un try-catch,
// o declarar con "throws" que el método las deja pasar a quien lo llama.
//
// Y además, un archivo abierto hay que CERRARLO siempre. Acá lo hacemos "a la antigua"
// (con finally) para ver el problema; en el tema 07 aparece la forma moderna (try-with-resources).
public class ExcepcionesArchivos {

    // "throws IOException": main no maneja los errores de la preparación, se los pasa a la JVM.
    public static void main(String[] args) throws IOException {
        // Preparación: se crea un archivo temporal para que el ejemplo funcione en cualquier máquina.
        Path temporal = Files.createTempFile("ejemplo", ".txt");
        Files.writeString(temporal, "Primera línea\nSegunda línea\n");

        System.out.println("--- Leer un archivo que existe ---");
        leerArchivo(temporal.toString());

        System.out.println("--- Leer un archivo que NO existe ---");
        leerArchivo("archivo_que_no_existe.txt");

        Files.deleteIfExists(temporal); // limpieza
    }

    static void leerArchivo(String ruta) {
        BufferedReader lector = null; // se declara AFUERA del try para poder cerrarlo en el finally
        try {
            lector = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println("Leí: " + linea);
            }
        } catch (FileNotFoundException e) {
            // Más ESPECÍFICA: el archivo no existe. Tiene que ir ANTES que IOException.
            System.out.println("No se encontró el archivo: " + ruta);
        } catch (IOException e) {
            // Más GENERAL: cualquier otro problema de lectura.
            // (FileNotFoundException es hija de IOException; si se invierte el orden, no compila.)
            System.out.println("Error de lectura: " + e.getMessage());
        } finally {
            // Se ejecuta siempre: acá se libera el recurso.
            if (lector != null) {
                try {
                    lector.close(); // close() también puede lanzar IOException: otro try-catch adentro
                    System.out.println("(archivo cerrado)");
                } catch (IOException e) {
                    System.out.println("Error al cerrar: " + e.getMessage());
                }
            }
        }
        // Se nota lo verboso y repetitivo que queda: el siguiente tema lo refactoriza.
    }
}
