package excepciones;

// 01. Conceptos básicos de excepciones
//
// Una EXCEPCIÓN es un evento que interrumpe el flujo normal del programa cuando algo sale mal
// (dividir por cero, abrir un archivo que no existe, usar un null...).
// Si nadie la atiende, el programa se corta y muestra el error. Si la atendemos, podemos reaccionar
// (avisar, reintentar, usar un valor por defecto) y el programa sigue.
//
// Estructura básica:
//
//   try {
//       // código que PUEDE fallar
//   } catch (TipoDeExcepcion e) {
//       // qué hacer si falla
//   } finally {
//       // se ejecuta SIEMPRE, haya o no error  (ideal para liberar recursos)
//   }
public class ExcepcionesBasicas {
    public static void main(String[] args) {
        // 1. Sin manejar: la línea de abajo cortaría el programa con ArithmeticException.
        // int resultado = 10 / 0;

        // 2. try-catch: capturamos el error y el programa continúa.
        try {
            int resultado = 10 / 0;
            System.out.println("Esta línea no se ejecuta, el error salta antes: " + resultado);
        } catch (ArithmeticException e) {
            // e.getMessage() describe qué pasó.
            System.out.println("Error aritmético: " + e.getMessage());
        }
        System.out.println("El programa sigue funcionando");

        // 3. Varios catch: se evalúan en orden, entra el PRIMERO que coincide.
        String[] datos = {"42", "abc", null};
        for (String dato : datos) {
            try {
                int numero = Integer.parseInt(dato);
                System.out.println("Número válido: " + numero);
            } catch (NumberFormatException e) {
                System.out.println("No es un número: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("El dato es null");
            }
        }

        // 4. Multi-catch: un mismo tratamiento para varios tipos (se separan con |).
        try {
            int[] numeros = new int[2];
            numeros[5] = 1;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Problema con el array: " + e.getMessage());
        }

        // 5. finally: se ejecuta SIEMPRE, con o sin error.
        for (int divisor : new int[]{2, 0}) {
            try {
                System.out.println("10 / " + divisor + " = " + (10 / divisor));
            } catch (ArithmeticException e) {
                System.out.println("División inválida");
            } finally {
                System.out.println("  (finally: se ejecuta en ambos casos)");
            }
        }

        // 6. throw: nosotros mismos lanzamos una excepción cuando detectamos un problema.
        try {
            validarEdad(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Edad rechazada: " + e.getMessage());
        }

        // Recordatorio: capturar una excepción NO es esconderla. Un catch vacío oculta errores
        // y es una de las peores prácticas: siempre hay que hacer algo útil (mostrar, registrar, recuperar).
    }

    // throw lanza la excepción (new crea el objeto). Se corta el método en ese punto.
    static void validarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("la edad no puede ser negativa: " + edad);
        }
        System.out.println("Edad válida: " + edad);
    }
}
