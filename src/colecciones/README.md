# Sección: Estructuras de datos y colecciones

Orden sugerido para leer los archivos. Cada tema tiene su número en el comentario inicial del archivo.
Cada archivo es independiente y tiene su propio `main`: se ejecuta solo. Las clases de ejemplo
(`Persona`, `Alumno`, etc.) están dentro del mismo archivo como clases `static` anidadas.

| # | Tema | Archivo | Idea clave |
|---|------|---------|------------|
| 01 | Introducción a las estructuras de datos | `IntroEstructurasDatos.java` | Qué son y mapa de lo que se ve: Array, List, Set y Map. |
| 02 | Arrays: parte 1 | `ArraysParte1.java` | Tamaño fijo, índices desde 0, valores por defecto, `length`, recorridos. |
| 03 | Arrays: parte 2 | `ArraysParte2.java` | Matrices y la clase `Arrays` (`sort`, `copyOf`, `equals`, `binarySearch`). |
| 04 | Collection: List y Set | `ColeccionesListYSet.java` | List: orden y repetidos. Set: sin repetidos. |
| 05 | List: ArrayList | `ListaArrayList.java` | Respaldada por un array: rápida para leer por índice. |
| 06 | List: LinkedList | `ListaLinkedList.java` | Nodos enlazados: rápida en los extremos. Cola y pila. |
| 07 | Comparación de rendimientos | `RendimientoArrayListLinkedList.java` | Mide ambas listas. Los tiempos varían según la máquina. |
| 08 | Entendiendo `equals()` | `MetodoEquals.java` | `==` vs `equals`, y por qué va con `hashCode`. |
| 09 | HashSet con wrappers | `HashSetWrapper.java` | Sin repetidos y sin orden. Unión, intersección y diferencia. |
| 10 | HashSet con clases personalizadas | `HashSetPersonalizado.java` | Necesita `equals` y `hashCode` propios. |
| 11 | HashSet CRUD | `HashSetCrud.java` | Crear, leer, actualizar y borrar en un Set (no hay `get(i)`). |
| 12 | LinkedHashSet | `LinkedHashSetEjemplo.java` | HashSet que recuerda el orden de inserción. |
| 13 | TreeSet con wrappers | `TreeSetWrapper.java` | Siempre ordenado, con `first`, `last`, `floor`, `headSet`... |
| 14 | TreeSet con clases personalizadas | `TreeSetPersonalizado.java` | `Comparable` vs `Comparator`; cuidado con `compareTo == 0`. |
| 15 | TreeMap, HashMap y LinkedHashMap | `MapsIntroduccion.java` | Pares clave-valor y diferencias entre las tres implementaciones. |
| 16 | Map con wrappers | `MapWrapper.java` | `get`, `getOrDefault`, `merge`, `entrySet`, y navegación con TreeMap. |
| 17 | Map con clases personalizadas | `MapPersonalizado.java` | Clase propia como valor y como clave (`equals`/`hashCode`/`compareTo`). |
| 18 | Iteradores y recorridos avanzados | `IteradoresRecorridos.java` | `Iterator`, `removeIf`, `forEach` y recorridos de un Map. |
| 19 | La interfaz ListIterator | `ListIteratorEjemplo.java` | Recorrido en ambos sentidos y modificar con `set`/`add`/`remove`. |

## Cuál elegir

| Necesito... | Uso |
|-------------|-----|
| Cantidad fija y acceso por posición | Array |
| Lista que crece, acceso por posición | `ArrayList` (la opción por defecto) |
| Agregar/sacar seguido por los extremos | `LinkedList` |
| Sin repetidos, lo más rápido | `HashSet` |
| Sin repetidos, manteniendo el orden de inserción | `LinkedHashSet` |
| Sin repetidos, siempre ordenado | `TreeSet` |
| Buscar valores por clave | `HashMap` (o `LinkedHashMap` / `TreeMap` si importa el orden) |

## Cómo ejecutar

- **IntelliJ:** botón verde de play junto al `main()` del archivo.
- **Consola**, desde la raíz del proyecto (ejemplo con el tema 05):

```
javac -d out src/colecciones/ListaArrayList.java
java -cp out colecciones.ListaArrayList
```

Para compilar todo el paquete de una vez: `javac -d out src/colecciones/*.java`.
