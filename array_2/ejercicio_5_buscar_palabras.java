package array_2;
import java.util.Scanner;

public class ejercicio_5_buscar_palabras {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*
            Un programa que permita al usuario ingresar un texto y luego le da la
            opción de buscar una palabra específica, mostrando como resultado
            el rango de posiciones donde se encontró la palabra exacta. (Sin darle
            importancia a mayúsculas o minúsculas)
         */
        String word = "";        
        String phrase = ("En el silencio de la noche, las estrellas susurran secretos ancestrales al viento. El tiempo se desliza entre mis dedos como arena fina, recordándome que cada instante es un regalo efímero. Mis pasos resonan en el eco de la historia, entre ruinas que susurran historias olvidadas. En cada sombra y cada luz, busco respuestas a preguntas sin respuesta. El corazón late al ritmo del universo, buscando su lugar en este vasto lienzo de posibilidades. Entre la oscuridad y la esperanza, encuentro la fuerza para seguir adelante, guiado por el destino incierto que nos une a todos.");

        System.out.println("Texto: " + phrase);
        System.out.println("Buscar Palabras");

        System.out.print("Ingrese la palabra a buscar: ");
        word = scanner.nextLine();

        boolean exists = phrase.toLowerCase().contains(word.toLowerCase());

        if(exists) {
            System.out.println("La palabra '" + word + "' se encuentra en la frase.");
        }else {
            System.out.println("La palabra '" + word + "' no se encuentra en la frase.");
        }

        scanner.close();
    }
}
