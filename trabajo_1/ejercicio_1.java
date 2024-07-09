package trabajo_1;
import java.util.Scanner;

public class ejercicio_1{
    public static void main(String[] args) {
        //Escribe un programa que pida al usuario dos números y luego muestre el resultado de sumar, restar,multiplicar y dividir esos números. Utiliza tipos de datos primitivos para almacenar los números y los resultados.

        System.out.println("Calculadora basica");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa dos numeros enteros a los que desees aplicar las operaciones matematicas basicas.");
        System.out.println("Ingresa el primer numero");
        int num1 = scanner.nextInt();
        System.out.println("Ingresa el segundo numero");
        int num2 = scanner.nextInt();

        int suma = num1 + num2;
        int rest = num1 - num2;
        int mult = num1 * num2; 
        double divi = num1 / num2;

        System.out.println(num1 + " + " + num2 + " = " + suma);
        System.out.println(num1 + " - " + num2 + " = " + rest);
        System.out.println(num1 + " * " + num2 + " = " + mult);
        System.out.println(num1 + " / " + num2 + " = " + divi);

        scanner.close();
    }
}