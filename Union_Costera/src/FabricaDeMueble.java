import java.util.Scanner;

public class FabricaDeMueble {
    Scanner scanner = new Scanner(System.in);

   public Mueble cargarManualmente(){
       while (true) {
           System.out.println("Bienvenido al menú para cargar muebles:");
           System.out.println("0 - Cargar un mueble");
           System.out.println("1 - Finalizar\n");
           System.out.print("Ingrese su opción: ");
           int opcion = scanner.nextInt();
           scanner.nextLine();
           if (opcion == 0) {
               System.out.print("Ingrese el tipo de mueble: ");
               String nombre = scanner.nextLine();

               System.out.println("Cantidad de Stock: ");
               int stock = scanner.nextInt();
               scanner.nextLine(); // Consume la línea restante

               System.out.println("Precio x Unidad:\n");
               int precio = scanner.nextInt();
               scanner.nextLine(); // Consume la línea restante

               System.out.println("Material del Producto: ");
               String material = scanner.nextLine();

               return new Mueble(nombre, stock, precio, material);
           }if (opcion == 1) {
               System.out.println("Finalizando la carga de muebles...");
               break;
           } else {
               System.out.println("Opción no válida. Por favor, intente de nuevo.");
           }
       }
       return null;
   }
}