package GestionCurso;
import java.util.Scanner;

public class Secretario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionCurso gestion = new GestionCurso();
        int id = 0;
        System.out.println("*** Gestion de Cursos ***");
        boolean sesion = true;
        while (sesion) {
            System.out.println("Menu:\n\t1- crear Curso\n\t2- Incribir Estudiante a un curso\n\t3- Mostrar cursos\n\t4- Salir");
            System.out.print("Ingrese su opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("*** Crear Curso ***");
                    System.out.print("Ingrese codigo del curso: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese nombre del curso: ");
                    String nombreCurso = scanner.nextLine();
                    int contador = gestion.verificarCursos(nombreCurso);

                    if(contador == 0) {
                        Curso curso = new Curso(codigo, nombreCurso);
                        gestion.agregarCurso(curso);
                    }else {
                        System.out.println("Este curso ya existe...");
                    }

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("*** Inscribir estudiante ***");
                    System.out.print("Ingrese Nombre del curso: ");
                    String NombreCurso = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Estudiante estudiante = new Estudiante(id,nombreEstudiante, email);
                    gestion.InscribirEstudiante(NombreCurso, estudiante);
                    id += 1;
                    break;
                case 3:
                    System.out.println("*** Mostrar Cursos ***");
                    gestion.mostrarCurso();
                    break;
                case 4:
                    System.out.println("Cerrando programa...");
                    sesion = false;
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
        }
    }
}
