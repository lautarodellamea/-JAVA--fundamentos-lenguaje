package poo;

// 11. La clase enum (ejecución)
public class EnumMain {
    public static void main(String[] args) {
        // Se usa por el nombre del enum. Solo se puede asignar uno de los valores definidos.
        DiaSemana hoy = DiaSemana.MARTES;
        // DiaSemana otro = "martes"; // NO compila: un String no es un DiaSemana.
        System.out.println("Hoy es: " + hoy);

        // Métodos que todo enum trae:
        System.out.println("name(): " + hoy.name());       // "MARTES"
        System.out.println("ordinal(): " + hoy.ordinal()); // 1 (posición, arranca en 0)

        // values(): arreglo con todas las constantes.
        for (DiaSemana dia : DiaSemana.values()) {
            System.out.print(dia + " ");
        }
        System.out.println();

        // valueOf(String): convierte un texto en la constante. Si no existe, lanza IllegalArgumentException.
        DiaSemana convertido = DiaSemana.valueOf("VIERNES");
        System.out.println("valueOf: " + convertido);

        // Comparar: con == (cada constante es un único objeto) o con equals.
        System.out.println("¿hoy es MARTES? " + (hoy == DiaSemana.MARTES));

        // switch con enum: no hace falta escribir DiaSemana. delante de cada case.
        switch (hoy) {
            case SABADO:
            case DOMINGO:
                System.out.println("Fin de semana");
                break;
            default:
                System.out.println("Día de semana");
        }

        System.out.println("-----");

        // Enum con atributos y métodos.
        EstadoPedido estado = EstadoPedido.ENVIADO;
        System.out.println(estado + ": " + estado.getDescripcion() + " | ¿finalizado? " + estado.isFinalizado());

        for (EstadoPedido e : EstadoPedido.values()) {
            System.out.println(e.ordinal() + " - " + e + " (" + e.getDescripcion() + ")");
        }
    }
}
