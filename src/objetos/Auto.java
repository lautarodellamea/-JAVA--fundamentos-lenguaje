package objetos;

// 02. Constructores de clase
public class Auto {
    String marca;
    String modelo;
    int anio;

    // Constructor sin parámetros: deja los atributos con valores por defecto.
    // Si no escribís ningún constructor, Java crea este automáticamente.
    Auto() {
        System.out.println("Se creó un auto con el constructor vacío");
    }

    // Constructor con parámetros: inicializa el objeto al momento de crearlo.
    // "this" distingue el atributo del objeto del parámetro con el mismo nombre.
    Auto(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Sobrecarga: mismo nombre (el de la clase), distinta lista de parámetros.
    // this(...) reutiliza otro constructor y evita repetir código.
    Auto(String marca, String modelo) {
        this(marca, modelo, 2024);
    }

    void mostrarDatos() {
        System.out.println("Auto: " + marca + " " + modelo + " (" + anio + ")");
    }

    // toString(): devuelve una representación en texto del objeto. Viene de la clase Object,
    // de la que heredan todas las clases; acá la sobrescribimos (@Override).
    // Sin sobrescribirla, imprimir el objeto muestra algo inútil como "objetos.Auto@1b6d3586".
    // println(objeto) y la concatenación con + la llaman automáticamente.
    // En IntelliJ se genera rápido: Alt + Insert (o clic derecho > Generate) > toString().
    @Override
    public String toString() {
        return "Auto{marca='" + marca + "', modelo='" + modelo + "', anio=" + anio + "}";
    }
}
