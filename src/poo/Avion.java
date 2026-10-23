package poo;

// 10. Interfaces
// Un Avion NO tiene nada que ver con un Animal, pero igual cumple el contrato de Volador.
// Esa es la gracia: clases sin relación de herencia compartiendo una capacidad.
public class Avion implements Volador {
    @Override
    public void volar() {
        System.out.println("El avión vuela hasta " + ALTURA_MAXIMA + " metros");
    }

    // Se puede sobrescribir el método default si hace falta otro comportamiento.
    @Override
    public void aterrizar() {
        System.out.println("El avión baja el tren de aterrizaje y aterriza en pista");
    }
}
