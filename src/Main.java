import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        FabricaDeMueble f1 = new FabricaDeMueble();
        Muebleria Union_costera = new Muebleria();

        Union_costera.agregarMueble(f1.cargarManualmente());


        System.out.println();
        Union_costera.mostrarInventario();

        System.out.println("Fin del programa.");

    }

}