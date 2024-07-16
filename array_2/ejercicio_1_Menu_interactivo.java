package array_2;
import java.util.Scanner;

public class ejercicio_1_Menu_interactivo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        /*
            Este ejercicio propone la creación de un programa que presente al usuario un menú interactivo para realizar operaciones matemáticas básicas como suma, resta, multiplicación y división.
         */

        System.out.println("Menu Interactivo");

        while(true) {
            System.out.println("Seleccione la operación matemática que deseas realizar \n 1- suma \n 2- resta \n 3- multiplicacion \n 4- division \n 5- Cerrar calculadora");
            System.out.print("\nescoge : ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\nSuma");
                    System.out.print("\nIngresa numero 1: ");
                    double num1 = scanner.nextInt();
                    System.out.print("\nIngresa numero 2: ");
                    double num2 = scanner.nextInt();
                    double result = num1 + num2;
                    System.out.print("\nResultado: ");
                    System.out.println(num1+" + "+num2+" = "+result+"\n");
                    break;
                
                case 2:
                    System.out.print("\nResta");
                    System.out.print("\nIngresa numero 1: ");
                    num1 = scanner.nextInt();
                    System.out.print("\nIngresa numero 2: ");
                    num2 = scanner.nextInt();
                    result = num1 - num2;
                    System.out.print("\nResultado: ");
                    System.out.println(num1+" - "+num2+" = "+result+"\n");
                    break;
                
                case 3:
                    System.out.print("\nMultiplicacion");
                    System.out.print("\nIngresa numero 1: ");
                    num1 = scanner.nextInt();
                    System.out.print("\nIngresa numero 2: ");
                    num2 = scanner.nextInt();
                    result = num1 * num2;
                    System.out.print("\nResultado: ");
                    System.out.println(num1+" * "+num2+" = "+result+"\n");
                    break;
                
                case 4:
                    System.out.print("\nDivision");
                    System.out.print("\nIngresa numero 1: ");
                    num1 = scanner.nextInt();
                    System.out.print("\nIngresa numero 2: ");
                    num2 = scanner.nextInt();
                    result = num1 / num2;
                    System.out.print("\nResultado: ");
                    System.out.println(num1+" / "+num2+" = "+result+"\n");
                    break;
            
                default:
                    break;
            }
            
            if(option == 5) {
                System.out.println("Gracias por usar la calculadora. Adiós!");
                scanner.close();
                break;
            }
        }
    }
}
