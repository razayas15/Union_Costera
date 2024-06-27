public class Mueble {
    private String nombre; //Seria el nombre
    private int stock; // Cantidad max de mismo elemento
    private int precio; //Precio X unidad
    private String material; //El matarial del producto


    public Mueble(String tipo, int stock, int precio, String material) {
        this.nombre = tipo;
        this.stock = stock;
        this.precio = precio;
        this.material = material;
    }
    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean reducirStock(int cantidad) {
        if (cantidad > stock) {
            return false;
        }
        stock -= cantidad;
        return true;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String toString() {
        return "Mueble{" +
                "nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", material=" + material +
                '}';
    }
}
