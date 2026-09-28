package fundamentos;

public class VariablesPrimitivas {
    public static void main(String[] args) {
        byte edad = 25;
        short anioNacimiento = 2000;
        int poblacion = 45000000;
        long distanciaSol = 149600000000L;
        float precioDolar = 1350.50f;
        double altura = 1.78;
        boolean esMayorDeEdad = true;
        char inicial = 'L';

        System.out.println("byte -> edad: " + edad);
        System.out.println("short -> año de nacimiento: " + anioNacimiento);
        System.out.println("int -> población: " + poblacion);
        System.out.println("long -> distancia al sol (km): " + distanciaSol);
        System.out.println("float -> precio dólar: " + precioDolar);
        System.out.println("double -> altura: " + altura + "m");
        System.out.println("boolean -> es mayor de edad: " + esMayorDeEdad);
        System.out.println("char -> inicial: " + inicial);

        // String no es primitivo: es una clase (tipo referencia).
        String nombre = "Lautaro";
        System.out.println("String (referencia) -> nombre: " + nombre);
    }
}
