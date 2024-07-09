package trabajo_1_parte_2;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;


public class ejercicio_19{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Crea un programa que solicite la fecha de nacimiento al usuario (año,mes y día). Calcule la edad e imprima su edad y si es mayor de edad o no.

        System.out.println("Ingresa tu fecha de nacimiento:");

        System.out.print("Año: ");
        int year = scanner.nextInt();
        System.out.print("Mes: ");
        int month = scanner.nextInt();
        System.out.print("Día: ");
        int day = scanner.nextInt();

        LocalDate birtime = LocalDate.of(year, month, day);
        LocalDate nowtime = LocalDate.now();

        Period age = Period.between(birtime, nowtime);
        int years = age.getYears();

        String answer = (years >= 18) ? "Tu edad es "+years+" Eres mayor de edad": "Tu edad es "+years+" Eres menor de edad";
        System.out.println(answer);

        scanner.close();


    }
}