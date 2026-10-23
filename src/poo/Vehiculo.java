package poo;

// 03. Herencia
// Clase PADRE (superclase): reúne lo que tienen en común todos los vehículos.
// Las clases hijas heredan sus atributos y métodos sin volver a escribirlos.
public class Vehiculo {
    // protected: visible para esta clase, su paquete y las clases hijas (aunque estén en otro paquete).
    // Es el uso típico de protected: compartir con las hijas pero no con cualquiera.
    protected String marca;
    protected String modelo;
    protected int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public void arrancar() {
        System.out.println(marca + " " + modelo + " arrancó");
    }

    public void frenar() {
        System.out.println(marca + " " + modelo + " frenó");
    }

    @Override
    public String toString() {
        return "Vehiculo{marca='" + marca + "', modelo='" + modelo + "', anio=" + anio + "}";
    }
}
