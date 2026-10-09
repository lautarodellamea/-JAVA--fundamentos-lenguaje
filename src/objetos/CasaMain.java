package objetos;

// 01. Atributos y métodos de clase (ejecución)
// Para ejecutar: correr ESTE archivo (tiene el main), no Casa.java.
// En IntelliJ: botón verde de play junto a main(). Por consola, desde la raíz del proyecto:
//   javac -d out src/objetos/Casa.java src/objetos/CasaMain.java
//   java -cp out objetos.CasaMain
public class CasaMain {
    public static void main(String[] args) {
        // Cada objeto creado con new tiene sus propios valores de atributos.
        Casa miCasa = new Casa();
        miCasa.puertas = 2;
        miCasa.ventanas = 4;
        miCasa.tamanio = 10;

        Casa miCasa2 = new Casa();
        miCasa2.puertas = 4;
        miCasa2.ventanas = 6;
        miCasa2.tamanio = 20;

        System.out.println("La cantidad de puertas de la casa es: " + miCasa2.puertas);
        miCasa2.abrirPuerta();
        double area = miCasa2.calcularArea();

        System.out.println("El área de la casa es: " + area);
    }
}
