package objetos;

// 05. El contexto de las variables
// El contexto (scope) es la zona del código donde una variable existe y se puede usar.
public class ContextoVariables {
    // Variable de clase (static): una sola para toda la clase, vive mientras corre el programa.
    // por eso tener cuidado y no sobrecargar
    static int contadorGlobal = 0;

    // Variable de instancia (atributo): una por cada objeto, vive mientras el objeto exista.
    // por cada objeto, podriamos contar cuantos objetos tenemos (contador de objetos)
    int valorDeInstancia = 10;

    void mostrarContextos(int parametro) {
        // Parámetro: existe solo dentro del método que lo recibe.
        // Variable local: existe solo dentro del método (o bloque) donde se declara.
        int local = 5;
        System.out.println("Parámetro: " + parametro + " | local: " + local);

        // Desde un método de instancia se accede a atributos de instancia y a variables static.
        System.out.println("Instancia: " + valorDeInstancia + " | static: " + contadorGlobal);

        // Contexto de bloque: una variable declarada dentro de { } muere al cerrar la llave.
        if (local > 0) {
            int soloEnElIf = local * 2;
            System.out.println("Dentro del if: " + soloEnElIf);
        }
        // System.out.println(soloEnElIf); // NO compila: ya no existe fuera del if.

        // La variable del for existe solo dentro del for.
        for (int i = 0; i < 2; i++) {
            System.out.println("Vuelta " + i);
        }
        // System.out.println(i); // NO compila: i solo vive dentro del for.
    }

    // Shadowing: un parámetro o variable local con el mismo nombre "tapa" al atributo.
    // "this" permite llegar al atributo de todas formas.
    void sombra(int valorDeInstancia) {
        System.out.println("Parámetro (tapa al atributo): " + valorDeInstancia);
        System.out.println("Atributo con this: " + this.valorDeInstancia);
    }

    public static void main(String[] args) {
        ContextoVariables objeto1 = new ContextoVariables();
        ContextoVariables objeto2 = new ContextoVariables();

        objeto1.mostrarContextos(99);
        objeto1.sombra(1);

        // Instancia: cada objeto tiene su propia copia.
        objeto1.valorDeInstancia = 100;
        System.out.println("objeto1: " + objeto1.valorDeInstancia + " | objeto2: " + objeto2.valorDeInstancia);

        // Static: una sola copia compartida, se accede por la clase.
        ContextoVariables.contadorGlobal = 7;
        System.out.println("static visto desde objeto2: " + objeto2.contadorGlobal);
    }
}
