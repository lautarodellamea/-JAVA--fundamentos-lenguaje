# Sección: Manejo de excepciones

Orden sugerido para leer los archivos. Cada tema tiene su número en el comentario inicial del archivo.
Cada archivo es independiente y tiene su propio `main`. Las excepciones propias están dentro del mismo
archivo como clases `static` anidadas. Los ejemplos con archivos crean y borran archivos temporales
solos: no dejan nada en el proyecto.

| # | Tema | Archivo | Idea clave |
|---|------|---------|------------|
| 01 | Conceptos básicos de excepciones | `ExcepcionesBasicas.java` | `try`, `catch`, `finally`, multi-catch, `throw`. |
| 02 | Manejo de excepciones con archivos | `ExcepcionesArchivos.java` | Excepciones checked y cierre manual del archivo con `finally`. |
| 03 | Refactorizando lectura de archivo | `RefactorizandoLecturaArchivo.java` | Separar quién lee (`throws`) de quién decide qué hacer con el error. |
| 04 | Jerarquía de excepciones | `JerarquiaExcepciones.java` | `Throwable` > `Error` / `Exception` > `RuntimeException`; orden de los `catch`. |
| 05 | Exception personalizada: checked | `ExcepcionCheckedPersonalizada.java` | `extends Exception`: el compilador obliga a manejarla. Incluye `cause`. |
| 06 | Exception personalizada: unchecked | `ExcepcionUncheckedPersonalizada.java` | `extends RuntimeException`: no obliga. Cuándo usar cada una. |
| 07 | try-with-resources | `TryWithResources.java` | Cierre automático de recursos, en orden inverso. |
| 08 | try-with-resources con AutoCloseable | `AutoCloseableEjemplo.java` | Recursos propios y excepciones suprimidas. |
| 09 | Debugging de excepciones | `DebuggingExcepciones.java` | Cómo leer un stack trace y atajos del debugger de IntelliJ. |

## Checked vs unchecked

| | Checked (`extends Exception`) | Unchecked (`extends RuntimeException`) |
|---|---|---|
| ¿El compilador obliga a manejarla? | Sí (`try-catch` o `throws`); si no, no compila | No; compila igual, pero si ocurre y nadie la captura, el programa se corta al ejecutar |
| Uso típico | Error esperable y recuperable | Bug o uso incorrecto del código |
| Ejemplo de Java | `IOException` | `NullPointerException` |

## Buenas prácticas

- Capturar lo más **específico** posible, y poner primero el `catch` más específico.
- Nunca dejar un `catch` vacío: siempre hacer algo útil (mostrar, registrar, recuperar).
- Al envolver una excepción en otra, pasar la **causa original** para no perder el rastro.
- Cerrar los recursos con **try-with-resources** y no con `finally` manual.

## Cómo ejecutar

- **IntelliJ:** botón verde de play junto al `main()` del archivo.
- **Consola**, desde la raíz del proyecto (ejemplo con el tema 01):

```
javac -d out src/excepciones/ExcepcionesBasicas.java
java -cp out excepciones.ExcepcionesBasicas
```

Para compilar todo el paquete de una vez: `javac -d out src/excepciones/*.java`.
