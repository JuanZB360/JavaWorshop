import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Taller ZB");

        System.out.print("Ingresa el numero de trabajadores: ");
        int maxEmployees = scanner.nextInt();//cantidad de empleados
        String [] employees = new String[maxEmployees];
        String[][][] works = new String [maxEmployees][2][4];//lista de empleados y trabajos acargo

        for(int i=0; i < works.length; i++){
            System.out.print("Ingresa el nombre del trabajador : ");
            employees[i] = scanner.nextLine();
            scanner.nextLine();
            for(int j = 0; j < works[i].length; j++){
                if(j == 0){
                    System.out.print("ingresara una Moto si o no: ");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("no")){
                        continue;
                    }
                }
                scanner.nextLine();
                if(j == 1){
                    System.out.print("ingresara una Carro si o no: ");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("no")){
                        continue;
                    }
                }

                System.out.print("Marca: ");
                works[i][j][0] = scanner.nextLine();
            
                System.out.print("Modelo: ");
                works[i][j][1] = scanner.nextLine();
            
                System.out.print("Año: ");
                works[i][j][2] = scanner.nextLine();
            
                System.out.print("Estado del vehiculo:(1- pendiente  2- En espera  3- Reparado ):  ");
                int answer = scanner.nextInt();
                if(answer == 1){
                    works[i][j][3] = "Pendiente";
                }
                if(answer == 2){
                    works[i][j][3] = "En espera";
                }
                if(answer == 3){
                    works[i][j][3] = "Reparado";
                }
            }
        }        


        while(true){
            System.out.println("Menu:\n1- Mostrar Vehiculos\n2- Cantidad de Vehiculos por Estados\n3-Buscar Vehiculo\n4- Actualizar estado de un Vehiculo\n5- Salir");
            int opction = scanner.nextInt();

            switch (opction) {
                
                case 1:
                    
                    System.out.println("Agenda de Trabajo:");
                    System.out.println("| tipo    |  Marca        |  Modelo       |  Año       |  Estado            |");
                    System.out.println("|---------|---------------|---------------|------------|--------------------|");
                    for(int i = 0; i < works.length; i++){
                        for(int j = 0; j < works[i].length; j++){
                            for(int k = 0; k < works[i][j].length; k++){
                                if(works[i][j][k] == null){
                                    continue;
                                }
                                if(j==0 && k==0){
                                    System.out.print("| Moto    |");
                                }else if(j==1 && k==0){
                                    System.out.print("| Carro   |");
                                }
                                System.out.print("  "+works[i][j][k]);
            
                                if(k==0 || k==1){
                                    String word = works[i][j][k];
                                    int space = 2+word.length();
                                    for(int l = 0; l < 15-space; l++){
                                        System.out.print(" ");
                                    }
                                }
                                if(k==2){
                                    String word = works[i][j][k];
                                    int space = 2+word.length();
                                    for(int l = 0; l < 12-space; l++){
                                        System.out.print(" ");
                                    }
                                }
                                if(k==3){
                                    String word = works[i][j][k];
                                    int space = 2+word.length();
                                    for(int l = 0; l < 20-space; l++){
                                        System.out.print(" ");
                                    }
                                }
                                System.out.print("|");
                            }
                            System.out.println("\n");
                        }
                    } 
                    break;

                case 2:
                    
                    int pending = 0;
                    int wait = 0;
                    int repair= 0;
            
                    for(int i = 0; i < works.length; i++){
                        for(int j = 0; j < works[i].length; j++){
                            for(int k = 0; k < works[i][j].length; k++){
                                if(works[i][j][3].toLowerCase() == "pendiente"){
                                    pending+=1;
                                }
                                if(works[i][j][3].toLowerCase() == "En espera"){
                                    wait+=1;
                                }
                                if(works[i][j][3].toLowerCase() == "Reparado"){
                                    repair+=1;
                                }
                            }
                        }
                    }
                    System.out.println("La cantidad de vehiculos pendientes: "+pending);
                    System.out.println("La cantidad de vehiculos en espera: "+wait);
                    System.out.println("La cantidad de vehiculos reparados: "+repair);
                    break;
                
                case 3:

                    String searchmark;
                    String searchmodel;
                    System.out.print("Ingresa la marca del vehiculo para buscar: ");
                    searchmark = scanner.nextLine();
                    System.out.print("Ingresa el modelo del vehiculo para buscar: ");
                    searchmodel = scanner.nextLine();
                    for(int i = 0; i < works.length; i++){
                        for(int j = 0; j < works[i].length; j++){
                            if(works[i][j][0].toLowerCase() == searchmark && works[i][j][1].toLowerCase() == searchmodel){
                                System.out.print("|  "+works[i][j][0]+"  |");
                                System.out.print("  "+works[i][j][1]+"  |");
                                System.out.print("  "+works[i][j][2]+"  |");
                                System.out.println("  "+works[i][j][3]+"  |");
                            }                
                        }
                    }
                    break;

                case 4:

                    String person;
                    System.out.print("Ingresa la marca del vehiculo para buscar: ");
                    searchmark = scanner.nextLine();
                    System.out.print("Ingresa el modelo del vehiculo para buscar: ");
                    searchmodel = scanner.nextLine();
                    System.out.println("Ingresa el nombre del trabajador acargo");
                    person = scanner.nextLine();
                    for(int i = 0; i < works.length; i++){
                        for(int j = 0; j < works[i].length; j++){
                            if(employees[i].toLowerCase() == person){
                                if(works[i][j][0].toLowerCase() == searchmark && works[i][j][1].toLowerCase() == searchmodel){
                                    works[i][j][3] = scanner.nextLine();
                                } 
                            }               
                        }
                    }
                    break;
            
                default:
                    break;
            }
            if(opction == 5){
                break;
            }
        }
        scanner.close();
    }
}
