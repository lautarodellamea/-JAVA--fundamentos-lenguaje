package poo;

import java.util.ArrayList;
import java.util.List;

// 06. Polimorfismo de inclusión (también llamado polimorfismo de subtipos)
// Un objeto de una clase hija puede ser usado en cualquier lugar donde se espera
// un objeto de la clase padre: la hija "está incluida" en el tipo del padre.
// Funciona porque un Perro ES UN Animal.
// Es el polimorfismo que se apoya en la herencia (junto con la sobreescritura del tema 05).
public class PolimorfismoInclusion {

    // Recibe un Animal, pero acepta Animal, Perro, Gato y cualquier hijo futuro.
    static void presentar(Animal animal) {
        System.out.print("Presento a un animal: ");
        animal.hacerSonido();
    }

    public static void main(String[] args) {
        // 1. Upcasting: guardar un hijo en una variable del tipo padre (automático, siempre seguro).
        Animal animal = new Perro("Rex");
        animal.hacerSonido(); // se ejecuta la versión de Perro (sobreescritura)

        // Limitación: la variable solo "ve" lo que declara el tipo padre.
        // animal.buscarHueso(); // NO compila: Animal no tiene ese método, aunque el objeto sea un Perro.

        // 2. Un método que recibe el tipo padre sirve para todos los hijos.
        presentar(new Perro("Toby"));
        presentar(new Gato("Michi"));

        // 3. Colecciones del tipo padre pueden mezclar hijos distintos.
        List<Animal> refugio = new ArrayList<>();
        refugio.add(new Perro("Luna"));
        refugio.add(new Gato("Simba"));
        refugio.add(new Animal("Bicho"));
        for (Animal a : refugio) {
            a.hacerSonido();
        }

        // 4. Downcasting: volver al tipo hijo para usar lo propio de la hija.
        // Es manual y riesgoso: si el objeto real no es un Perro, lanza ClassCastException.
        // Por eso se verifica antes con instanceof.
        for (Animal a : refugio) {
            if (a instanceof Perro) {
                Perro perro = (Perro) a;
                perro.buscarHueso();
            } else {
                System.out.println(a.nombre + " no es un perro, no busca huesos");
            }
        }

        // Sin la verificación, esto rompería en ejecución:
        // Perro falso = (Perro) new Gato("Michi"); // ClassCastException
    }
}
