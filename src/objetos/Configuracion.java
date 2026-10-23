package objetos;

import java.util.HashMap;
import java.util.Map;

// 10. Bloque static
public class Configuracion {
    // Atributo static que necesita lógica para inicializarse (no alcanza con una sola línea).
    static final Map<String, String> VALORES = new HashMap<>();

    // Bloque static: se ejecuta UNA sola vez, cuando la JVM carga la clase
    // (la primera vez que se usa: un new, un static o un main de esa clase).
    // Se ejecuta antes que cualquier constructor y antes que cualquier método static llamado desde afuera.
    static {
        System.out.println("[bloque static] cargando configuración...");
        VALORES.put("idioma", "es");
        VALORES.put("moneda", "ARS");
    }

    // Bloque de instancia (distinto del static): se ejecuta en CADA new, antes del constructor.
    {
        System.out.println("[bloque de instancia] preparando objeto...");
    }

    Configuracion() {
        System.out.println("[constructor] objeto creado");
    }

    static String obtener(String clave) {
        return VALORES.get(clave);
    }
}
