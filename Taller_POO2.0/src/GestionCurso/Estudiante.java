package GestionCurso;

public class Estudiante {
    // Atributos
    private int id;
    private String nombre;
    private String email;

    // Constructor
    public Estudiante(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Metodo

    @Override
    public String toString() {
        return " Id=" + id + ", Nombre='" + nombre + '\'' + ", Email='" + email + "\n";
    }
}
