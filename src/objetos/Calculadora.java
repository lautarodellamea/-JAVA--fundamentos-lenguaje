package objetos;

// 09. Métodos de clase - static
//
// ¿Qué se duplica en memoria y qué no? (aunque tengamos miles de instancias)
// - Métodos (static o de instancia): el código se carga UNA sola vez, junto con la clase
//   (en el Metaspace de la JVM). Todos los objetos comparten ese mismo código.
//   Un método de instancia sabe sobre qué objeto trabaja porque recibe "this" de forma implícita.
// - Atributos de instancia: SÍ hay una copia por objeto, en el heap. Es lo único que ocupa
//   memoria por cada new (más una pequeña cabecera interna que apunta a su clase).
// - Atributos static: UNA sola copia por clase, sin importar cuántos objetos existan.
// Resultado: 1000 objetos Calculadora = 1000 copias de "ultimoResultado", pero 1 sola copia
// de sumar(), promedio(), sumarYGuardar() y de "operacionesRealizadas".
public class Calculadora {
    // Atributo de instancia: pertenece a cada objeto.
    int ultimoResultado;

    // Atributo static: pertenece a la clase.
    static int operacionesRealizadas = 0;

    // Método static (de clase): pertenece a la CLASE, se llama sin crear un objeto.
    // Ideal para utilidades que no dependen del estado de ningún objeto.
    static int sumar(int a, int b) {
        operacionesRealizadas++;
        return a + b;
    }

    static double promedio(double a, double b) {
        operacionesRealizadas++;
        return (a + b) / 2;
    }

    // Un método static solo ve lo que es static: no hay ningún objeto ("this") asociado.
    static void intentoInvalido() {
        // ultimoResultado = 10;  // NO compila: ultimoResultado es de instancia, necesita un objeto.
        // this.ultimoResultado = 10; // NO compila: en un método static no existe "this".
    }

    // Método de instancia: necesita un objeto y puede usar atributos de instancia Y static.
    int sumarYGuardar(int a, int b) {
        ultimoResultado = sumar(a, b); // desde un método de instancia SÍ se puede llamar a un static
        return ultimoResultado;
    }
}
