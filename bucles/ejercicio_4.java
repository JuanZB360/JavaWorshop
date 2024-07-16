import java.util.Scanner;

public class ejercicio_4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Escribe un programa en Java que imprima un patrón de asteriscos en forma de rombo.

        System.out.println("Rombo: ");

        //      *
        //     ***
        //    *****
        //   *******
        //  *********
        // ***********
        //*************
        // ***********
        //  *********
        //   *******
        //    *****
        //     ***
        //      *
        //    
        
        System.out.println("Ingresa un numero impar que sera el ancho del rombo que deseas: ");
        int weight = scanner.nextInt();

        for(int i = 1;i < weight+1;i+=2){
            for(int j = 0; j < (weight-i)/2;j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = weight-2; i > 0; i-=2){
            for(int j = 0; j < (weight-i)/2; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();

    }
}
