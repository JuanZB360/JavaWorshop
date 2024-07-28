package ControlInventarios;
import java.util.Scanner;

public class Caja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int id = 0;
        boolean sesion = true;

        while (sesion) {
            System.out.println("*** Inventario ***");
            System.out.println("Menu:\n\t1- Agregar Producto\n\t2- Eliminar Producto\n\t3- Mostrar Productos\n\t4- Buscar Productos por Nombre\n\t5- Buscar Producto por Categoria\n\t6- Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("*** Agregar Producto ***");
                    ProductoEspecifico producto = new ProductoEspecifico();
                    producto.setId(id);
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio: ");
                    float precio = scanner.nextFloat();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    producto.setCategoria(categoria);
                    producto.setMarca(marca);
                    id+=1;
                    producto.setId(id);
                    inventario.agregarProducto(producto);
                    break;
                case 2:
                    System.out.println("*** Eliminar Producto ***");
                    System.out.print("id de Producto: ");
                    int idProductoAEliminar = scanner.nextInt();
                    inventario.eliminarProducto(idProductoAEliminar);
                    break;
                case 3:
                    System.out.println("*** Mostrar Producto ***");
                    inventario.mostrarProductos();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("*** Buscar Producto por Nombre ***");
                    System.out.print("Nombre de Producto: ");
                    String nombreProductoBuscar = scanner.nextLine();
                    inventario.buscarProductoNombre(nombreProductoBuscar);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("*** Buscar Producto por Categoria ***");
                    System.out.print("Categoria de Producto: ");
                    String categoriaProductoBuscar = scanner.nextLine();
                    inventario.buscarProductoCategoria(categoriaProductoBuscar);
                    break;
                case 6:
                    System.out.println("Cerrando Programa...");
                    sesion = false;
                    break;
                default:
                    System.out.println("Ingresa una opcion Valida...");
            }

        }
    }
}
