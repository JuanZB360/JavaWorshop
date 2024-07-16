package array_1;
import java.util.Scanner;

public class ejercicio_3_sistema_reserva{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        /*Desarrolla un programa para un teatro para gestionar lasreservas de asientos. El teatro tiene 5 filas con 10 asientos cada una. Utiliza un arreglo bidimensional de boolean donde true representa un asiento ocupado y false uno disponible. El sistema debe permitir:

         Reservar y cancelar asientos.
         Mostrar los asientos disponibles.
         Contabilizar el total de asientos ocupados y disponibles.*/

        System.out.println("Sistemas de Reservas:");

        boolean[][] seat = new boolean[5][10];
        

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++){
                seat[i][j] = false;
            }
        }

        while(true){
            System.out.println("Menu:\n1- Realizar reservar\n2- cancelar Reserva\n3- Asientos disponibles\n4- cerrar sesion");

            System.out.print("\nSelecciona una opcion:");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    int a= 0;
                    System.out.println("\nRealizar reservar\n");
                    for(int i = 0; i < 5; i++){
                        for(int j = 0; j < 10; j++){
                            if(j <=8){
                                if(seat[i][j] == false){
                                    System.out.print(" "+seat[i][j] + " ");
                                } else{
                                    System.out.print(" "+seat[i][j]+ "  ");
                                }
                            }else{
                                if(seat[i][j] == false){
                                    System.out.println(" "+seat[i][j]);
                                } else{
                                    System.out.println(" "+seat[i][j]);
                                }
                            }
                        }
                    }

                    for(int i = 0; i < 5; i++){
                        for(int j = 0; j < 10; j++){
                            if(seat[i][j] == true){
                                a+=1;
                            }
                        }
                    }

                    if(a < 50){
                        while(true){
                            System.out.print("\nIngrese fila:");
                            int row = scanner.nextInt();
                            System.out.print("Ingrese columna:");
                            int column = scanner.nextInt();
                            row-=1;
                            column-=1;
                            if(row <= 5 && column <= 10){
                                    if(seat[row][column] == false){
                                        System.out.println("Reserva realizada correctamente.");
                                        seat[row][column] = true;
                                        break;
                                    }else{
                                        scanner.nextLine();
                                        System.out.print("El puesto ya esta ocupado.");
                                        break;
                                    }
                            }else{
                                System.out.println("No existe el asiento solo hay 5 filas y cada fila tiene 10 asiento.");
                            }
                        }
                    }else{
                        System.out.println("Todos los asientos estan ocupados.");
                    }
                    break;
                
                case 2:

                    System.out.println("\nCancelar Reserva:");
                    System.out.println("\ningresa el asieto de tu Reserva:");
                    while(true){
                        System.out.print("fila: ");
                        int row = scanner.nextInt();
                        System.out.print("Columna: ");
                        int column = scanner.nextInt();
                        row-=1;
                        column-=1;

                        if(seat[row][column] == true){
                            System.out.println("La cancelacion de la resevacion fue exitosa.");
                            seat[row][column] = false;
                            break;
                        }else{
                            System.out.print("El asiento no se encueentra reservado quizas ingresaste mal el numero del asiento, deseas intenntarlo de nuevo 'si' o 'no'.");
                            String answer = scanner.nextLine();
                            if(answer == "no"){
                                break;
                            }
                        }
                    }
                    break;

                case 3:
                    int available = 0, busy = 0;
                    System.out.println("\nPuestos disponibles: ");
                    for(int i = 0; i < 5; i++){
                        for(int j = 0; j < 10; j++){
                            if(j < 9 ){
                                if(seat[i][j] == false){
                                    available += 1;
                                    int b = i + 1;
                                    int c = j + 1;
                                    System.out.print(" F"+b+"/C"+c+ " ");
                                }else{
                                    busy += 1;
                                    System.out.print("       ");
                                }
                            }else{
                                int b = i + 1;
                                int c = j + 1;
                                
                                if(seat[i][j] == true) {
                                    busy += 1;
                                    System.out.println("       ");
                                }else {
                                    available += 1;
                                    System.out.println(" F"+b+"/C"+c);
                                }
                            }
                        }
                    }
                    System.out.println("\nTotal de asientos disponibles: " + available);
                    System.out.println("Total de asientos ocupados: " + busy);
                    break;

                default:
                    break;
            }
            if(option == 4){
                System.out.println("Gracias por su visita, hasta pronto.");
                scanner.close();
                break;
            }
            System.out.println("\n");
        }
        
    }
}