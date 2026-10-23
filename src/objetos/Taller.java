package objetos;

// 13. Relaciones entre clases - DEPENDENCIA
// Relación más débil "usa": el Taller NO guarda ningún Auto como atributo,
// solo lo recibe en un método, lo usa y se olvida de él.
public class Taller {
    public void reparar(Auto auto) {
        System.out.println("Reparando: " + auto);
    }
}
