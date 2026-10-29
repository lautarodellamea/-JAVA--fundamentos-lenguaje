package excepciones;

// 05. Exception personalizada: tipo checked
// Podemos crear nuestras propias excepciones para representar errores del NEGOCIO
// (saldo insuficiente, stock agotado, usuario duplicado), con un nombre que se explique solo.
//
// Para que sea CHECKED se hereda de Exception (sin pasar por RuntimeException).
// Consecuencia: el compilador OBLIGA a quien llame al método a manejarla (try-catch) o a declararla (throws).
//
// Cuándo usar checked: cuando el error es esperable y el que llama PUEDE hacer algo para recuperarse
// (pedir otro monto, reintentar, ofrecer otra opción).
public class ExcepcionCheckedPersonalizada {

    // Hereda de Exception -> checked.
    // Nota: IntelliJ puede marcar un aviso "serialVersionUID" en las excepciones propias, porque Throwable
    // es serializable. Es solo un aviso (no un error) y se puede ignorar mientras aprendemos.
    static class SaldoInsuficienteException extends Exception {
        private final double faltante; // dato extra útil para quien la capture

        // Convención: un constructor con el mensaje...
        SaldoInsuficienteException(String mensaje, double faltante) {
            super(mensaje); // el mensaje se guarda en la clase padre (getMessage)
            this.faltante = faltante;
        }

        double getFaltante() {
            return faltante;
        }
    }

    // Otra excepción checked, pensada para "envolver" un error de más bajo nivel (ver el uso con cause).
    static class DatosInvalidosException extends Exception {
        // ...y otro con el mensaje y la CAUSA original, para no perder el rastro del error de fondo.
        DatosInvalidosException(String mensaje, Throwable causa) {
            super(mensaje, causa);
        }
    }

    static class Cuenta {
        private double saldo;

        Cuenta(double saldo) {
            this.saldo = saldo;
        }

        // "throws" avisa en la firma que este método puede lanzar la excepción checked.
        void retirar(double monto) throws SaldoInsuficienteException {
            if (monto > saldo) {
                throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + monto, monto - saldo);
            }
            saldo -= monto;
            System.out.println("Retiro de " + monto + " exitoso. Saldo: " + saldo);
        }
    }

    // Convierte un texto en monto. Si falla, envuelve el error técnico en uno de negocio.
    static double leerMonto(String texto) throws DatosInvalidosException {
        try {
            return Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            throw new DatosInvalidosException("El monto '" + texto + "' no es válido", e); // e queda como causa
        }
    }

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1000);

        // El compilador obliga a atender la excepción: sin try-catch (ni throws en main), no compila.
        // cuenta.retirar(500); // error de compilación: unreported exception SaldoInsuficienteException
        try {
            cuenta.retirar(400);
            cuenta.retirar(900); // falla: quedan 600
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error de negocio: " + e.getMessage());
            System.out.println("Faltan: " + e.getFaltante()); // acceso a los datos extra
        }

        // Excepción con causa: se conserva el error original.
        try {
            leerMonto("doscientos");
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Causa original: " + e.getCause());
        }
    }
}
