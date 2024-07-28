package GestionCurso;
import java.util.ArrayList;

public class Curso {
    // Atributos
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    // Constructor
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }
    public Curso(){}

    //Getters y Setters
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCurso() {
        return this.nombre;
    }

    public void setNombreCurso(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return this.estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    // Metodos
    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return " Codigo: " + codigo + ", Nombre: " + nombre + "\nEstudiantes:\n" + estudiantes + "\n";
    }
}
