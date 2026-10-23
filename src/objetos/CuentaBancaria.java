package objetos;

// 03. Modificadores de acceso
public class CuentaBancaria {
    // public: accesible desde cualquier clase, de cualquier paquete.
    public String titular;

    // protected: accesible desde el mismo paquete y desde las subclases (ver herencia) (aunque estén en otro paquete).
    protected String numeroCuenta;

    // sin modificador (default) (package-private): accesible solo desde el mismo paquete.
    String sucursal;

    // private: accesible solo desde dentro de esta clase.
    private double saldo;

    // private + getter/setter: el patrón estándar para exponer un atributo de forma controlada.
    private String alias;

    public CuentaBancaria(String titular, String numeroCuenta, String sucursal, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.sucursal = sucursal;
        this.saldo = saldo;
    }

    // GETTER: método público que LEE un atributo privado. Convención: get + NombreAtributo.
    // El saldo es privado, así que se expone con getter y se modifica con métodos que validan.
    public double getSaldo() {
        return saldo;
    }

    public String getAlias() {
        return alias;
    }

    // SETTER: método público que MODIFICA un atributo privado. Convención: set + NombreAtributo.
    // Su ventaja sobre un atributo público es que puede validar antes de asignar.
    public void setAlias(String alias) {
        if (alias != null && alias.length() >= 3) {
            this.alias = alias;
        } else {
            System.out.println("Alias inválido: debe tener al menos 3 caracteres");
        }
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    // Método privado: es un detalle interno, nadie de afuera lo necesita llamar.
    private boolean tieneFondos(double monto) {
        return saldo >= monto;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && tieneFondos(monto)) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
