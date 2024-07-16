
import java.util.Scanner;

public class ejercicio_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Crea un programa e imprima los primeros “n” números primos.
        System.out.println("Numeros Primos: ");
        System.out.println("inhgresa la cantidad de primos que desas conocer:");
        int num = scanner.nextInt();

        int count = 1;
        int primo = 2;
        
            
        while(count < num+1){
            int a = 0;
            for(int i = 1; i < primo+1; i++) {
                if(primo % i == 0){
                    a+=1;
                }
            }
            if(a < 3){
                System.out.println(primo);
                count+=1;
            }
            primo+=1;
        }

        scanner.close();

    }
}
