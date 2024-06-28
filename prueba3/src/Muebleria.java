
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Muebleria {
    private List<Mueble> inventario;

    public Muebleria() {
        this.inventario = new ArrayList<>();
    }

    // Si se agrega un campon vacio se rompe!!!!!!!!!!!!
    public void agregarOModificarMueble(Mueble mueble) {
        String tipoMinuscula = mueble.getTipo().toLowerCase();
        String materialMinuscula = mueble.getMaterial().toLowerCase();

        for (Mueble m : inventario) {
            if (m.getTipo().toLowerCase().equals(tipoMinuscula) && m.getMaterial().toLowerCase().equals(materialMinuscula)) {
                m.setStock(m.getStock() + mueble.getStock());
                return;
            }
        }
        inventario.add(mueble);
    }

    // Arreglar buscador
    public List<Mueble> buscarYOrdenarMuebles(String tipo, String material, String orden) {
        List<Mueble> resultados = new ArrayList<>();

        return resultados;
    }

    List<Mueble> filtrarPorTipo(String tipo) {
        return inventario.stream()
                .filter(mueble -> mueble.getTipo().toLowerCase().contains(tipo))
                .collect(Collectors.toList());
    }

    private List<Mueble> filtrarPorMaterial(String material) {
        return inventario.stream()
                .filter(mueble -> mueble.getMaterial().toLowerCase().contains(material))
                .collect(Collectors.toList());
    }

    private List<Mueble> filtrarPorTipoYMaterial(String tipo, String material) {
        return inventario.stream()
                .filter(mueble -> mueble.getTipo().toLowerCase().contains(tipo) && mueble.getMaterial().toLowerCase().contains(material))
                .collect(Collectors.toList());
    }

    private void ordenar(List<Mueble> muebles, String orden) {
        switch (orden) {
            case "Precio Ascendente":
                muebles.sort((m1, m2) -> Integer.compare(m1.getPrecio(), m2.getPrecio()));
                break;
            case "Precio Descendente":
                muebles.sort((m1, m2) -> Integer.compare(m2.getPrecio(), m1.getPrecio()));
                break;
            case "Stock Ascendente":
                muebles.sort((m1, m2) -> Integer.compare(m1.getStock(), m2.getStock()));
                break;
            case "Stock Descendente":
                muebles.sort((m1, m2) -> Integer.compare(m2.getStock(), m1.getStock()));
                break;
            default:
                break;
        }
    }

    public List<Mueble> getInventario() {
        return new ArrayList<>(inventario);
    }
}
