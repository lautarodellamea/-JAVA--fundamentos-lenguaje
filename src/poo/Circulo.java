package poo;

// 09. Clases abstractas - hija concreta
// Si una hija no implementa TODOS los métodos abstractos, tiene que ser abstracta también.
public class Circulo extends Figura {
    private final double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
