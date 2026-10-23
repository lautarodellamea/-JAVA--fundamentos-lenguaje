package poo;

// 05. Polimorfismo - SOBREESCRITURA: hija
public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: Guau");
    }

    // Método propio de Perro: Animal no lo tiene (ver 06. Polimorfismo de inclusión).
    public void buscarHueso() {
        System.out.println(nombre + " encontró un hueso");
    }
}
