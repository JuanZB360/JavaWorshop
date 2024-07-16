import java.util.Scanner;

public class ejercicio_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Crea un programa e imprima los primeros “n” números de Fibonacci.

        System.out.println("Cuantos numeros de fibonacci deseas que se impriman en pantalla:");
        int num = scanner.nextInt();
        int[] fibonacci = new int[num];
        int i = 2;
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        while(i < num) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            i+=1;
        }

        for(int a: fibonacci){
            System.out.println(a);
        }

        scanner.close();

    }    
}
