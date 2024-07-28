package CalificacionesEstudiantes;
import java.util.ArrayList;

public class Estudiante {
    // Atributos
    private String nombre;
    private final ArrayList<Float> calificaciones;

    // Constructor
    public Estudiante() {
        this.calificaciones = new ArrayList<>();
    }
    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    //Getter y Setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }

    //Metodo

    public void anadirCalificacion (float calificacion) {
        calificaciones.add(calificacion);
        System.out.println("Nota añadida Exitosamente...");
    }

    public void eliminarCalificacion (int index) {
        for (float calificacion: calificaciones) {
            if (calificaciones.indexOf(calificacion) == index) {
                calificaciones.remove(calificacion);
                System.out.println("Nota eliminada Exitosamente...");
                return;
            }
        }
    }

    public void Promedio () {
        float suma = 0;
        for (float calificacion : calificaciones) {
            suma += calificacion;
        }
        System.out.println("El promedio de " + nombre + " es: " + (suma / calificaciones.size()));
    }

    public void mostrarCalificaciones() {
        System.out.println("Calificaciones de " + nombre + ":\n");
        for (float calificacion : calificaciones) {
            System.out.println(calificacion);
        }
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre +
                ", calificaciones=" + calificaciones;
    }
}
