package array_2;
import java.util.Scanner;

public class ejercicio_2_Facturacion_tienda {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        /*
            Un cliente realiza una compra en una tienda. El programa proporciona un array de productos y un array de precios. Se requiere pedir al usuario la cantidad de cada producto que desea comprar, para posteriormente imprimir el valor total de la factura.
        */

        System.out.println("Facturacion de una Tienda");

        String [] products = {"producto1", "producto2", "producto3", "producto4"};
        float[] price = {10000, 25000, 33000, 56000};
        int[] quantity = new int[products.length];
        float totalPrice = 0;

        for(int i = 0; i < products.length; i++){
            System.out.println("Cuantos " + products[i] + " desea comprar?");
            quantity[i] = scanner.nextInt();
        }

        System.out.println("\nFactura:");
        for(int i = 0; i < products.length; i++){
            if(quantity[i] > 0){
                System.out.println(products[i] +":  " + (quantity[i] * price[i]));
                totalPrice += price[i]*quantity[i];
            }
        }
        System.out.println("Total: " + totalPrice);
        scanner.close();
    }
}
