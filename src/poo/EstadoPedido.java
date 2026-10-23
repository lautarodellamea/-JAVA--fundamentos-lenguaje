package poo;

// 11. La clase enum - con atributos, constructor y métodos
// Como es una clase, un enum puede tener atributos, constructor y métodos.
public enum EstadoPedido {
    // Cada constante llama al constructor con sus valores.
    PENDIENTE("Pendiente de pago", false),
    PAGADO("Pago recibido", false),
    ENVIADO("En camino", false),
    ENTREGADO("Entregado al cliente", true),
    CANCELADO("Pedido cancelado", true);

    private final String descripcion;
    private final boolean finalizado;

    // El constructor de un enum es siempre privado (no se pueden crear valores nuevos con new).
    EstadoPedido(String descripcion, boolean finalizado) {
        this.descripcion = descripcion;
        this.finalizado = finalizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isFinalizado() {
        return finalizado;
    }
}
