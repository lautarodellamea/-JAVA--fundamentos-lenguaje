package objetos;

// 13. Relaciones entre clases - parte de una AGREGACIÓN (Equipo "tiene" Jugadores)
public class Jugador {
    private final String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
