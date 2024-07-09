package trabajo_1_parte_2;
import java.util.Scanner;

public class ejercicio_16{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Crea un programa que valide si una contraseña es segura o no, que responda con un booleano. (Una contraseña segura debe contener mínimo 8 caracteres con al menos 1 mayúscula, 1 minúscula y 1 carácter espacial)

        System.out.println("Contraseña Segura");

        System.out.println("Ingresa una contraseña. La contraseña debe contener Mayusculas, minusculas y caracteres especiales:");

        String password = scanner.nextLine();
        String minus = "abcdefghijklmnopqrstuvwxyz";
        String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String carac = "!#$%&/()=?¿'¡,.;:<>-_";
        int a = 0, b = 0, c = 0;

        if (password.length() >= 8){
            for(int i=0; i < password.length(); i++){
                for(int j=0; j < minus.length(); j++){
                    if(password.charAt(i) == minus.charAt(j)){
                        a+=1;
                        break;
                    }
                }
                for(int k=0; k < mayus.length(); k++){
                    if(password.charAt(i) == mayus.charAt(k)){
                        b+=1;
                        break;
                    }
                }
                for(int l=0; l < carac.length(); l++){
                    if(password.charAt(i) == carac.charAt(l)){
                        c+=1;
                        break;
                    }
                }
            }
        }

        Boolean segura = (a>=1 && b>=1 && c>=1);

        System.out.println("Contraseña Segura: "+segura);

        scanner.close();

    }
}
