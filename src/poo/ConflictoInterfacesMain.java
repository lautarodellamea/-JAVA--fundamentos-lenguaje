package poo;

// 10. Interfaces - conflicto de nombres (ejecución)
public class ConflictoInterfacesMain {
    public static void main(String[] args) {
        Tablet tablet = new Tablet();
        tablet.abrir();
        tablet.describir();

        // La misma Tablet vista como cada contrato: abrir() cumple los dos.
        Lector lector = tablet;
        Escritor escritor = tablet;
        lector.abrir();
        escritor.abrir();
    }
}
