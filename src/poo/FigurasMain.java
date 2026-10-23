package poo;

// 09. Clases abstractas e interfaces - parte 1 (ejecución)
public class FigurasMain {
    public static void main(String[] args) {
        // No se puede instanciar una clase abstracta:
        // Figura figura = new Figura("Genérica"); // NO compila: Figura is abstract

        // Pero sí se puede usar como TIPO de variable (polimorfismo de inclusión).
        Figura[] figuras = {
                new Circulo(2),
                new Rectangulo(3, 4)
        };

        for (Figura figura : figuras) {
            figura.describir(); // método heredado, que llama al calcularArea() de cada hija
        }

        // Suma de áreas: el código solo conoce Figura, no le importa cuál es cada una.
        double total = 0;
        for (Figura figura : figuras) {
            total += figura.calcularArea();
        }
        System.out.println("Área total: " + total);
    }
}
