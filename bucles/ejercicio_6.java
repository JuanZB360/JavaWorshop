import java.util.Scanner;

public class ejercicio_6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Escribe un programa en Java que calcule e imprima los primeros 50 números de la sucesión de Ulam

        int[] ulam = new int [49];

        ulam[0] = 1;
        ulam[1] = 2;
        int a = 1, b = 2, c = 0, u = 0;

        while (a < 50) {
            for (int i = 0; i < b+1; i++) {
                for(int j = 0; j < b+1; j++) {
                    u = ulam[i]+ulam[j];
                    if(u == ulam[a]+1) {
                        c+=1;
                    }
                }
            }
            if(c==1){
                ulam[b]= u;
            }

            a+=1;
            b+=1;
            c=0;

        }

        for(int i:ulam) {
            System.out.println(i);
        }
        
        scanner.close();
    }
}
