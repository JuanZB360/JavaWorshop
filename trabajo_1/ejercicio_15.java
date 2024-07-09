package trabajo_1;
import java.util.Scanner;

public class ejercicio_15 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Implementa un programa que le pida al usuario la calificación de un examen (0-100). Basado en la calificación, el programa debe mostrar una letra (A, B, C, D, F), donde A es 90-100, B es 80-89, etc. Considera utilizar if o switch.

        System.out.println("Sistema de Calificaciones");

        System.out.println("Ingresa tu calificacion de 0 a 100: ");
        int calificacion = scanner.nextInt();

        if (calificacion>=90 && calificacion<=100){
            System.out.println("Tu calificacion es A");
        } else if (calificacion>=80 && calificacion<=89){
            System.out.println("Tu calificacion es B");
        } else if (calificacion>=60 && calificacion<=79){
            System.out.println("Tu calificacion es C");
        } else if(calificacion>=40 && calificacion<=59){
            System.out.println("Tu calificacion es D");
        } else if (calificacion>=20 && calificacion<=39){
            System.out.println("Tu calificacion es E");
        } else if (calificacion>=0 && calificacion<=19){
            System.out.println("Tu calificacion es F");
        }

        scanner.close();
    }
}
