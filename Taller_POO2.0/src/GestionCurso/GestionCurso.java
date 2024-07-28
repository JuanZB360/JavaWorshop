package GestionCurso;
import java.util.ArrayList;

public class GestionCurso {
    //Atributos
    private final ArrayList<Curso> cursos;

    //Constructor
    public GestionCurso() {
        this.cursos = new ArrayList<>();
    }

    //Metodos
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void mostrarCurso() {
        System.out.println(cursos);
    }
    public void InscribirEstudiante (String curso, Estudiante estudiante) {
        for (Curso c: cursos) {
            if (c.getNombreCurso().equalsIgnoreCase(curso)) {
                c.agregarEstudiante(estudiante);
                return;
            }
        }
        System.out.println("Curso no encontrado");
    }

    public int verificarCursos(String curso){
        int contador = 0;
        for (Curso c : cursos) {
            if (c.getNombreCurso().equalsIgnoreCase(curso)){
                contador += 1;
            }
        }
        return contador;
    }

    @Override
    public String toString() {
        return " Cursos=" + cursos + "\n";
    }
}
