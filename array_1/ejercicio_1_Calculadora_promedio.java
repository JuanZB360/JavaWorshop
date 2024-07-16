package array_1;
import java.util.Scanner;

public class ejercicio_1_Calculadora_promedio {
    public static void main(String[] args) {

        //Escribe un programa que utilice un array de tipo double para almacenar las calificaciones finales de 10 estudiantes en un curso. El programa debe calcular y mostrar el promedio de estas calificaciones.

        System.out.println("Calculadora de Promedio:");
        Scanner scanner = new Scanner(System.in);
        double [][] ratings = new double [5][10];
        String [] student = new String [10];
        double [] average = new double [10];
        double a = 0;
        
        System.out.println("Sistema de calificaciones: ");

        for(int i = 0; i < 10; i++){
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            student[i] = scanner.nextLine();

            for(int j = 0; j < 5; j++){
                System.out.println("Ingrese la calificación del estudiante " + student[i] + " en la materia " + (j + 1) + ": ");

                ratings[j][i] = scanner.nextDouble();

                if(j==4){
                    for(int k = 0; k < 10; k++){
                        for(int l = 0; l < 5; l++){
                            a += ratings[l][k];
                            if(l==4){
                                average[i] = a / 5;
                            }
                        }
                    }
                }
                scanner.nextLine();
            }
        }

        for(int i = 0; i < 10; i++){
            System.out.println("Estudiante: " + student[i] +" :");
            for(int j = 0; j < 5; j++){
                if(j<=3){
                    System.out.print(ratings[j][i] + " + ");
                }else{
                    System.out.print(ratings[j][i] + " = "+average[i]);
                }
                
            }
            System.out.println("  Promedio: " + average[i]);
        }

        scanner.close();

    }
}
