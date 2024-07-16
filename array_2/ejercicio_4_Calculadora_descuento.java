package array_2;
import java.util.Scanner;

public class ejercicio_4_Calculadora_descuento {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*
            Crea un programa que calcule los descuentos por compras(Ejercicio 2) en una tienda, donde se aplica un porcentaje de descuento en función del monto total de la compra, con rangos de precios personalizados.

        ________________________________________________
        | Rango de compra | Porcentaje de descuento     |
        |-----------------------------------------------|
        |-----------------------------------------------|
        | Mayor o igual a $1000  |          25%         |
        | Mayor o igual a $500   |          20%         |
        | Mayor o igual a $300   |          15%         |
        | Mayor o igual a $200   |          10%         |
        | Menor a $200           |No se aplica descuento|
        |_______________________________________________|
         */

        System.out.println("Facturacion de una Tienda");

        String [] products = {"producto1", "producto2", "producto3", "producto4"};
        double[] price = {10000, 25000, 33000, 56000};
        int[] quantity = new int[products.length];
        double totalPrice = 0;

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
        double descuento = 0;
        if(totalPrice >= 150000){//25%
            System.out.println("Descuento del 25%");
            descuento = totalPrice - (totalPrice * 0.25);
            System.out.println("Total: " + descuento);
        }else if(totalPrice >= 100000){//20%
            System.out.println("Descuento del 20%");
            descuento = totalPrice - (totalPrice * 0.20);
            System.out.println("Total: " + descuento);
        }else if(totalPrice >= 90000){//15%
            System.out.println("Descuento del 15%");
            descuento = totalPrice - (totalPrice * 0.15);
            System.out.println("Total: " + descuento);
        }else if(totalPrice >= 50000){//10%
            System.out.println("Descuento del 10%");
            descuento = totalPrice - (totalPrice * 0.10);
            System.out.println("Total: " + descuento);
        }else{//0%
            System.out.println("Total: " + descuento);
            System.out.println("No se aplica descuento");
            System.out.println("Total: " + totalPrice);
        }

        scanner.close();




    }
}
