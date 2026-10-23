package poo;

// 10. Interfaces - ¿qué pasa si dos interfaces tienen un método con el mismo nombre?
//
// Caso 1: método ABSTRACTO con la misma firma (abrir() en Lector y en Escritor).
//   No hay problema: una sola implementación en la clase cumple los dos contratos a la vez.
//
// Caso 2: método DEFAULT con la misma firma (describir() en Lector y en Escritor).
//   Java no sabe cuál elegir, y NO compila hasta que la clase lo resuelva sobrescribiendo el método.
//   Dentro se puede elegir una versión con NombreInterfaz.super.metodo(), o escribir una propia.
public class Tablet implements Lector, Escritor {

    // Caso 1: una sola implementación sirve para ambas interfaces.
    @Override
    public void abrir() {
        System.out.println("La tablet abre el archivo");
    }

    // Caso 2: sin este método, el compilador marca error por el conflicto de describir().
    @Override
    public void describir() {
        Lector.super.describir();   // usa la versión de Lector
        Escritor.super.describir(); // y también la de Escritor
        System.out.println("Soy una Tablet: hago las dos cosas");
    }
}
