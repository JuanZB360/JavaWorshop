package trabajo_1;
import java.util.Scanner;

public class ejercicio_13 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Desarrolla un programa que calcule el costo de un viaje en taxi basándose en la distancia del viajen (en kilómetros) y la tarifa base. Puedes añadir una tarifa adicional por kilómetro recorrido. Eln usuario debe ingresar la distancia del viaje.

        System.out.println("Calculadora de Tarifa de Taxi");
        System.out.println("Ingresa el la tarifa por km recorrido");
        float cost = scanner.nextFloat();
        System.out.println("Ingresa los km a recorrer");
        float km = scanner.nextFloat();
        float accounttravel = km * cost;

        System.out.println("El valor de la carrera es de $"+accounttravel);
        
        System.out.println("Deseas sumar un monto extra a la tarifa Si o No:");
        String tarifa = scanner.nextLine();
        if(tarifa == "si" || tarifa == "Si"){
            System.out.println("Ingresa el monto extra");
            float extra = scanner.nextFloat();
            accounttravel += extra;
            System.out.println("El valor total del viaje sera $"+accounttravel);
        }else{
            System.out.println("El valor total del viaje sera $"+accounttravel);
        }

        scanner.close();

    }
}
