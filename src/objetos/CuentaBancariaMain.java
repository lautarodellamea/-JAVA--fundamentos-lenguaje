package objetos;

// 03. Modificadores de acceso (ejecución)
public class CuentaBancariaMain {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Lauta", "0001-2345", "Centro", 1000);

        // Estamos en el mismo paquete (objetos): public, protected y package-private se ven.
        System.out.println("Titular: " + cuenta.titular);
        System.out.println("Número de cuenta: " + cuenta.numeroCuenta);
        System.out.println("Sucursal: " + cuenta.sucursal);

        // private: esta línea NO compila, el saldo solo se toca desde la clase.
        // cuenta.saldo = 1000000;

        // Se accede por los métodos públicos, que controlan las reglas.
        cuenta.depositar(500);
        System.out.println("Saldo tras depositar 500: " + cuenta.getSaldo());

        // Getter y setter: el alias es privado, se lee y se cambia solo por estos métodos.
        cuenta.setAlias("ab");
        cuenta.setAlias("lauta.cuenta");
        System.out.println("Alias: " + cuenta.getAlias());

        boolean retiroOk = cuenta.retirar(5000);
        System.out.println("¿Retiro de 5000 exitoso? " + retiroOk + " | saldo: " + cuenta.getSaldo());
    }
}
