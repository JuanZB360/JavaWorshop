package trabajo_1;
import java.util.Scanner;

public class ejercicio_5 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //Crea un programa que solicite al usuario un número y muestre un mensaje indicando si el número es positivo, negativo o cero. Además, indica si el número es par o impar.

        System.out.println("Clasificador de numeros");
        System.out.println("Ingresa el numero que deseas Evaluar");
        float x = scanner.nextFloat();

        if(x > 0){
            if(x % 2 == 0){
                System.out.println("El numero "+x+" es Positivo y par");
            }else if(x % 2 != 0){
                System.out.println("El numero "+x+" es Positivo e impar");
            }
        }else if(x < 0 ){
            if(x % 2 == 0){
                System.out.println("El numero "+x+" es Negativo y par");
            }else if(x % 2 != 0){
                System.out.println("El numero "+x+" es Negativo e impar");
            }
        }else{
            System.out.println("El numero es cero");
        }

        scanner.close();
    }
}
