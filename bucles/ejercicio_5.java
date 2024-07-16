import java.util.Scanner;

public class ejercicio_5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Escribe un programa en Java que calcule e imprima el factorial de un número dado.

        System.out.println("Ingresa el numero al que deseas hayarle el factorial: ");
        int num = scanner.nextInt();
        int factorial = 1;
        System.out.println("El factorial de !"+num+" es: ");
        for(int i = 1; i < num+1; i++) {
            factorial *=i;
            if(i < num){
                System.out.print(i + " * ");
            }else{
                System.out.println(i+" = "+factorial);
            }
            
        }
        scanner.close();
    }
}
