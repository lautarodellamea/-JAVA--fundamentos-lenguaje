package objetos;

// 13. Relaciones entre clases - COMPOSICIÓN
// Relación fuerte "es parte de": la Computadora CREA su Procesador y es su dueña.
// El Procesador no existe por separado: si la Computadora desaparece, el Procesador también.
public class Computadora {
    private final String marca;
    private final Procesador procesador;

    public Computadora(String marca, String modeloProcesador) {
        this.marca = marca;
        // La composición se reconoce porque el objeto se crea ADENTRO, no viene de afuera.
        this.procesador = new Procesador(modeloProcesador);
    }

    @Override
    public String toString() {
        return "Computadora{marca='" + marca + "', procesador='" + procesador.getModelo() + "'}";
    }
}
