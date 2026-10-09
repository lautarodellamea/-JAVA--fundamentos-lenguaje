package objetos;

// 06. La clase String
// String no es un tipo primitivo: es una clase, así que sus variables guardan referencias a objetos.
public class ClaseString {
    public static void main(String[] args) {
        // Dos formas de crear un String.
        String literal = "Hola";              // literal: va al String Pool
        String conNew = new String("Hola");   // new: crea un objeto nuevo fuera del pool

        // String Pool: los literales iguales comparten el mismo objeto para ahorrar memoria.
        String otroLiteral = "Hola";
        System.out.println("literal == otroLiteral: " + (literal == otroLiteral));
        System.out.println("literal == conNew: " + (literal == conNew));

        // == compara referencias (mismo objeto); equals() compara el contenido.
        System.out.println("literal.equals(conNew): " + literal.equals(conNew));

        // Inmutabilidad: un String nunca cambia una vez creado.
        // Lo que parece una modificación crea un String nuevo.
        String texto = "Java";
        texto.concat(" es genial");           // el resultado se descarta, texto no cambia
        System.out.println("Sin reasignar: " + texto);
        texto = texto.concat(" es genial");   // hay que reasignar para quedarse con el nuevo
        System.out.println("Reasignado: " + texto);

        // Concatenación con +.
        String nombre = "Lauta";
        int edad = 25;
        System.out.println("Me llamo " + nombre + " y tengo " + edad + " años");

        // Concatenar en un bucle crea un String nuevo por vuelta: ineficiente.
        // Para muchas modificaciones se usa StringBuilder, que sí es mutable.
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            builder.append("vuelta ").append(i).append(" ");
        }
        System.out.println(builder.toString().trim());

        // String vacío vs null: no son lo mismo.
        String vacio = "";
        String nulo = null;
        System.out.println("Vacío: longitud " + vacio.length());
        System.out.println("Nulo: " + nulo);
        // nulo.length(); // lanzaría NullPointerException
    }
}
