package trabajo_1_parte_2;
import java.util.Scanner;

public class ejercicio_17{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Crea un programa que pida al usuario un carácter e imprima en consola si es una consonante, vocal o carácter especial.

        System.out.println("Identificador de Caracter");
        System.out.print("Ingrese un caracter: ");
        char caracter = scanner.next().charAt(0);
        String vocales = "aeiouAEIOU";
        String consonante = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        String especial = "|°¬!#$%&/()='?¡¿><;,:._-[{}]+´¨*^@";

        for(int i=0; i<vocales.length(); i++){
            if(caracter == vocales.charAt(i)){
                System.out.println("El caracter es una vocal");
                break;
            }
        }
        for(int i=0; i<consonante.length(); i++){
            if(caracter == consonante.charAt(i)){
                System.out.println("El caracter es una consonante");
                break;
            }
        }
        for(int i=0; i<especial.length(); i++){
            if(caracter == especial.charAt(i)){
                System.out.println("El caracter es un carácter especial");
                break;
            }
        }

        scanner.close();

    }
}