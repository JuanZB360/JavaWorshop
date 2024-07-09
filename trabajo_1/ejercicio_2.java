package trabajo_1;
import java.util.Scanner;

public class ejercicio_2 {
    public static void main(String[] args) {
        //Crea un programa que solicite la edad del usuario y determine si es mayor de edad (18 años o más).El programa debe imprimir un mensaje indicando si el usuario es mayor de edad o no.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Verificador de edad");
        System.out.println("Ingresa tu Nombre");
        String name = scanner.nextLine();
        System.out.println("Ingresa tu Edad");
        int age = scanner.nextInt();

        if (age < 18){
            System.out.println("hola "+name+" no tienes la edad suficiente para ingresar");
        }else if(age >= 18){
            System.out.println("Hola "+name+" tienes la edad suficiente para igresar");
        }
        scanner.close();
    }    
}
