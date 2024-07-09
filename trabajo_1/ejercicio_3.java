package trabajo_1;
import java.util.Scanner;

public class ejercicio_3 {;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Desarrolla un programa que convierta kilómetros a millas. El programa debe solicitar al usuario que introduzca una distancia en kilómetros y luego debe mostrar la distancia equivalente en millas. Utiliza el hecho de que una milla es igual a 1.60934 kilómetros.

        System.out.println("Conversor de unidades");
        System.out.println("conversor de km a millas y de millas a km");
        System.out.println("Deseas convertir  1- kilometros 2-millas");
        int answer = scanner.nextInt();
        
        if(answer == 1){
            System.out.println("Cuantas millas deseas convertir a kilometros");
            double millas = scanner.nextDouble();
            double km = millas * 1.609;
            System.out.println(millas+" millas serian "+km+" km");
        }else if(answer == 2){
            System.out.println("Cuantas kilometros deseas convertir a millas");
            double km = scanner.nextDouble();
            double millas = km / 1.609;
            System.out.println(km+" km serian "+millas+" km");
        }

        scanner.close();

    }
    
}
