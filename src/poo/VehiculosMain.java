package poo;

// 08. Ejemplo integrador: herencia + composición + polimorfismo + casting
// Junta lo visto en esta sección:
// - Herencia:      Automovil, Moto y Bicicleta extienden Vehiculo.
// - Composición:   Automovil TIENE UN Motor.
// - Polimorfismo:  las variables son de tipo Vehiculo, pero los objetos reales son las hijas.
// - Casting:       para usar lo propio de una hija hay que volver a su tipo.
public class VehiculosMain {

    // Recibe el tipo padre: sirve para cualquier hijo.
    // println llama a toString() y se ejecuta la versión del objeto real.
    static void imprimirVehiculo(Vehiculo vehiculo) {
        System.out.println("Vehículo: " + vehiculo);
    }

    public static void main(String[] args) {
        // Variables de tipo padre, objetos de tipo hijo (upcasting).
        Vehiculo miAuto = new Automovil("Toyota", "Corolla", 2021, 4);
        Vehiculo miMoto = new Moto("Honda", "CBR", 2021, 600);
        Vehiculo miBici = new Bicicleta("Trek", "Marlin", 2022);

        // arrancar() existe en Vehiculo, así que se llama directo y cada uno responde a su manera.
        miAuto.arrancar();
        miMoto.arrancar();
        miBici.arrancar();

        System.out.println("-----");

        // Para usar un método propio de la hija hace falta el casting (downcasting).
        // Los paréntesis extra son necesarios: el cast se aplica antes de llamar al método.
        ((Automovil) miAuto).abrirBaul();
        ((Moto) miMoto).hacerCaballito();
        // miAuto.abrirBaul(); // NO compila: la variable es Vehiculo y no conoce abrirBaul().

        imprimirVehiculo(miMoto);
        imprimirVehiculo(miAuto);

        // Cambiamos un dato propio de la hija y volvemos a imprimir.
        ((Automovil) miAuto).setPuertas(5);
        imprimirVehiculo(miAuto);

        // Cuidado: castear al tipo equivocado compila pero explota al ejecutar.
        // ((Moto) miAuto).hacerCaballito(); // ClassCastException
    }
}
