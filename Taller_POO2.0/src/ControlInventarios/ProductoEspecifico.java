package ControlInventarios;

public class ProductoEspecifico extends Producto {
    //Atributos
    public int id;
    public String categoria;
    public String marca;

    //constructor

    public ProductoEspecifico() {}

    public ProductoEspecifico(String nombre, float precio, int cantidad, String categoria, String marca) {
        super(nombre, precio, cantidad);
        id++;
        this.categoria = categoria;
        this.marca = marca;
    }


    // getters y setters

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //metodo

    @Override
    public String toString() {
        return  "id : " + id +
                ", nombre: " + this.getNombre() +
                ", precio: " + this.getPrecio() +
                ", cantidad: " + this.getCantidad() +
                ", categoria: " + categoria +
                ", marca=" + marca + "\n";
    }
}
