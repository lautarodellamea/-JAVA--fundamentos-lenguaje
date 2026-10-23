package poo;

// 01. Abstracción
// Abstraer es mostrar solo lo ESENCIAL de un objeto y ocultar los detalles de cómo funciona.
// Quien usa la Cafetera sabe QUÉ hace (prepararCafe), no CÓMO lo hace por dentro.
// Es como una cafetera real: apretás un botón y no te importa cómo calienta el agua.
public class Cafetera {
    // Interfaz pública: lo único que el usuario de la clase necesita conocer.
    public void prepararCafe() {
        calentarAgua();
        molerGranos();
        filtrar();
        System.out.println("Café listo");
    }

    // Detalles internos: privados, el usuario no los ve ni los llama.
    // Si mañana cambia cómo se calienta el agua, el código que usa la Cafetera no se toca.
    private void calentarAgua() {
        System.out.println("  (calentando agua a 92 grados)");
    }

    private void molerGranos() {
        System.out.println("  (moliendo granos)");
    }

    private void filtrar() {
        System.out.println("  (filtrando)");
    }
}
