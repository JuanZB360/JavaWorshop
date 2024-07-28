package Stock;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> stock = new ArrayList<>();

        boolean sesion = true;
        while (sesion){
            // Menu
            System.out.println("Menu:\n\t1-Crear Producto\n\t2-Mostrar Producto\n\t3-Buscar Producto\n\t4-Eliminar Producto\n\t5-Salir");
            System.out.print("Seleccion: ");
            int opcion = scanner.nextInt();
            System.out.println("\n");
            switch (opcion){
                case 1:
                    // Crear Producto
                    Producto producto = new Producto();
                    scanner.nextLine(); // Limpiar buffer de entrada
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    producto.setNombre(nombre);
                    producto.setDescripcion(descripcion);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    // Agregar Producto al Stock
                    stock.add(producto);
                    System.out.println("\n");
                    break;

                case 2:
                    // Mostrar Producto
                    System.out.println(stock);
                    System.out.println("\n");
                    break;
                case 3:
                    // Buscar Producto
                    scanner.nextLine();
                    System.out.print("Ingresa nombre del Producto: ");
                    String busqueda = scanner.nextLine();
                    for (Producto busque : stock) {
                        if(busque.getNombre().equalsIgnoreCase(busqueda)) {
                            System.out.println(busque);
                            break;
                        }else{
                            System.out.println("No se encontro el producto " + busqueda);
                        }
                    }
                    System.out.println("\n");
                    break;
                case 4:
                    // Eliminar Producto
                    scanner.nextLine();
                    System.out.print("Ingresa el nombre del producto: ");
                    busqueda = scanner.nextLine();
                    for (Producto busque : stock) {
                        if(busque.getNombre().equalsIgnoreCase(busqueda)) {
                            stock.remove(busque);
                            System.out.println("Se elimino el producto Exitosamente.");
                            break;
                        }else{
                            System.out.println("No se encontro el producto " + busqueda);
                        }
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Cerrando programa...");
                    sesion = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
