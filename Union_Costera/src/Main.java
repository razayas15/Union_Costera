import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear una mueblería
            Muebleria muebleria = new Muebleria();

            // Crear diferentes tipos de muebles y agregarlos al inventario de la mueblería
            Mueble silla = new Mueble("Silla", "Madera", 12, 150);
            Mueble mesa = new Mueble("Mesa", "Metal", 5, 300);
            Mueble ventana = new Mueble("Ventana", "Vidrio", 8, 200);
            Mueble puerta = new Mueble("Puerta", "Madera", 6, 250);
            Mueble ropero = new Mueble("Ropero", "Madera", 4, 400);

            muebleria.agregarMueble(silla);
            muebleria.agregarMueble(mesa);
            muebleria.agregarMueble(ventana);
            muebleria.agregarMueble(puerta);
            muebleria.agregarMueble(ropero);

            // Mostrar inventario de la mueblería
            List<Mueble> inventario = muebleria.getInventario();
            for (Mueble mueble : inventario) {
                System.out.println("Mueble: " + mueble.getTipo() + ", Material: " + mueble.getMaterial() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
            }

            // Vender muebles
            Mueble muebleVendido = muebleria.venderMueble("Silla", 2);
            System.out.println("Vendido: " + muebleVendido.getTipo() + ", Stock restante: " + muebleVendido.getStock());

            // Intentar vender más muebles de los que hay en stock
            try {
                muebleria.venderMueble("Ventana", 10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Filtrar muebles por material
            List<Mueble> mueblesDeMadera = muebleria.filtrarPorMaterial("Madera");
            System.out.println("Muebles de madera:");
            for (Mueble mueble : mueblesDeMadera) {
                System.out.println("Mueble: " + mueble.getTipo() + ", Material: " + mueble.getMaterial() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
            }

            // Filtrar muebles por stock menor a una cantidad
            List<Mueble> mueblesConStockMenorA10 = muebleria.filtrarPorStockMenorA(10);
            System.out.println("Muebles con stock menor a 10:");
            for (Mueble mueble : mueblesConStockMenorA10) {
                System.out.println("Mueble: " + mueble.getTipo() + ", Material: " + mueble.getMaterial() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
            }

            int cantidad = 10;

            // Filtrar muebles por stock mayor o igual a una cantidad específica
            List<Mueble> mueblesConStockMayorOIgualA = muebleria.filtrarPorStockMayorOIgualA(cantidad);
            System.out.println("Muebles con stock mayor o igual a " + cantidad + ":");
            for (Mueble mueble : mueblesConStockMayorOIgualA) {
                System.out.println("Mueble: " + mueble.getTipo() + ", Material: " + mueble.getMaterial() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
            }

            // Filtrar muebles por tipo
            String tipo = "Silla";
            List<Mueble> mueblesPorTipo = muebleria.filtrarPorTipo(tipo);
            System.out.println("Muebles del tipo " + tipo + ":");
            for (Mueble mueble : mueblesPorTipo) {
                System.out.println("Mueble: " + mueble.getTipo() + ", Material: " + mueble.getMaterial() + ", Stock: " + mueble.getStock() + ", Precio: " + mueble.getPrecio());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
