package poo;

// 08. Ejemplo integrador - otra hija de Vehiculo (sin motor).
public class Bicicleta extends Vehiculo {
    public Bicicleta(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    // Una bicicleta no tiene motor: "arrancar" significa otra cosa, se sobrescribe.
    @Override
    public void arrancar() {
        System.out.println(marca + " " + modelo + " empieza a pedalear");
    }
}
