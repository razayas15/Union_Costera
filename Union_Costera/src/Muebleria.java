import java.util.List;
import java.util.ArrayList;
public class Muebleria {
    private List<Mueble> inventario;

    public Muebleria() {
        this.inventario = new ArrayList<>();
    }

    public void agregarMueble(Mueble mueble){
        inventario.add(mueble);
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la mueblería:");
        for (Mueble mueble : inventario) {
            System.out.println("Mueble: " + mueble.getNombre() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
        }
    }

    public boolean venderMueble(String tipo, int cantidad) {
        for (Mueble mueble : inventario) {
            if (mueble.getNombre().equals(tipo)) {
                if (mueble.reducirStock(cantidad)) {
                    System.out.println("Venta exitosa: " + cantidad + " " + tipo + "(s) vendidos.");
                    return true;
                } else {
                    System.out.println("Stock insuficiente para " + tipo + ".");
                    return false;
                }
            }
        }
        System.out.println("Mueble " + tipo + " no encontrado.");
        return false;
    }

}
