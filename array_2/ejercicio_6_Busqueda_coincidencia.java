package array_2;
import java.util.Scanner;

public class ejercicio_6_Busqueda_coincidencia {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*
            Crea un array de Strings (por ejemplo, nombres) y pide al usuario que ingrese un nombre. Busca ese nombre en el array que imprima si se encuentra la posición y si no un mensaje que no se encuentra.
         */

        System.out.println("Busqueda por Coincidencia en array");

        String[] names = {"Juan", "Pedro", "Maria", "Luis", "Carlos"};
        System.out.println("Array de nombres: " + java.util.Arrays.toString(names));
        System.out.print("Ingrese un nombre: ");
        String name = scanner.nextLine();

        for(int i = 0; i < names.length; i++){
            if(names[i].toLowerCase().contains(name.toLowerCase())){
                System.out.println("El nombre '" + name + "' se encuentra en la posición " + (i+1));
                break;
            }else{
                System.out.println("El nombre '" +name + "' no se encuentra");
            }
        }
    }
}
