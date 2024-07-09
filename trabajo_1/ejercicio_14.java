package trabajo_1;
import java.util.Scanner;

public class ejercicio_14 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Crea un programa que convierta temperaturas entre grados Celsius y Fahrenheit. El usuario debe poder elegir si quiere convertir de Celsius a Fahrenheit o viceversa, y luego ingresar la temperatura. Utiliza la fórmula C = (F - 32) * 5/9 para Fahrenheit a Celsius y F = C * 9/5 + 32 para Celsius a Fahrenheit.
         
        System.out.println("Convertidor de Temperatura");
        System.out.println("Desea ingresar grados:\n1- Celsius\n2- Fahrenheit ");
        int grados = scanner.nextInt();
        System.out.println("Ingresa Temperatura: ");
        float temp = scanner.nextFloat();
        
        switch (grados) {
            case 1:
                float conver = temp * 9/5 + 32;
                System.out.println("La temperatura en Fahrenheit es: "+conver);
            case 2:
                float conve = (temp - 32) * 5/9;
                System.out.println("La temperatura en Fahrenheit es: "+conve);
        }

        scanner.close();
    }
}
