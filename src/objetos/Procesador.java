package objetos;

// 13. Relaciones entre clases - parte de una COMPOSICIÓN (Computadora "tiene un" Procesador)
public class Procesador {
    private final String modelo;

    public Procesador(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
}
