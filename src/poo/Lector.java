package poo;

// 10. Interfaces - métodos con el mismo nombre en dos interfaces (ver Tablet)
public interface Lector {
    void abrir();

    default void describir() {
        System.out.println("Soy un Lector: muestro contenido");
    }
}
