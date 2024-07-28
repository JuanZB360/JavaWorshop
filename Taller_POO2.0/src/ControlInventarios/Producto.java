package ControlInventarios;

public class Producto {
    //Atributos
    private String nombre;
    private float precio;
    private int cantidad;

    //Constructor
    public Producto () {}

    public Producto (String nombre, float precio, int cantidad) {
                this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
