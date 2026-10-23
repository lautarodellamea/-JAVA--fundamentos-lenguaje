package poo;

// 05. Polimorfismo - SOBREESCRITURA (overriding): clase padre
// Sobreescritura: una clase HIJA redefine un método heredado con la MISMA firma
// (mismo nombre y mismos parámetros) para darle un comportamiento propio.
// Java decide cuál ejecutar en tiempo de EJECUCIÓN, según el objeto real (no según el tipo de la variable).
public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido");
    }
}
