package objetos;

// 01. Atributos y métodos de clase
public class Casa {
    // Atributos: el estado de cada objeto.
    int puertas;
    int ventanas;
    double tamanio;

    // Métodos: el comportamiento de cada objeto.
    void abrirPuerta() {
        System.out.println("La puerta está abierta");
    }

    double calcularArea() {
        return tamanio * tamanio;
    }
}
