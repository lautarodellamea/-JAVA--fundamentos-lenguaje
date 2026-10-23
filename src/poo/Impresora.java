package poo;

// 05. Polimorfismo - SOBRECARGA (overloading)
// Polimorfismo = "muchas formas": un mismo nombre de método que se comporta distinto.
//
// Sobrecarga: varios métodos con el MISMO nombre en la MISMA clase,
// pero con distinta lista de parámetros (cantidad, tipo u orden).
// Java decide cuál ejecutar al COMPILAR, mirando los argumentos con que lo llamás.
// Ya la usamos con los constructores de Auto (tema 02 de objetos).
public class Impresora {
    public void imprimir(String texto) {
        System.out.println("Texto: " + texto);
    }

    public void imprimir(int numero) {
        System.out.println("Entero: " + numero);
    }

    public void imprimir(double numero) {
        System.out.println("Decimal: " + numero);
    }

    // Distinta cantidad de parámetros.
    public void imprimir(String texto, int copias) {
        for (int i = 0; i < copias; i++) {
            System.out.println("Copia " + (i + 1) + ": " + texto);
        }
    }

    // Distinto orden de tipos también cuenta como sobrecarga.
    public void imprimir(int copias, String texto) {
        imprimir(texto, copias);
    }

    // OJO: cambiar SOLO el tipo de retorno NO es sobrecarga y no compila.
    // public int imprimir(String texto) { ... }  // error: ya existe imprimir(String)
}
