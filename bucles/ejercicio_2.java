import java.util.Scanner;

public class ejercicio_2 {
    public static void main(String[] args) {
        
        //Crea un programa que pida al usuario un número e imprima la tabla de multiplicar del 1 al 10 del número ingresado.
        System.out.println("Tabla de Multiplicacion");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el numero al que deseas conocer su tabla de multiplicar:");
        int nume = scanner.nextInt();

        for(int i = 1; i < 11; i++) {
            System.out.println(nume+" * "+i+" = "+nume*i);
        }

        scanner.close();


    }    
}
