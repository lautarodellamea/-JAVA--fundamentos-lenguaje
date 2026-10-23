# Sección: Clases y objetos

Orden sugerido para leer los archivos. Cada tema tiene su número en el comentario inicial del archivo.
Los que tienen `Main` son los que se ejecutan (tienen el método `main`); el otro archivo es la clase que usan.

| # | Tema | Archivos | Idea clave |
|---|------|----------|------------|
| 01 | Atributos y métodos de clase | `Casa.java`, `CasaMain.java` | Atributos = estado, métodos = comportamiento. Cada `new` crea un objeto con sus propios valores. |
| 02 | Constructores de clase | `Auto.java`, `AutoMain.java` | Constructor vacío, con parámetros y sobrecargado (`this(...)`). Incluye `toString()`. |
| 03 | Modificadores de acceso | `CuentaBancaria.java`, `CuentaBancariaMain.java` | `public`, `protected`, default y `private`. Getters y setters. |
| 04 | Clases wrapper | `ClasesWrapper.java` | `int` → `Integer`, autoboxing/unboxing, `parseInt`, `equals` vs `==`. |
| 05 | El contexto de las variables | `ContextoVariables.java` | Scope: local, parámetro, instancia, `static` y de bloque. Shadowing y `this`. |
| 06 | La clase String | `ClaseString.java` | String Pool, inmutabilidad, `==` vs `equals`, `StringBuilder`. |
| 07 | Métodos de la clase String | `MetodosString.java` | `length`, `charAt`, `substring`, `split`, `replace`, `format`, etc. |
| 08 | Atributo static VS de instancia | `Empleado.java`, `EmpleadoMain.java` | `static` = una copia por clase; instancia = una copia por objeto. |
| 09 | Métodos de clase - static | `Calculadora.java`, `CalculadoraMain.java` | Se llaman sin `new`; no pueden usar `this`. Qué se duplica en memoria y qué no. |
| 10 | Bloque static | `Configuracion.java`, `ConfiguracionMain.java` | Corre una vez al cargar la clase; el bloque de instancia corre en cada `new`. |
| 11 | El método main() | `PuntoDeEntrada.java` | Por qué es `public static void main(String[] args)` y cómo pasar argumentos. |
| 12 | Refactorizando ejemplo final | *(pendiente)* | |
| 13 | Relaciones entre clases | `Procesador.java`, `Computadora.java`, `Jugador.java`, `Equipo.java`, `Taller.java`, `RelacionesMain.java` | Composición, agregación y dependencia. |
| 14 | Proyecto final - parte 1 | *(pendiente)* | |
| 15 | Proyecto final - parte 2 | *(pendiente)* | |

## Cómo ejecutar

- **IntelliJ:** botón verde de play junto al `main()` del archivo.
- **Consola**, desde la raíz del proyecto (ejemplo con el tema 01):

```
javac -d out src/objetos/Casa.java src/objetos/CasaMain.java
java -cp out objetos.CasaMain
```

## Relaciones entre clases, de más fuerte a más débil

1. **Composición:** la clase crea y es dueña de la otra (`Computadora` → `Procesador`).
2. **Agregación:** la clase agrupa objetos que se crean afuera y existen solos (`Equipo` → `Jugador`).
3. **Dependencia:** la clase usa a otra solo dentro de un método, sin guardarla (`Taller` → `Auto`).
