package array_2;
import java.util.Scanner;

public class ejercicio_3_Notas_curso {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        /*
        Crea un programa que calcula la calificación promedio que se necesita obtener en las notas faltantes de un curso para aprobarlo, considerando la cantidad de calificaciones totales, las calificaciones ya obtenidas, el puntaje mínimo requerido para aprobar y la cantidad de notas faltantes. Importante: el total de notas del curso será de 8 notas, la calificación será de 0 a 100 y el promedio mínimo para aprobar el curso es de 76.
         */

        System.out.println("Notas de un Curso");
        int[] qualification = new int[8];
        String answer = "si";
        int count = 0;
        int qualificationMin = 8 * 76, qualificationSum = 0, sum = 0
        , average = 0;

        for (int i = 0; i < qualification.length; i++){
            qualification[i] = -1;
        }

        do{
            System.out.println("Ingrese la nota nuemero "+(count+1)+": ");
            qualification[count] = scanner.nextInt();

            count+=1;
            
            if(count <= 8){
                System.out.println("Desea ingresar otra calificación? (si/no)");
                answer = scanner.next();
            }else{
                scanner.close();
                break;
            }
        
        }while(answer.equals("si"));

        for(int i = 0; i < qualification.length; i++){
            if(qualification[i] >= 0){
                sum+=1;
                qualificationSum += qualification[i];
            }else{
                break;
            }
        }

        average = (qualificationMin - qualificationSum) / (8 - sum);

        System.out.println("\nCalificación promedio necesaria en las proximas "+(8-sum)+" : "+ average);

    }
}
