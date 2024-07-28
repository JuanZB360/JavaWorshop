package Stock;
import java.util.ArrayList;

public class Producto {

    private static int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;


    // Constructor
    public Producto() {
        ++id;
    }

    public Producto (String nombre, String descripcion, double precio, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        ++id;
    }

    //Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    //Metodos

    public void IngresaProducto(int cantidad) {
        this.cantidad += cantidad;
    }

    public void SacarProducto(int cantidad) {
        if(this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No hay suficiente en el Stock.\nSolo hay "+this.cantidad);
        }
    }

    @Override
    public String toString() {
        return  "Id: " + id +
                " nombre: " + nombre +
                ", descripcion: " + descripcion +
                ", precio: " + precio +
                ", cantidad: " + cantidad + "\n";
    }
}
