package excepciones;

// 09. Debugging de excepciones
// Cuando falla algo, hay dos herramientas: LEER bien el stack trace y usar el DEBUGGER.
//
// 1. CÓMO LEER UN STACK TRACE
//
//      Exception in thread "main" java.lang.IllegalStateException: No se pudo procesar el pedido
//          at excepciones.DebuggingExcepciones.procesarPedido(DebuggingExcepciones.java:NN)   <- dónde se lanzó ESTA
//          at excepciones.DebuggingExcepciones.main(DebuggingExcepciones.java:NN)             <- quién la llamó
//      Caused by: java.lang.ArithmeticException: / by zero                                    <- la causa original
//          at excepciones.DebuggingExcepciones.calcularPromedio(DebuggingExcepciones.java:NN) <- acá nació el bug
//
//    - La primera línea dice QUÉ excepción es y su mensaje.
//    - Cada "at ..." es un método de la pila de llamadas: la de arriba es la más reciente.
//    - El archivo y el número de línea llevan al lugar exacto (en IntelliJ son links clickeables).
//    - "Caused by" es la causa raíz. Si hay varias, la ÚLTIMA (la de más abajo) suele ser el origen real.
//
// 2. DEBUGGER DE INTELLIJ (atajos con el keymap por defecto de Windows/Linux)
//
//    - Breakpoint (punto de corte): clic en el margen izquierdo, junto al número de línea (o Ctrl + F8).
//    - Ejecutar en modo debug: Shift + F9 (o clic derecho > Debug). El programa se detiene en el breakpoint.
//    - F8  : Step Over  -> ejecuta la línea actual sin entrar en los métodos que llame.
//    - F7  : Step Into  -> entra dentro del método que se llama en la línea actual.
//    - Shift + F8 : Step Out -> termina el método actual y vuelve al que lo llamó.
//    - F9  : Resume     -> sigue hasta el próximo breakpoint.
//    - Alt + F8 : Evaluate Expression -> probar expresiones con las variables actuales.
//    - Ctrl + Shift + F8 : ver todos los breakpoints y crear EXCEPTION BREAKPOINTS:
//      se detiene justo cuando se lanza una excepción de un tipo elegido, aunque se vaya a capturar.
//    - Panel "Variables": valores actuales. Panel "Frames": la pila de llamadas, para subir y bajar por ella.
//    - Breakpoint condicional: clic derecho sobre el breakpoint y escribir una condición (por ejemplo, i == 3).
//
//    Probalo: poné un breakpoint en la línea "return total / cantidad;" y corré en modo debug.
public class DebuggingExcepciones {

    public static void main(String[] args) {
        try {
            procesarPedido(new int[]{100, 200, 300}, 0);
        } catch (IllegalStateException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Causa: " + e.getCause());

            // Se puede recorrer la pila por código: cada elemento es un método.
            System.out.println("Pila de llamadas (de más reciente a más antigua):");
            for (StackTraceElement elemento : e.getStackTrace()) {
                System.out.println("  " + elemento.getMethodName() + " (línea " + elemento.getLineNumber() + ")");
            }

            // La causa también tiene su propia pila: ahí está el origen real.
            Throwable causa = e.getCause();
            System.out.println("Origen real: " + causa.getStackTrace()[0].getMethodName()
                    + " (línea " + causa.getStackTrace()[0].getLineNumber() + ")");

            // printStackTrace imprime todo junto, con los "Caused by". Útil mientras se desarrolla.
            // En una aplicación real se usa un logger (por ejemplo, java.util.logging) en vez de imprimir.
            System.out.println("--- printStackTrace ---");
            e.printStackTrace(System.out);
        }
    }

    static void procesarPedido(int[] precios, int cantidad) {
        try {
            double promedio = calcularPromedio(precios, cantidad);
            System.out.println("Promedio: " + promedio);
        } catch (ArithmeticException e) {
            // Se envuelve la excepción técnica en una más clara, SIN perder la causa (segundo parámetro).
            throw new IllegalStateException("No se pudo procesar el pedido", e);
        }
    }

    static double calcularPromedio(int[] precios, int cantidad) {
        int total = 0;
        for (int precio : precios) {
            total += precio;
        }
        return total / cantidad; // acá nace el bug: cantidad vale 0
    }
}
