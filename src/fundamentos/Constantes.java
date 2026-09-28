package fundamentos;

public class Constantes {
    static final double PI = 3.14159;
    static final int EDAD_MINIMA = 18;
    static final String NOMBRE_APP = "Hello World";

    public static void main(String[] args) {
        double radio = 5.0;
        double area = PI * radio * radio;

        System.out.println("Aplicación: " + NOMBRE_APP);
        System.out.println("Edad mínima permitida: " + EDAD_MINIMA);
        System.out.println("Área del círculo (radio " + radio + "): " + area);

        // PI = 3.14; // Error de compilación: no se puede reasignar un final
    }
}
