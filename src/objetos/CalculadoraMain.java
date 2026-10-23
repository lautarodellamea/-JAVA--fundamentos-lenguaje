package objetos;

// 09. Métodos de clase - static (ejecución)
public class CalculadoraMain {
    public static void main(String[] args) {
        // Método static: se llama por el nombre de la clase, sin new.
        int suma = Calculadora.sumar(3, 4);
        double promedio = Calculadora.promedio(10, 20);
        System.out.println("Suma: " + suma + " | Promedio: " + promedio);

        // Método de instancia: hace falta un objeto.
        Calculadora calc = new Calculadora();
        calc.sumarYGuardar(5, 6);
        System.out.println("Último resultado del objeto: " + calc.ultimoResultado);

        // El contador static es compartido: contó las 3 operaciones.
        System.out.println("Operaciones realizadas: " + Calculadora.operacionesRealizadas);

        // Ya usamos métodos static de Java sin darnos cuenta: no se hace new Math() ni new Integer().
        System.out.println("Math.max(3, 9): " + Math.max(3, 9));
        System.out.println("Math.sqrt(16): " + Math.sqrt(16));
        System.out.println("Math.pow(2, 10): " + Math.pow(2, 10));
        System.out.println("Integer.parseInt(\"42\"): " + Integer.parseInt("42"));
        System.out.println("String.valueOf(7): " + String.valueOf(7));
    }
}
