package poo;

// 10. Interfaces
// Una clase solo puede heredar de UNA clase (extends), pero puede implementar VARIAS interfaces.
// Pato ES un Animal (herencia) y además PUEDE volar y nadar (dos contratos).
public class Pato extends Animal implements Volador, Nadador {
    public Pato(String nombre) {
        super(nombre);
    }

    @Override
    public void volar() {
        System.out.println(nombre + " vuela bajito");
    }

    @Override
    public void nadar() {
        System.out.println(nombre + " nada en el lago");
    }

    // aterrizar() no se implementa: se usa el default de Volador.
}
