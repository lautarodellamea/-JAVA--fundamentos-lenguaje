package excepciones;

import java.io.FileNotFoundException;
import java.io.IOException;

// 04. Jerarquía de excepciones
// Todas las excepciones son clases y forman un árbol de herencia:
//
//   Object
//    └── Throwable                       <- todo lo que se puede lanzar con throw
//         ├── Error                      <- fallas GRAVES de la JVM (no se deberían capturar)
//         │    ├── StackOverflowError
//         │    └── OutOfMemoryError
//         └── Exception                  <- problemas que el programa puede atender
//              ├── IOException           <- CHECKED  (el compilador obliga a manejarlas)
//              │    └── FileNotFoundException
//              ├── (otras checked...)
//              └── RuntimeException      <- UNCHECKED (el compilador NO obliga)
//                   ├── ArithmeticException
//                   ├── NullPointerException
//                   ├── IllegalArgumentException
//                   │    └── NumberFormatException
//                   └── IndexOutOfBoundsException
//
// Resumen:
//   Error                -> no capturar; algo grave pasó en la JVM.
//   Checked              -> Exception que NO es RuntimeException. Hay que manejarlas o declararlas con throws.
//   Unchecked            -> RuntimeException y sus hijas. Suelen ser errores de programación (bugs).
//
// Como es herencia, capturar una clase padre captura también a todas sus hijas.
//
// ¿EL COMPILADOR ME OBLIGA A CONTROLARLAS?
//
//   CHECKED (Exception que no es RuntimeException, ej: IOException, FileNotFoundException): SÍ.
//     Si llamás a algo que puede lanzarla, tenés que hacer UNA de estas dos cosas, sí o sí:
//       a) capturarla con try-catch, o
//       b) declararla con "throws" en tu método, para que la maneje quien te llama.
//     Si no hacés ninguna de las dos, el código NO COMPILA:
//       "unreported exception FileNotFoundException; must be caught or declared to be thrown".
//
//   UNCHECKED (RuntimeException y sus hijas, ej: ArithmeticException, NullPointerException): NO.
//     El compilador no te pide nada: el código compila igual, con o sin try-catch.
//     Pero ojo: "no obliga" NO significa "no puede pasar". Si ocurre y nadie la captura,
//     el programa se corta en ejecución con un error y el stack trace.
//
//   ERROR (StackOverflowError, OutOfMemoryError): tampoco obliga, y no se debería capturar.
//
//   Lo que SÍ se puede hacer siempre: capturar una unchecked de forma voluntaria cuando sabés cómo
//   reaccionar (por ejemplo, avisarle al usuario que escribió un número mal). Y declarar una unchecked
//   con "throws" también es válido, pero innecesario.
//
//   Resumen: la diferencia es cuándo te avisa el problema.
//     checked   -> te frena al COMPILAR si te olvidás de manejarla.
//     unchecked -> no te frena al compilar; si te olvidás, falla al EJECUTAR.
public class JerarquiaExcepciones {
    public static void main(String[] args) {
        // Comprobalo descomentando estas líneas, una por una:
        //
        // new java.io.FileReader("archivo.txt");  // checked: NO COMPILA (hay que manejarla o declarar throws)
        // int resultado = 10 / 0;                 // unchecked: compila bien, pero falla al ejecutar

        // Se puede recorrer la herencia de una excepción con getSuperclass().
        imprimirJerarquia(new ArithmeticException());
        imprimirJerarquia(new NumberFormatException());
        imprimirJerarquia(new FileNotFoundException());
        imprimirJerarquia(new StackOverflowError());

        System.out.println("-----");

        // ORDEN de los catch: de lo más ESPECÍFICO a lo más GENERAL.
        // Si la general va primero, la específica nunca se alcanza y el compilador lo marca como error.
        try {
            Integer.parseInt("xyz");
        } catch (NumberFormatException e) {
            System.out.println("Capturada por la específica: NumberFormatException");
        } catch (IllegalArgumentException e) {
            System.out.println("Capturada por la intermedia (no llega acá)");
        } catch (Exception e) {
            System.out.println("Capturada por la general (no llega acá)");
        }

        // Capturar la clase padre sirve para tratar varias hijas igual.
        try {
            lanzarIOException();
        } catch (IOException e) {
            // Atrapa IOException y también FileNotFoundException, que es su hija.
            System.out.println("IOException atrapa a su hija: " + e.getClass().getSimpleName());
        }

        // Los Error no se capturan en código normal: se muestran solo para ver que existen.
        try {
            recursionInfinita();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError: la pila de llamadas se llenó (recursión sin fin)");
        }

        // Evitar: catch (Exception e) {} o catch (Throwable t) {} vacíos para "que no moleste".
        // Tapan bugs reales. Capturá lo más específico que sepas manejar.
    }

    static void imprimirJerarquia(Throwable excepcion) {
        StringBuilder cadena = new StringBuilder();
        Class<?> clase = excepcion.getClass();
        while (clase != null) {
            cadena.append(clase.getSimpleName());
            clase = clase.getSuperclass();
            if (clase != null) {
                cadena.append(" -> ");
            }
        }
        System.out.println(cadena);
    }

    static void lanzarIOException() throws IOException {
        throw new FileNotFoundException("no está el archivo");
    }

    static void recursionInfinita() {
        recursionInfinita();
    }
}
