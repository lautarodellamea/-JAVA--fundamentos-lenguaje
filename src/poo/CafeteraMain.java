package poo;

// 01. Abstracción (ejecución)
public class CafeteraMain {
    public static void main(String[] args) {
        Cafetera cafetera = new Cafetera();

        // Un solo método público esconde todo el proceso.
        cafetera.prepararCafe();

        // cafetera.calentarAgua(); // NO compila: es un detalle interno (private).
    }
}
