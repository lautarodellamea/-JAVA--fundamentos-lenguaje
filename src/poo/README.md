# Sección: Programación Orientada a Objetos (POO)

Orden sugerido para leer los archivos. Cada tema tiene su número en el comentario inicial del archivo.
Los que terminan en `Main` son los que se ejecutan (tienen el método `main`); el resto son las clases que usan.

| # | Tema | Archivos | Idea clave |
|---|------|----------|------------|
| 01 | Abstracción | `Cafetera.java`, `CafeteraMain.java` | Mostrar solo lo esencial y ocultar el cómo (métodos privados). |
| 02 | Encapsulación | `Persona.java`, `PersonaMain.java` | Atributos privados + getters/setters que validan. Explica `@Override`. |
| 03 | Herencia | `Vehiculo.java`, `Automovil.java`, `Moto.java`, `VehiculoMain.java` | `extends`, `super(...)`, `protected` y sobreescritura. |
| 04 | Inmutabilidad de clases | `Dinero.java`, `Pedido.java`, `InmutabilidadMain.java` | `final`, sin setters y copias defensivas. |
| 05 | Polimorfismo: sobrecarga y sobreescritura | `Impresora.java`, `Animal.java`, `Perro.java`, `Gato.java`, `PolimorfismoMain.java` | Sobrecarga se decide al compilar; sobreescritura al ejecutar. |
| 06 | Polimorfismo de inclusión | `PolimorfismoInclusion.java` | Un hijo se usa donde se espera un padre. Upcasting, downcasting e `instanceof`. |
| 07 | Herencia vs composición | `PilaHerencia.java`, `PilaComposicion.java`, `HerenciaVsComposicionMain.java` | "es un" (herencia) vs "tiene un" (composición). Incluye explicación en palabras simples. |
| 08 | Ejemplo integrador | `Motor.java`, `Bicicleta.java`, `VehiculosMain.java` (más `Vehiculo`, `Automovil` y `Moto`) | Junta herencia, composición, polimorfismo y casting. |
| 09 | Clases abstractas (parte 1) | `Figura.java`, `Circulo.java`, `Rectangulo.java`, `FigurasMain.java` | Molde incompleto con métodos abstractos que las hijas deben implementar. |
| 10 | Interfaces (parte 2) | `Volador.java`, `Nadador.java`, `Pato.java`, `Avion.java`, `InterfacesMain.java` | Contrato de capacidades; se pueden implementar varias. |
| 10b | Interfaces: métodos con el mismo nombre | `Lector.java`, `Escritor.java`, `Tablet.java`, `ConflictoInterfacesMain.java` | Abstractos no chocan; los `default` obligan a resolver el conflicto. |
| 11 | La clase enum | `DiaSemana.java`, `EstadoPedido.java`, `EnumMain.java` | Conjunto fijo de valores; con atributos, constructor y métodos. |

## Cómo ejecutar

- **IntelliJ:** botón verde de play junto al `main()` del archivo `...Main`.
- **Consola**, desde la raíz del proyecto (ejemplo con el tema 01):

```
javac -d out src/poo/Cafetera.java src/poo/CafeteraMain.java
java -cp out poo.CafeteraMain
```

Para compilar todo el paquete de una vez: `javac -d out src/poo/*.java`.

## Mapa rápido de conceptos

- **Herencia** (`extends`): "es un". Una sola clase padre.
- **Interfaz** (`implements`): "puede hacer". Se pueden implementar varias.
- **Composición**: "tiene un". Una clase guarda a otra como atributo.
- **Clase abstracta**: molde que no se instancia y puede guardar estado y código compartido.
- **Sobrecarga**: mismo nombre, distintos parámetros (se resuelve al compilar).
- **Sobreescritura**: la hija redefine un método del padre (se resuelve al ejecutar).
