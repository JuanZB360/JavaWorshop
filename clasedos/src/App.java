import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //declarar variables primitivas
        //byte
        byte isByte = 100;
        short isShort = 10000;
        long isLong = 100000000;
        int isInt = 1000000000;
        float isFloat = 100.5f;
        double isDouble = 100.5;
        char isChar = 'a';
        boolean isBoolean = true;

        long sum = isByte + isShort + isLong + isInt;
        double sumFLoat = isFloat + isDouble; 

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa un numero");
        int userInput = scanner.nextInt();//de esta manera pido al usuario que inserte un entero
        scanner.nextLine();//este se utilizapara para que el limpiar el bug
        System.out.println("Ingresa un texto");

        scanner.close();

        System.out.println(userInput);

        System.out.println("ingresa tu edad");
        int  age = scanner.nextInt();
        System.out.println("ingresa tu nombre");
        String Name = scanner.nextLine();

        if(age < 18){
            System.out.println("No puedes entrar");
        } else if (age > 18){
            System.out.println("Bienvenido " + Name);
        }

        switch (age){
            case 17:
                System.out.println("hola"+ Name +"no puedes entrar");
            default:
                System.out.println();
        }
        

        scanner.close();



    }
}
