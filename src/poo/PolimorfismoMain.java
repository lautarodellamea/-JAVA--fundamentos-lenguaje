package poo;

// 05. Polimorfismo: sobrecarga y sobreescritura (ejecución)
public class PolimorfismoMain {
    public static void main(String[] args) {
        // --- SOBRECARGA: mismo nombre, Java elige por los argumentos (al compilar) ---
        Impresora impresora = new Impresora();
        impresora.imprimir("Hola");
        impresora.imprimir(42);
        impresora.imprimir(3.14);
        impresora.imprimir("Informe", 2);
        impresora.imprimir(1, "Contrato");

        System.out.println("-----");

        // --- SOBREESCRITURA: mismo método, cada hija responde a su manera (al ejecutar) ---
        // Todas las variables son de tipo Animal, pero los objetos reales son distintos.
        Animal[] animales = {
                new Animal("Bicho"),
                new Perro("Rex"),
                new Gato("Michi")
        };

        for (Animal animal : animales) {
            // Java mira el objeto REAL y ejecuta la versión que corresponde.
            animal.hacerSonido();
        }

        // Esto es lo potente: el mismo código sirve para cualquier hijo, incluso uno que
        // se cree mañana (por ejemplo Vaca), sin tocar este bucle.
    }
}
