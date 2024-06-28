
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Muebleria {
    private List<Mueble> inventario;

    public Muebleria() {
        this.inventario = new ArrayList<>();
    }

    public void agregarMueble(Mueble mueble) {
        inventario.add(mueble);
    }

    public List<Mueble> getInventario() {
        return new ArrayList<>(inventario);
    }

    public Mueble venderMueble(String tipo, int cantidad) throws Exception {
        for (Mueble mueble : inventario) {
            if (mueble.getTipo().equals(tipo)) {
                mueble.reducirStock(cantidad);
                return mueble;
            }
        }
        throw new Exception("Mueble " + tipo + " no encontrado.");
    }

    public List<Mueble> filtrarPorMaterial(String material) {
        return inventario.stream()
                .filter(mueble -> mueble.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    public List<Mueble> filtrarPorStockMenorA(int cantidad) {
        return inventario.stream()
                .filter(mueble -> mueble.getStock() < cantidad)
                .collect(Collectors.toList());
    }


    public List<Mueble> filtrarPorStockMayorOIgualA(int cantidad) {
        return inventario.stream()
                .filter(mueble -> mueble.getStock() >= cantidad)
                .collect(Collectors.toList());
    }

    public List<Mueble> filtrarPorTipo(String tipo) {
        return inventario.stream()
                .filter(mueble -> mueble.getTipo().equals(tipo))
                .collect(Collectors.toList());
    }

    public void imprimirInventario() {
        System.out.println("Inventario:");
        for (Mueble mueble : inventario) {
            System.out.println("Mueble: " + mueble.getTipo() + ", Material: " + mueble.getMaterial() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
        }
    }

    public void imprimirMuebles(List<Mueble> muebles) {
        for (Mueble mueble : muebles) {
            System.out.println("Mueble: " + mueble.getTipo() + ", Material: " + mueble.getMaterial() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
        }
    }
}
