package trabajo_1;
import java.util.Scanner;

public class ejercicio_6 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //Desarrolla un programa que pida al usuario el número de un mes (1-12) y muestre el número de días de ese mes. Asume que febrero tiene 28 días. Utiliza una estructura switch para resolverlo.

        System.out.println("Calendario de dias del mes");
        System.out.println("Ingresa el numero del mes que desees del 1 al 12");
        int month = scanner.nextInt();

        switch (month){
            case 2:
                System.out.println("El mes "+month+" tiene 28 Dias");
            case 4:
                System.out.println("El mes "+month+" tiene 30 Dias");
            case 6:
                System.out.println("El mes "+month+" tiene 30 Dias");
            case 9:
                System.out.println("El mes "+month+" tiene 30 Dias");
            case 11:
                System.out.println("El mes "+month+" tiene 30 Dias");
            default:
                System.out.println("El mes "+month+" tiene 31 Dias");
        }

        scanner.close();
    }
}
