package CalificacionesEstudiantes;
import java.util.ArrayList;
import java.util.Scanner;

public class Calificar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> lista = new ArrayList<>();
        boolean sesion = true;
        while(sesion) {
            System.out.println("menu:\n\t1- Ingresar estudiante\n\t2- mostrar estudiantes\n\t3- Buscar Estudiante\n\t4- Añadir Calificacion\n\t5- Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    Estudiante estudiante = new Estudiante();
                    scanner.nextLine();  //Limpiar buffer de entrada para la siguiente entrada de texto
                    System.out.println("*** Ingresar Estudiante ***");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    estudiante.setNombre(nombre);
                    System.out.print("Desea ingresar Notas(SI/NO): ");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("si")){
                        int a = 1;
                        do {

                            System.out.print("Nota "+a+": ");
                            float calificacion = scanner.nextFloat();
                            estudiante.anadirCalificacion(calificacion);
                            scanner.nextLine();
                            System.out.print("Deseas ingresar otra nota (SI/NO): ");
                            answer = scanner.nextLine();
                            a++;
                        }while(answer.equalsIgnoreCase("si"));
                    }
                    lista.add(estudiante);
                    break;
                case 2:
                    System.out.println(lista);
                    break;
                case 3:
                    System.out.println("*** Buscar Estudiante ***");
                    scanner.nextLine();
                    System.out.print("Ingresa Nombre del Estudiante: ");
                    String nombreEstudiante = scanner.nextLine();
                    for (Estudiante a: lista) {
                        if (a.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                            a.mostrarCalificaciones();
                            a.Promedio();
                        }
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("*** Añadir Calificaciones");
                    System.out.print("Nombre Estudiante: ");
                    String buscarestudiante = scanner.nextLine();
                    for(Estudiante a : lista){
                        if(a.getNombre().equalsIgnoreCase(buscarestudiante)){
                            int b = 1;
                            do {
                                System.out.print("Nota "+a+": ");
                                float calificacion = scanner.nextFloat();
                                b++;
                                a.anadirCalificacion(calificacion);
                                System.out.println("Desea añadir otra (SI/NO): ");
                                answer=scanner.nextLine();
                            }while(answer.equalsIgnoreCase("si"));

                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Cerrando programa...");
                    sesion = false;
                    break;
                default:
                    System.out.println("Ingresa un opcion valida...");
                    break;
            }
        }
    }
}
