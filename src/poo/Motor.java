package poo;

// 08. Ejemplo integrador - COMPOSICIÓN: el Automovil TIENE UN Motor.
public class Motor {
    private final int cilindrada;

    public Motor(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void encender() {
        System.out.println("  (motor de " + cilindrada + "cc encendido)");
    }

    @Override
    public String toString() {
        return "Motor{" + cilindrada + "cc}";
    }
}
