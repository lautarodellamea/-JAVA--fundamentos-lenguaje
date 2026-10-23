package poo;

// 05. Polimorfismo - SOBREESCRITURA: hija
public class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Miau");
    }
}
