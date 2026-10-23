package fundamentos;

public class Condicionales {
    public static void main(String[] args) {
        int nota = 8;
        boolean esExcelente = nota >= 9;
        boolean esMuyBueno = nota >= 7;
        boolean esAprobado = nota >= 6;

        if (esExcelente) {
            System.out.println("Excelente");
        } else if (esMuyBueno) {
            System.out.println("Muy bueno");
        } else if (esAprobado) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Desaprobado");
        }

        int diaSemana = 3;
        String nombreDia;

        switch (diaSemana) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
            case 7:
                nombreDia = "Fin de semana";
                break;
            default:
                nombreDia = "Día inválido";
        }

        System.out.println("Día: " + nombreDia);

        // Switch expression (Java 14+): más corto, sin fallthrough.
        String tipoDia = switch (diaSemana) {
            case 1, 2, 3, 4, 5 -> "Hábil";
            case 6, 7 -> "Fin de semana";
            default -> "Inválido";
        };

        System.out.println("Tipo de día: " + tipoDia);
    }
}
