package poo;

// 10. Interfaces (ejecución)
//
// Interfaz vs clase abstracta:
// - Clase abstracta: relación "ES UN" y puede guardar estado (atributos) y código compartido.
//   Solo se hereda de una.
// - Interfaz: define una CAPACIDAD ("PUEDE hacer") y no guarda estado.
//   Se pueden implementar varias.
public class InterfacesMain {

    // Recibe cualquier cosa que cumpla el contrato de Volador, sea un pato, un avión o lo que venga.
    static void despegar(Volador volador) {
        volador.volar();
        volador.aterrizar();
    }

    public static void main(String[] args) {
        // Una interfaz no se instancia, pero sí se usa como tipo de variable.
        // Volador volador = new Volador(); // NO compila

        Pato pato = new Pato("Donald");
        Avion avion = new Avion();

        despegar(pato);
        despegar(avion);

        // El mismo Pato visto con distintos contratos.
        Nadador nadador = pato;
        nadador.nadar();

        // Y también como Animal, porque además hereda de él.
        Animal animal = pato;
        animal.hacerSonido();

        System.out.println("Altura máxima (constante de la interfaz): " + Volador.ALTURA_MAXIMA);
    }
}
