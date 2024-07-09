package trabajo_1;
import java.util.Scanner;

public class ejercicio_8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Escribe un programa que solicite al usuario ingresar tres calificaciones, calcule el promedio ymuestre un mensaje indicando si el alumno aprueba o no (considera que se aprueba con un promedio de 6 o más).

        System.out.println("calculo de Promedio");

        System.out.println("Nota 1:");
        float nota1 = scanner.nextInt();
        System.out.println("Nota 2:");
        float nota2 = scanner.nextInt();
        System.out.println("Nota 3:");
        float nota3 = scanner.nextInt();

        float promedio = nota1 + nota2 +nota3 / 3;

        if (promedio < 3.0){
            System.out.println("Nota final "+promedio+" has pedido la materia con un insuficiente");
        }else if(promedio >= 3.0 && promedio <= 4.0){
            System.out.println("Nota Final "+promedio+" has aprobado la materia con un aceptable");
        }else if(promedio >4.0 && promedio >= 4.5){
            System.out.println("Nota Final "+promedio+" has aprobado la materia con un sobre saliente");
        }else if (promedio >4.5 && promedio <=5.0){
            System.out.println("Nota Final "+promedio+" has aprobado la materia con un excelente");
        }

        scanner.close();
    }
}
