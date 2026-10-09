package objetos;

// 13. Relaciones entre clases (ejecución)
// De la más fuerte a la más débil: composición > agregación > asociación > dependencia.
public class RelacionesMain {
    public static void main(String[] args) {
        // COMPOSICIÓN: el Procesador lo crea la Computadora por dentro, desde afuera solo pasamos el dato.
        Computadora pc = new Computadora("Lenovo", "Ryzen 5");
        System.out.println(pc);

        // AGREGACIÓN: los Jugadores existen antes y por separado del Equipo.
        Jugador jugador1 = new Jugador("Messi");
        Jugador jugador2 = new Jugador("Di María");

        Equipo equipo = new Equipo("Selección");
        equipo.fichar(jugador1);
        equipo.fichar(jugador2);
        equipo.mostrarPlantel();

        // Un mismo Jugador puede estar en más de un Equipo (no hay dueño único, a diferencia de la composición).
        Equipo otroEquipo = new Equipo("Inter Miami");
        otroEquipo.fichar(jugador1);
        otroEquipo.mostrarPlantel();

        // DEPENDENCIA: el Taller usa un Auto solo mientras dura la llamada al método.
        Taller taller = new Taller();
        taller.reparar(new Auto("Ford", "Focus", 2019));
    }
}
