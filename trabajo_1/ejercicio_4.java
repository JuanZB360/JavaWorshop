package trabajo_1;
import java.util.Scanner;

public class ejercicio_4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Escribe un programa que calcule el índice de masa corporal (IMC) de una persona. El programa debe pedir al usuario su peso en kilogramos y su altura en metros, calcular el IMC y mostrar un mensaje con el resultado. La fórmula para calcular el IMC es peso / (altura * altura).

        System.out.println("Indece de Masa Corporal");
        System.out.println("Altural: ");
        float height = scanner.nextFloat();
        System.out.println("Peso: ");
        float weight = scanner.nextFloat();

        Double IMC = height / Math.pow(weight, 2);
        System.out.println("Tu IMC es: " + IMC);

        scanner.close();
    }
}
