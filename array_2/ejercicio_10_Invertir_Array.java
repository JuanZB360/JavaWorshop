package array_2;

import java.util.Scanner;

public class ejercicio_10_Invertir_Array {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        /*
            Escribe un programa en Java que invierta el orden de los elementos en un array de números enteros.(Sin métodos)
         */

        System.out.println("Ingresa la longitud del array");
        int a = scanner.nextInt();
        int[] array = new int[a];
        int[] array_2 = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingresa el número " + (i+1) + ": ");
            array[i] = scanner.nextInt();
        }
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+"  ");
        }
        for(int i = 0; i < a; i++){
            array_2[i] = array[a-1-i];
        }
        System.out.println("\n");
        for(int i = 0; i < array_2.length; i++){
            System.out.print(array_2[i]+"  ");
        }

        scanner.close();
    }
}
