package ControlInventarios;
import java.util.ArrayList;

public class Inventario {
    //Atributos
    private ArrayList<ProductoEspecifico> productos;

    // Constructor
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    //metodos
    public void agregarProducto(ProductoEspecifico producto) {
        productos.add(producto);
    }

    public void eliminarProducto(int id) {
        for(ProductoEspecifico e: productos) {
            if (e.getId
                    () == id) {
                productos.remove(e);
                return;
            }else{
                System.out.println("No se encontro el producto");
            }
        }
    }

    public void mostrarProductos() {
        for (ProductoEspecifico  a: productos) {
            System.out.println(a);
        }
    }

    public void buscarProductoNombre (String nombre) {
        int i = 0;
        for (Producto a: productos) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(a);
                i+=1;
            }
        }
        if (i == 0)  {
            System.out.println("Producto no encontrado.");
        }
        System.out.println("Producto no encontrado.");
    }

    public void buscarProductoCategoria (String nombre) {
        int i = 0;
        for (ProductoEspecifico a: productos) {
            if (a.getCategoria().equalsIgnoreCase(nombre)) {
                System.out.println(a);
                i+=1;
            }
        }
        if (i == 0)  {
            System.out.println("Producto no encontrado.");
        }
        System.out.println("Producto no encontrado.");
    }




}
