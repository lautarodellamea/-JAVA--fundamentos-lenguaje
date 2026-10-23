package poo;

// 03. Herencia (ejecución)
public class VehiculoMain {
    public static void main(String[] args) {
        Automovil auto = new Automovil("Toyota", "Corolla", 2020, 4);
        Moto moto = new Moto("Honda", "CB 190", 2022, 190);

        // Métodos heredados de Vehiculo, usados sin haberlos escrito en las hijas.
        moto.arrancar();
        moto.frenar();

        // arrancar() está sobrescrito en Automovil: se ejecuta la versión de la hija.
        auto.arrancar();
        auto.frenar(); // este sí es el heredado tal cual

        // Métodos propios de cada hija.
        auto.abrirBaul();
        moto.hacerCaballito();
        // auto.hacerCaballito(); // NO compila: es de Moto, no de Automovil ni de Vehiculo.

        // toString() de cada hija reutiliza el del padre con super.toString().
        System.out.println(auto);
        System.out.println(moto);

        // Un Automovil ES UN Vehiculo: se puede guardar en una variable del tipo padre.
        Vehiculo vehiculo = auto;
        System.out.println("Visto como Vehiculo: " + vehiculo.marca);
        // vehiculo.abrirBaul(); // NO compila: la variable es de tipo Vehiculo y no conoce ese método.
    }
}
