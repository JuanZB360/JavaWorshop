package array_2;

import java.util.Scanner;

public class ejercicio_9_Contar_coincidencias {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*
            Crea un programa que mire dentro de un array, si hay elementos repetidos y los cuente e imprima en pantalla en orden del elemento que más se repite al que menos.
         */

        System.out.println("Contar Coincidencias en un Array");

        System.out.println("cuantos datos deseas ingresar:");
        int a = scanner.nextInt();
        int[] array = new int[a];
        int [] array_2 = new int[array.length];
        int [] array_3 = new int[array.length];
        System.out.println("Ingrese los datos:");
        for (int i = 0; i < a; i++) {
            array[i] = scanner.nextInt();
        }

        
        for(int i = 0; i < array.length; i++) {
            int maxCount = 0;
            for(int j = 0; j<array.length; j++){
                if(array[i] == array[j]){
                    if(i != j){                        
                        maxCount++;
                        array_3[i] = array[j];
                    }
                }
                array_2[i] = maxCount;
            }
        }
        int [] order = new int[array.length];
        for(int i = 0; i < array.length; i++){
                System.out.println(array[i]+" se repite "+array_2[i]);
        }

        
        scanner.close();
    }
}
