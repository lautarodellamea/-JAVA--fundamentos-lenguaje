package poo;

import java.util.ArrayList;
import java.util.List;

// 04. Inmutabilidad de clases - atributos mutables
// Un atributo final NO alcanza si es mutable: final impide cambiar la REFERENCIA,
// no el contenido de la lista. Por eso se hacen copias defensivas.
public final class Pedido {
    private final String cliente;
    private final List<String> items;

    public Pedido(String cliente, List<String> items) {
        this.cliente = cliente;
        // Copia defensiva al ENTRAR: si guardáramos la lista original, quien la creó
        // podría seguir modificándola desde afuera y cambiar nuestro Pedido.
        this.items = new ArrayList<>(items);
    }

    public String getCliente() {
        return cliente;
    }

    public List<String> getItems() {
        // Al SALIR: devolvemos una vista que no se puede modificar (add/remove lanzan excepción).
        return List.copyOf(items);
    }

    // "Modificar" = devolver un Pedido nuevo con el item agregado.
    public Pedido conItem(String item) {
        List<String> nuevosItems = new ArrayList<>(items);
        nuevosItems.add(item);
        return new Pedido(cliente, nuevosItems);
    }

    @Override
    public String toString() {
        return "Pedido{cliente='" + cliente + "', items=" + items + "}";
    }
}
