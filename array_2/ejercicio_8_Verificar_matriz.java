package array_2;

import java.util.Scanner;

public class ejercicio_8_Verificar_matriz {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*
            Crea un programa en Java que verifique si una matriz cuadrada es simétrica (igual a su transpuesta, Ejercicio 7).
         */

         System.out.println("Transposicion de una Matriz\n");

         System.out.println("Ingrese tamaño de la matriz");
         System.out.println("Filas:");
         int a = scanner.nextInt();
         System.out.println("Columnas:");
         int b = scanner.nextInt();
 
         int [][] matrix = new int [a][b];
         int [][] transposition = new int [b][a];
 
         //llenar matriz principal
         for(int i = 0; i < a; i++){
             for(int j = 0; j < b; j++){
                 System.out.print("Ingrese el elemento [" + (i+1) + "][" + (j+1) + "]: ");
                 matrix[i][j] = scanner.nextInt();
             }
         }
 
         //imprimir matriz
         System.out.println("\nMatriz Original:\n");
         for(int i = 0; i < a; i++){
             for(int j = 0; j < b; j++){
                 if(j<=b-1){
                     System.out.print(" "+matrix[i][j]+" ");
                 }else{
                     System.out.print(" "+matrix[i][j]+" ");
                 }
             }
             System.out.println("\n");
         }
 
         System.out.println("\n");
         //transposicion de la matriz
         System.out.println("Transposicion:\n");
         for(int i = 0; i < a; i++){
             for(int j = 0; j < b; j++){
                 transposition[j][i] = matrix[i][j];
             }
         }
 
        System.out.println("Transpuesta:\n");
        for(int i = 0; i < b; i++){
         for(int j = 0; j < a; j++){
                 if(j<=b-1){
                     System.out.print(" "+transposition[i][j]+" ");
                 } else{
                     System.out.print(" "+transposition[i][j]+" ");
                 }
             }
             System.out.println("\n");
        }
        int c = 0;
        if(a = b){
            for(int i = 0; i < a; i++){
                for(int j = 0; j < b; j++){
                    if(matrix[i][j]!= transposition[i][j]){
                        System.out.println("La matriz no es simétrica.");
                        return;
                    }else{
                        c+=1;
                    }
                }
            }
            if(c==a*b){
                System.out.println("La matriz es simétrica.");
            }
        }else{
            System.out.println("La matriz no es cuadrada.");
        }

    }
}