package fundamentos;

public class Bucles {
    public static void main(String[] args) {
        // for: cuando sabés de antemano cuántas iteraciones necesitás.
        for (int i = 1; i <= 5; i++) {
            System.out.println("for -> vuelta " + i);
        }

        // for con paso personalizado, nombre descriptivo y límite sin números mágicos.
        final int VALOR_MAXIMO = 10;
        for (int numeroActual = 2; numeroActual <= VALOR_MAXIMO; numeroActual += 2) {
            System.out.println("for (paso 2) -> valor " + numeroActual);
        }
        System.out.println("Bucle de pares terminado");

        // while: cuando la condición de corte depende de algo que cambia adentro del bucle.
        int contador = 0;
        while (contador < 3) {
            System.out.println("while -> contador " + contador);
            contador++;
        }

        // do-while: se ejecuta al menos una vez, la condición se evalúa al final.
        int intentos = 0;
        do {
            System.out.println("do-while -> intento " + intentos);
            intentos++;
        } while (intentos < 3);

        // for-each: para recorrer colecciones o arrays sin manejar el índice.
        int[] numeros = {10, 20, 30, 40};
        for (int numero : numeros) {
            System.out.println("for-each -> numero " + numero);
        }

        // break corta el bucle; continue salta a la siguiente iteración.
        for (int i = 1; i <= 10; i++) {
            if (i == 3) continue;
            if (i == 6) break;
            System.out.println("break/continue -> i " + i);
        }
    }
}
