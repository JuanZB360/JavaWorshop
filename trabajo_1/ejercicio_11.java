package trabajo_1;
import java.util.Scanner;

public class ejercicio_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Crea un programa que solicite al usuario ingresar tres números enteros y luego los muestre ordenados de menor a mayor. Intenta resolverlo primero con if y else, y luego intenta crear una solución usando el operador ternario para práctica adicional.

        System.out.println("ordenando Tres Numeros");
        System.out.println("Ingresa tres numeros enteros:");

        System.out.print("Numero A:");
        int a = scanner.nextInt();

        System.out.print("Numero B:");
        int b = scanner.nextInt();

        System.out.print("Numero C:");
        int c = scanner.nextInt();

        if( a>b && a>c  ){
            if(b>c){
                System.out.println("este es el orden de menos a mayor: C = "+c+", B = "+b+", A = "+a);
            }else{
                System.out.println("este es el orden de menos a mayor: B = "+b+", C= "+c+", A = "+a);
            }
        }else if (b>a && b>c){
            if(a>c){
                System.out.println("este es el orden de menos a mayor: C = "+c+", A = "+a+", B = "+b);
            }else{
                System.out.println("este es el orden de menos a mayor: A = "+a+", C= "+c+", B = "+b);
            }
        }else{
            if(b>a){
                System.out.println("este es el orden de menos a mayor: A = "+a+", B = "+b+", C = "+c);
            }else{
                System.out.println("este es el orden de menos a mayor: B = "+b+", A= "+a+", C = "+c);
            }
        }

        int min = (a<b && a<c ) ? a : (b<a && b<c) ? b : c;
        int max = (a>b && a>c) ? a : (b>a && b>c) ? b : c ; 
        int med = (a>min && a<max) ? a : (b>min && b<max) ? b : c ;

        System.out.println("el valor menor: "+min+" \n el valor medio: "+med+" \n el valor maximo: "+max);

        scanner.close();
    }
}
