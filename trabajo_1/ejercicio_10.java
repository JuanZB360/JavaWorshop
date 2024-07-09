package trabajo_1;
import java.util.Scanner;

public class ejercicio_10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Desarrolla un programa que calcule cuánto dejar de propina en un restaurante. El usuario debeingresar el total de la cuenta y el porcentaje de propina que desea dejar. El programa debe mostrarcuánto dinero en propina debe dejar.

        System.out.println("Calculadora de propina");

        System.out.println("Ingresa el valor total de la cuenta:");
        float account = scanner.nextFloat();

        System.out.println("Ingresa el porcentaje de propina que deseas dejar:");
        float tip = scanner.nextFloat();

        float totalTip = (account * tip)/100 ;

        System.out.println("El "+tip+"% de la cuenta de $"+account+" es de $"+totalTip);

        scanner.close();
        
    }
}
