package poo;

// 07. Herencia vs composición (ejecución)
//
// EN PALABRAS SIMPLES
// Hay dos formas de que una clase reutilice el código de otra:
//
// - Herencia ("es un"): Perro extends Animal. El perro ES un animal y recibe todo lo del animal,
//   sin poder elegir qué.
// - Composición ("tiene un"): una Computadora TIENE un Procesador adentro. Lo usa, pero no ES un procesador.
//
// El problema de la herencia, con un ejemplo cotidiano:
//   Queremos una pila de platos, donde solo se saca el de arriba. Para no escribir todo de cero,
//   la hacemos heredar de ArrayList (una lista común). Pero entonces la pila recibe TODO lo de la lista,
//   incluso poder meter un plato por abajo. Eso rompe lo que es una pila.
//
// La solución con composición:
//   La pila TIENE una lista escondida adentro y solo muestra los botones que tienen sentido:
//   apilar y desapilar. Usa la lista, pero nadie desde afuera puede romper la pila.
//
// Regla rápida:
//   ¿Se puede decir "X es un Y"?          -> herencia.
//   ¿Solo necesito usar lo que hace Y?    -> composición.
//
// En el código: PilaHerencia es la que se puede romper y PilaComposicion es la protegida.
//
// DETALLE TÉCNICO
// Cómo elegir:
// - Herencia: relación "ES UN" (un Perro ES UN Animal). Úsala cuando la hija es de verdad
//   un tipo más específico del padre y va a usarse en su lugar (polimorfismo).
// - Composición: relación "TIENE UN" (una Computadora TIENE UN Procesador). Úsala para reutilizar
//   comportamiento sin heredar toda la interfaz pública del otro.
//
// Por qué se suele preferir la composición ("favorecer composición sobre herencia"):
// - La herencia acopla fuerte: un cambio en el padre puede romper a todas las hijas.
// - La hija hereda TODO lo público del padre, lo necesite o no.
// - Solo se puede heredar de UNA clase; en cambio se pueden componer muchas.
// - La composición se puede cambiar en ejecución (cambiando el objeto interno); la herencia es fija.
public class HerenciaVsComposicionMain {
    public static void main(String[] args) {
        // Con herencia: funciona, pero la Pila queda "abierta".
        PilaHerencia<String> pila1 = new PilaHerencia<>();
        pila1.apilar("A");
        pila1.apilar("B");
        pila1.apilar("C");
        pila1.add(0, "INTRUSO"); // compila: se coló un elemento por abajo, rompe el concepto de pila
        System.out.println("Pila con herencia: " + pila1);

        // Con composición: solo existen apilar, desapilar y tamanio.
        PilaComposicion<String> pila2 = new PilaComposicion<>();
        pila2.apilar("A");
        pila2.apilar("B");
        pila2.apilar("C");
        // pila2.add(0, "INTRUSO"); // NO compila: la pila no expone ese método
        System.out.println("Desapilo: " + pila2.desapilar() + " | quedan " + pila2.tamanio());
    }
}
