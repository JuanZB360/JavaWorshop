package trabajo_1_parte_2;
import java.util.Scanner;

public class ejercicio_20{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Escribe un método que cifre y descifre un mensaje utilizando el cifrado César con un desplazamiento dado.

        System.out.println("Cifrado Cesar");

        System.out.println("Ingresa una frase que desees cifrar: ");
        String phrase = scanner.nextLine().toLowerCase();
        System.out.println("Ingresa el desplazamiento que deseas aplicar del 0 al 25:");
        int displacement = scanner.nextInt();

        String characterminus = "abcdefghijklmnñopqrstuvwxyz";

        String encryption = "";

        for(int i = 0; i < phrase.length(); i++){
            for(int j = 0; j < characterminus.length(); j++){
                if(characterminus.charAt(j) == phrase.charAt(i)){
                    if(displacement+j > 25){
                        int otherdisplacement = (displacement+j) - 25;
                        encryption += characterminus.charAt(otherdisplacement);
                    }else{                    
                        encryption += characterminus.charAt(j+displacement);
                    }
                }                
            }
            
        }

        System.out.println("Frase cifrada: "+encryption);
        scanner.close();
    }
}