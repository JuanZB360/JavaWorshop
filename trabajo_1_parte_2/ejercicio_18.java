package trabajo_1_parte_2;
import java.util.Random;
import java.util.Scanner;

public class ejercicio_18{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Crear un programa que simule el juego de piedra, papel o tijera contra el usuario. Permitir al usuario elegir entre piedra, papel o tijera. Determinar el ganador del juego y mostrar el resultado.

        System.out.println("Juego de Piedra, Papel o Tijera");

        System.out.println("opciones:\n1- Piedra\n2- Papel\n3- Tijera\n\nEscoge:");

        int userchoice = scanner.nextInt();
        int compchoice = random.nextInt(3);

        String user = (userchoice == 1) ? "Piedra": (userchoice == 2) ? "Papel": "Tijera";
        System.out.println("usuario: " + user);
        String comp = (compchoice == 0) ? "Piedra": (userchoice == 1) ? "Papel": "Tijera";
        System.out.println("Computadora: " + comp);

        String Win = (user=="Piedra" && comp == "Tijera" || user == "Tijera" && comp == "Papel" || user
        == "Papel" && comp == "Piedra") ? "Has Ganado el juego" :(user == comp) ? "Has Empatado" : "Has Perdido el Juego";

        System.out.println(Win);
        scanner.close();

    }
}