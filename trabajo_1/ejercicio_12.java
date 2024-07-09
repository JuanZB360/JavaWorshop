package trabajo_1;
import java.util.Scanner;

public class ejercicio_12 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Implementa un programa que le pida al usuario su mes y día de nacimiento. Luego, basado en esa información, muestra su signo del zodíaco. Utiliza una estructura switch para manejar los meses y if para los días.

        System.out.println("Generador de Horoscopo");

        System.out.println("Ingresa tu mes de nacimiento: ");
        String birthMonth = scanner.nextLine();
        System.out.println("Ingresa tu dia de nacimiento: ");
        int birthDay = scanner.nextInt();

        switch (birthMonth) {
            case "enero":
                if(birthDay <= 19){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Capricornio");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Acuario");
                }
                break;
            case "febrero":
                if(birthDay <= 18){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Acuario");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Piscis");
                }
                break;            
            case "marzo":
                if(birthDay <= 20){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Piscis");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Aries");
                }
                break;
            case "abril":
                if(birthDay <= 19){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Aries");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Tauro");
                }
                break;
            case "mayo":
                if(birthDay <= 20){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Tauro");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Geminis");
                }
                break;
            case "junio":
                if(birthDay <= 20){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Geminis");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Cancer");
                }
                break;
            case "julio":
                if(birthDay <= 22){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Cancer");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Leo");
                }
                break;
            case "agosto":
                if(birthDay <= 22){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Leo");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Virgo");
                }
                break;
            case "septiembre":
                if(birthDay <= 22){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Virgo");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Libra");
                }
                break;
            case "octubre":
                if(birthDay <= 22){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Libra");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Escorpio");
                }
                break;
            case "noviembre":
                if(birthDay <= 21){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Escorpio");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Sagitario");
                }
                break;
            case "diciembre":
                if(birthDay <= 21){
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Sagitario");
                }else{
                    System.out.println("Para los nacidos en "+birthMonth+""+birthDay+" su signo Zodiacal es Capricornio");
                }
                break;
            default:
                break;
        }

        scanner.close();

    }
}
