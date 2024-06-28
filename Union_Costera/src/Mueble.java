import java.util.Objects;

public class Mueble {
    private String tipo;
    private String material;
    private int stock;
    private int precio;

    public Mueble(String tipo, String material, int stock, int precio) {
        this.tipo = tipo;
        this.material = material;
        this.stock = stock;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
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

    public void reducirStock(int cantidad) throws Exception {
        if (cantidad > stock) {
            throw new Exception("Stock insuficiente para " + tipo);
        }
        stock -= cantidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mueble mueble = (Mueble) obj;
        return stock == mueble.stock && precio == mueble.precio && tipo.equals(mueble.tipo) && material.equals(mueble.material);
    }


}
