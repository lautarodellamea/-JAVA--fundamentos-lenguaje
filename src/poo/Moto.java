package poo;

// 03. Herencia
// Otra hija del mismo padre: el código común vive en Vehiculo una sola vez (reutilización).
public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, int anio, int cilindrada) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    public void hacerCaballito() {
        System.out.println(marca + " " + modelo + " hace un caballito");
    }

    // No sobrescribe arrancar() ni frenar(): usa los heredados tal cual.

    @Override
    public String toString() {
        return "Moto{" + super.toString() + ", cilindrada=" + cilindrada + "cc}";
    }
}
