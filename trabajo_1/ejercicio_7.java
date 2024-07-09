package trabajo_1;
import java.util.Scanner;

public class ejercicio_7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Implementa un programa que muestre un menú con opciones para realizar diferentes operaciones matemáticas (por ejemplo, sumar, restar, multiplicar, dividir). El usuario debe poder seleccionar una opción ingresando un número, y luego el programa debe pedir los números necesarios para realizar la operación elegida y mostrar el resultado. Utiliza una estructura switch para manejar las opciones del menú.

        System.out.println("menu Interactivo");

        System.out.println("Seleccione la operación matematica que deseas relaizar \n 1- suma \n 2- resta \n 3- multiplicacion \n 4- division");

        int opction = scanner.nextInt();
        System.out.println("Ingresa Primer Numero: ");
        int nume1 = scanner.nextInt();
        System.out.println("Ingresa Segundo Numero:  ");
        int nume2 = scanner.nextInt();

        switch (opction){
            case 1:
                int sumar = nume1 + nume2;
                System.out.println(nume1+" + "+nume2+" = "+sumar);
            case 2:
                int restar = nume1 + nume2;
                System.out.println(nume1+" - "+nume2+" = "+restar);
            case 3:
                int multiplicar = nume1 + nume2;
                System.out.println(nume1+" * "+nume2+" = "+multiplicar);
            case 4:
                double dividir = nume1 / nume2;
                System.out.println(nume1+" / "+nume2+" = "+dividir);
        }

        scanner.close();
    }
}
