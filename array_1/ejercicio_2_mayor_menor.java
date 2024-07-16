package array_1;
import java.util.Scanner;

public class ejercicio_2_mayor_menor {
    public static void main(String[] args){

        //Utiliza un array de int para almacenar 5 números enteros ingresados por el usuario (puedes usar la clase Scanner para la entrada de datos). El programa debe encontrar y mostrar el número mayor y el menor de la lista.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Buscador de Numero Mayor y Menor:");
        System.out.println("Ingresa 5 Numeros y el programa te mostrara cual es el mayor y cual es el menor de los numeros que ingreses:");
        int[] number = new int[5];
        int biggernum = 0, minornum = 0;

        for(int i = 0; i < 5; i++){
            System.out.print("Ingresa el numero " + (i+1) + ": ");
            number[i] = scanner.nextInt();
            scanner.nextLine();
            if(number[i] > biggernum){
                biggernum = number[i];
                minornum = number[i];
            }
        }
        for(int i = 0; i < number.length; i++){
            if(number[i] < minornum){
                minornum = number[i];
            }
        }
        System.out.println("\nEl numero mayor es: " + biggernum);
        System.out.println("El numero menor es: " + minornum);

        scanner.close();
    }
}
