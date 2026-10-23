package poo;

// 04. Inmutabilidad de clases
// Una clase inmutable es aquella cuyos objetos NO pueden cambiar después de creados.
// Recetas para lograrlo:
//   1. La clase es final (nadie puede heredar y romper la regla).
//   2. Todos los atributos son private final.
//   3. No hay setters.
//   4. Las "modificaciones" devuelven un objeto NUEVO (como hace String).
//   5. Si un atributo es mutable (lista, fecha), se copia al entrar y al salir (ver Pedido).
// Ventajas: se pueden compartir sin miedo, son seguras entre hilos y no hay cambios inesperados.
public final class Dinero {
    private final double monto;
    private final String moneda;

    public Dinero(double monto, String moneda) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        this.monto = monto;
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public String getMoneda() {
        return moneda;
    }

    // En vez de modificar este objeto, devuelve uno nuevo con el resultado.
    public Dinero sumar(Dinero otro) {
        if (!moneda.equals(otro.moneda)) {
            throw new IllegalArgumentException("Las monedas no coinciden");
        }
        return new Dinero(monto + otro.monto, moneda);
    }

    @Override
    public String toString() {
        return monto + " " + moneda;
    }
}
