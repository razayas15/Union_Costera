import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        FabricaDeMueble f1 = new FabricaDeMueble();
        Muebleria Union_costera = new Muebleria();

        Mueble mueble = f1.cargarManualmente();
        System.out.println(mueble);


        System.out.println("Fin del programa.");

    }

}