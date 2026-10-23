package poo;

// 03. Herencia
// Clase HIJA (subclase): "extends" indica de quién hereda. Un Automovil ES UN Vehiculo.
// Hereda marca, modelo, anio, arrancar() y frenar(), y suma lo propio.
public class Automovil extends Vehiculo {
    private int puertas; // atributo propio, solo existe en Automovil

    // Composición (ver 08): el Automovil crea y es dueño de su Motor.
    private final Motor motor = new Motor(1600);

    public Automovil(String marca, String modelo, int anio, int puertas) {
        // super(...): llama al constructor del padre. Tiene que ser la PRIMERA línea.
        // El padre se encarga de inicializar lo que le corresponde.
        super(marca, modelo, anio);
        this.puertas = puertas;
    }

    // Método propio de la hija: el padre no lo tiene.
    public void abrirBaul() {
        System.out.println("Baúl del " + modelo + " abierto"); // modelo es heredado (protected)
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    // Sobrescritura (@Override): la hija reemplaza el comportamiento heredado por uno propio.
    @Override
    public void arrancar() {
        // super.metodo(): ejecuta la versión del padre y después agrega lo propio.
        super.arrancar();
        motor.encender();
        System.out.println("  (con " + puertas + " puertas, cinturones puestos)");
    }

    @Override
    public String toString() {
        return "Automovil{" + super.toString() + ", puertas=" + puertas + "}";
    }
}
