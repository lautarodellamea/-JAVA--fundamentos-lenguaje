package objetos;

// 02. Constructores de clase (ejecución)
public class AutoMain {
    public static void main(String[] args) {
        // Constructor vacío: atributos con valores por defecto (null y 0).
        Auto autoVacio = new Auto();
        autoVacio.mostrarDatos();

        // Constructor completo: el objeto nace con todos sus datos.
        // podemos crear varias configuraciones, uno que tenga marca, otro que no, otro que tenga año y marca, otro que tenga modelo solo
        Auto autoCompleto = new Auto("Toyota", "Corolla", 2020);
        autoCompleto.mostrarDatos();

        // Constructor sobrecargado: el año se completa con el valor por defecto.
        Auto autoSinAnio = new Auto("Ford", "Focus");
        autoSinAnio.mostrarDatos();

        // toString(): println llama a toString() automáticamente al recibir un objeto.
        System.out.println(autoCompleto);
        System.out.println("Mi auto: " + autoSinAnio);
    }
}
