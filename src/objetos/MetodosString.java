package objetos;

// 07. Métodos de la clase String
// Recordar: String es inmutable, ningún método modifica el original, todos devuelven un String nuevo.
public class MetodosString {
    public static void main(String[] args) {
        // length(): cantidad de caracteres.
        String text = "Hola, mundo!";
        System.out.println("Longitud: " + text.length()); // 12

        // charAt(int index): carácter en una posición (los índices arrancan en 0).
        System.out.println("Carácter en la posición 2: " + text.charAt(2)); // 'l'

        // substring(int beginIndex, int endIndex): desde begin (incluido) hasta end (excluido).
        System.out.println("Subcadena: " + text.substring(0, 5)); // "Hola,"
        // substring(int beginIndex): desde begin hasta el final.
        System.out.println("Desde la posición 6: " + text.substring(6)); // "mundo!"

        // toUpperCase() y toLowerCase().
        System.out.println("Mayúsculas: " + text.toUpperCase()); // "HOLA, MUNDO!"
        System.out.println("Minúsculas: " + text.toLowerCase()); // "hola, mundo!"

        // equals(Object obj): compara contenido, distingue mayúsculas.
        String text1 = "Hola";
        String text2 = "hola";
        System.out.println("¿Son iguales? " + text1.equals(text2)); // false

        // equalsIgnoreCase(String str): compara contenido sin distinguir mayúsculas.
        System.out.println("¿Son iguales (ignorando mayúsculas)? " + text1.equalsIgnoreCase(text2)); // true

        // contains(CharSequence s): ¿contiene este texto?
        System.out.println("¿Contiene 'mundo'? " + text.contains("mundo")); // true

        // indexOf(String str): posición de la primera aparición, -1 si no existe.
        System.out.println("indexOf('mundo'): " + text.indexOf("mundo")); // 6
        System.out.println("indexOf('xyz'): " + text.indexOf("xyz"));     // -1
        // lastIndexOf: posición de la última aparición.
        System.out.println("lastIndexOf('o'): " + text.lastIndexOf('o')); // 10

        // startsWith y endsWith.
        System.out.println("¿Empieza con 'Hola'? " + text.startsWith("Hola")); // true
        System.out.println("¿Termina con '!'? " + text.endsWith("!"));         // true

        // replace(old, new): reemplaza todas las apariciones.
        System.out.println("Reemplazo: " + text.replace("mundo", "Java")); // "Hola, Java!"

        // trim(): quita espacios al inicio y al final. strip() es la versión moderna (Unicode).
        String conEspacios = "   hola   ";
        System.out.println("trim: [" + conEspacios.trim() + "]");   // [hola]
        System.out.println("strip: [" + conEspacios.strip() + "]"); // [hola]

        // isEmpty(): longitud 0. isBlank(): vacío o solo espacios.
        System.out.println("isEmpty(\"\"): " + "".isEmpty());          // true
        System.out.println("isBlank(\"   \"): " + "   ".isBlank());    // true
        System.out.println("isEmpty(\"   \"): " + "   ".isEmpty());    // false

        // split(String regex): corta el texto y devuelve un arreglo.
        String csv = "manzana,pera,uva";
        String[] frutas = csv.split(",");
        System.out.println("Cantidad de frutas: " + frutas.length); // 3
        System.out.println("Segunda fruta: " + frutas[1]);          // pera

        // concat(String) y el operador +: unen Strings.
        System.out.println("concat: " + "Hola".concat(" Java")); // "Hola Java"

        // compareTo(String): 0 si son iguales, negativo si va antes alfabéticamente, positivo si va después.
        System.out.println("compareTo('a','b'): " + "a".compareTo("b")); // -1

        // join(delimitador, ...): une varios Strings con un separador.
        System.out.println("join: " + String.join("-", "a", "b", "c")); // "a-b-c"

        // repeat(int): repite el texto.
        System.out.println("repeat: " + "ab".repeat(3)); // "ababab"

        // valueOf(...): convierte otros tipos a String.
        System.out.println("valueOf: " + String.valueOf(123) + "!"); // "123!"

        // format(...): arma un String con marcadores (%s texto, %d entero, %.2f decimal).
        // El separador decimal depende de la configuración regional (en Argentina sale "1,78").
        System.out.println(String.format("Hola %s, tenés %d años y medís %.2f m", "Lauta", 25, 1.78));

        // toCharArray(): convierte el String en un arreglo de char.
        char[] letras = "Java".toCharArray();
        System.out.println("Primera letra: " + letras[0] + " | cantidad: " + letras.length);
    }
}
