package poo;

// 09. Clases abstractas e interfaces - parte 1: CLASES ABSTRACTAS
// Una clase abstracta es una clase "incompleta" que sirve de molde para sus hijas.
// - Se declara con "abstract" y NO se puede instanciar: no existe "una figura" en general,
//   existen círculos, rectángulos, etc.
// - Puede tener métodos abstractos: solo la firma, sin cuerpo. Cada hija está OBLIGADA a implementarlos.
// - Puede tener también atributos, constructores y métodos normales con código (que las hijas heredan).
public abstract class Figura {
    protected String nombre;

    // Las clases abstractas pueden tener constructor: lo llaman las hijas con super(...).
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto: cada figura calcula su área de forma distinta, así que acá no se puede
    // escribir un código que sirva para todas. Solo se declara el "contrato".
    public abstract double calcularArea();

    // Método normal: código compartido que ya funciona para todas las hijas.
    // Fíjate que usa calcularArea() aunque no sabe cómo se calcula (polimorfismo).
    public void describir() {
        System.out.println("Figura " + nombre + " con área " + calcularArea());
    }
}
