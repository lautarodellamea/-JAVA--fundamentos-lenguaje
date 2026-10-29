package excepciones;

// 06. Exception personalizada: tipo unchecked
// Se crea heredando de RuntimeException. El compilador NO obliga a manejarla ni a declararla con throws.
//
// Cuándo usar unchecked: cuando el error indica un BUG o un uso incorrecto del código
// (argumento inválido, estado imposible) y el que llama normalmente no puede "arreglarlo" en ejecución.
// También cuando no queremos llenar de try-catch o throws todo el código.
//
// Checked vs unchecked, en pocas palabras:
//
//                        | checked (extends Exception) | unchecked (extends RuntimeException)
//   ---------------------|-----------------------------|---------------------------------------
//   ¿Obliga a manejarla? | Sí (try-catch o throws)     | No
//   Uso típico           | error esperable y recuperable | error de programación / uso incorrecto
//   Ejemplos de Java     | IOException                 | NullPointerException, IllegalArgumentException
public class ExcepcionUncheckedPersonalizada {

    // Hereda de RuntimeException -> unchecked.
    static class EdadInvalidaException extends RuntimeException {
        private final int edad;

        EdadInvalidaException(int edad) {
            super("Edad inválida: " + edad + " (debe estar entre 0 y 120)");
            this.edad = edad;
        }

        int getEdad() {
            return edad;
        }
    }

    static class Persona {
        private final String nombre;
        private final int edad;

        // Sin "throws" en la firma: no hace falta. Igual se recomienda documentarla en el comentario.
        Persona(String nombre, int edad) {
            if (edad < 0 || edad > 120) {
                throw new EdadInvalidaException(edad);
            }
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return nombre + " (" + edad + ")";
        }
    }

    public static void main(String[] args) {
        // Se puede usar sin ningún try-catch: compila igual.
        Persona valida = new Persona("Ana", 30);
        System.out.println("Creada: " + valida);

        // Si se lanza y nadie la captura, el programa se corta. Esta línea lo haría:
        // new Persona("Luis", -5); // Exception in thread "main" EdadInvalidaException: ...

        // Se captura solo si de verdad se puede reaccionar (por ejemplo, validar datos de un formulario).
        try {
            new Persona("Luis", -5);
        } catch (EdadInvalidaException e) {
            System.out.println("No se pudo crear la persona: " + e.getMessage());
            System.out.println("Edad recibida: " + e.getEdad());
        }

        // Antes de crear una excepción propia, fijate si alguna de Java ya sirve:
        //   IllegalArgumentException -> "el argumento que me pasaste no es válido"
        //   IllegalStateException    -> "el objeto no está en un estado donde se puede hacer esto"
        //   UnsupportedOperationException, NullPointerException (Objects.requireNonNull)...
        try {
            exigirPositivo(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción de Java: " + e.getMessage());
        }
    }

    static void exigirPositivo(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("se esperaba un número positivo y llegó " + numero);
        }
    }
}
