package poo;

// 02. Encapsulación (ejecución)
public class PersonaMain {
    public static void main(String[] args) {
        Persona persona = new Persona("12345678", "  Lauta ", 25);
        System.out.println(persona);
        System.out.println("¿Es mayor de edad? " + persona.esMayorDeEdad());

        // Cambios válidos: pasan por el setter.
        persona.setEdad(30);
        System.out.println("Edad actualizada: " + persona.getEdad());

        // Los atributos son privados: no se puede saltear la validación.
        // persona.edad = -5;   // NO compila
        // persona.dni = "0";   // NO compila (y además es final)

        // Cambios inválidos: el setter los rechaza y el objeto queda intacto.
        try {
            persona.setEdad(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }
        System.out.println("Edad sigue siendo: " + persona.getEdad());
    }
}
