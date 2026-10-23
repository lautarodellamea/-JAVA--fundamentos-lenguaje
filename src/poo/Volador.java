package poo;

// 10. Clases abstractas e interfaces - parte 2: INTERFACES
// Una interfaz es un CONTRATO: define QUÉ se puede hacer, sin decir cómo.
// - Los métodos son abstractos y públicos por defecto (no hace falta escribir "abstract" ni "public").
// - Las clases la adoptan con "implements" y están OBLIGADAS a implementar todos sus métodos.
// - No tiene atributos de instancia ni constructor (no guarda estado).
// - Los atributos son constantes: public static final de forma implícita.
public interface Volador {
    int ALTURA_MAXIMA = 10000; // constante (public static final)

    // Método abstracto: solo la firma.
    void volar();

    // Método default (Java 8+): trae una implementación por defecto que las clases pueden usar o sobrescribir.
    default void aterrizar() {
        System.out.println("Aterrizando...");
    }
}
