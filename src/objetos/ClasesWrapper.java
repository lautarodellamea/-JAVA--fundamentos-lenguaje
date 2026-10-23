package objetos;

// 04. Clases wrapper
// Cada tipo primitivo tiene una clase "envoltorio" que lo convierte en objeto:
// byte -> Byte, short -> Short, int -> Integer, long -> Long,
// float -> Float, double -> Double, boolean -> Boolean, char -> Character
public class ClasesWrapper {
    public static void main(String[] args) {
        // Primitivo vs wrapper: el primitivo guarda el valor, el wrapper es un objeto.
        int primitivo = 10;
        Integer wrapper = Integer.valueOf(10);

        // Autoboxing: Java convierte primitivo -> wrapper automáticamente.
        Integer autoboxing = primitivo;
        // Unboxing: Java convierte wrapper -> primitivo automáticamente.
        int unboxing = wrapper;
        System.out.println("Autoboxing: " + autoboxing + " | Unboxing: " + unboxing);

        // Los wrappers traen métodos y constantes útiles.
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);

        // Conversión de String a número: el uso más común de los wrappers.
        int numero = Integer.parseInt("123");
        double decimal = Double.parseDouble("45.67");
        boolean activo = Boolean.parseBoolean("true");
        System.out.println("parseInt: " + (numero + 1) + " | parseDouble: " + (decimal + 1) + " | parseBoolean: " + activo);

        // Conversión de número a String.
        String texto = Integer.toString(456);
        System.out.println("toString: " + texto + " (longitud " + texto.length() + ")");

        // Métodos de Character.
        char letra = 'a';
        System.out.println("isLetter: " + Character.isLetter(letra) + " | toUpperCase: " + Character.toUpperCase(letra));

        // Un wrapper puede ser null, un primitivo no. Útil para representar "sin valor".
        Integer sinValor = null;
        System.out.println("Wrapper null: " + sinValor);
        // int no puede ser null. Y unboxear un null lanza NullPointerException:
        // int fallo = sinValor;

        // Comparación: con wrappers usar equals(), no ==.
        // == compara referencias y solo "funciona" por casualidad con valores chicos (-128 a 127, caché).
        Integer a = 127;
        Integer b = 127;
        Integer c = 1000;
        Integer d = 1000;
        System.out.println("127 == 127: " + (a == b));
        System.out.println("1000 == 1000: " + (c == d));
        System.out.println("1000 equals 1000: " + c.equals(d));
    }
}
