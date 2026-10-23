package objetos;

import java.util.ArrayList;
import java.util.List;

// 13. Relaciones entre clases - AGREGACIÓN
// Relación débil "tiene": el Equipo agrupa Jugadores, pero los Jugadores se crean AFUERA
// y existen por sí mismos. Si el Equipo desaparece, los Jugadores siguen existiendo.
// Es un "uno a muchos": un Equipo, varios Jugadores.
public class Equipo {
    private final String nombre;
    private final List<Jugador> jugadores = new ArrayList<>();

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    // La agregación se reconoce porque el objeto llega de afuera (por parámetro).
    public void fichar(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void mostrarPlantel() {
        System.out.println("Plantel de " + nombre + ":");
        for (Jugador jugador : jugadores) {
            System.out.println(" - " + jugador.getNombre());
        }
    }
}
