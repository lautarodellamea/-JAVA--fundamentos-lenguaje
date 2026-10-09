package objetos;

// 11. El método main() - punto de entrada
// La JVM busca este método exacto para arrancar un programa:
//
//   public static void main(String[] args)
//
// - public: la JVM lo llama desde afuera de la clase, tiene que ser visible.
// - static: la JVM lo llama SIN crear un objeto de la clase (antes de arrancar no existe ninguno).
// - void: no devuelve nada a la JVM.
// - main: el nombre que la JVM busca. Con otro nombre la clase compila, pero no se puede ejecutar.
// - String[] args: argumentos que se pasan por consola al ejecutar (el nombre "args" es libre).
//
// Cada clase puede tener su propio main; al ejecutar se elige cuál usar como punto de entrada.
public class PuntoDeEntrada {
    public static void main(String[] args) {
        System.out.println("Cantidad de argumentos recibidos: " + args.length);

        // args es un arreglo de String: si no se pasa nada, está vacío (no es null).
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }

        // Como todo es String, hay que convertir si se espera un número.
        if (args.length > 0) {
            int numero = Integer.parseInt(args[0]);
            System.out.println("El primer argumento más 1 es: " + (numero + 1));
        }

        // main es un método static más: se puede llamar a otros static y hasta a sí mismo.
        saludar();
    }

    static void saludar() {
        System.out.println("Hola desde un método llamado por main");
    }

    // Otro método con el nombre main pero distinta firma es una sobrecarga común:
    // la JVM NO lo usa como punto de entrada.
    static void main(int cantidad) {
        System.out.println("Este main(int) no es el punto de entrada");
    }
}
