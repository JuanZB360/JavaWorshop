package trabajo_1;
import java.util.Scanner;

public class ejercicio_9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        //Escribe un programa que le pida al usuario que ingrese un año y determine si es un año bisiesto o no. Recuerda que un año es bisiesto si es divisible entre 4, excepto aquellos que son divisibles entre 100, a menos que también sean divisibles entre 400.

        System.out.println("Calculadora de Año bisiesto");

        System.out.println("Ingresa un año: ");
        int year = scanner.nextInt();
        if(year % 4 == 0 && year % 100 != 0  || year % 100 == 0 && year % 400 == 0){
            System.out.println("El año "+year+" es ");
        }

        scanner.close();
    }
}
