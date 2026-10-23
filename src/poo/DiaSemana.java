package poo;

// 11. La clase enum
// Un enum es un tipo con un conjunto FIJO y cerrado de valores posibles (constantes).
// Evita usar Strings o números "sueltos" ("lunes", 1) donde un error de tipeo compila igual.
// Por convención, las constantes van en MAYÚSCULAS.
// Detrás, un enum es una clase especial: cada constante es un objeto único de ese tipo.
public enum DiaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
}
