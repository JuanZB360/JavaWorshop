package gestionEmpleados;
import java.util.Scanner;
import java.util.ArrayList;

public class gestion {
    public static void main(String[] args) {

        //Instanciar metodo Scanner
        Scanner scanner = new Scanner(System.in);

        // Declara Array para almacenar los empleados
        ArrayList<empleado> empleados = new ArrayList<>();

        while(true){

            System.out.println("\nMenú de gestión de empleados:\n\t1- Crear Empleado.\n\t2- Aumentar Salario\n\t3- mostrar todos los empleados\n\t4- Salir.");

            System.out.print("\tIngresa tu elección:\t");
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");

            switch (option) {
                case 1:

                    while (true) {

                        // instanciacion de empleado
                        empleado crearEmpleado = new empleado();

                        System.out.println("*** Crear Empleado ***");
                        System.out.print("Nombre:\t");
                        String nombre = scanner.nextLine();

                        System.out.print("Puesto:\t");
                        String puesto = scanner.nextLine();

                        System.out.print("Salario: ");
                        float salario = scanner.nextFloat();

                        crearEmpleado.setName(nombre);
                        crearEmpleado.setPosition(puesto);
                        crearEmpleado.setSalary(salario);

                        empleados.add(crearEmpleado);
                        System.out.println(empleados.getLast() + "\n");

                        scanner.nextLine();
                        System.out.print("Desea crear otro empleado? (Si/No)\t");
                        String confirmar = scanner.nextLine();
                        if(confirmar.equalsIgnoreCase("no")){
                            break;
                        }
                        System.out.println("\n");

                    }
                    break;

                case 2:

                    System.out.println("*** Aumentar Salario ***");

                    for(empleado empleado : empleados ) {
                        System.out.println(empleado);
                    }

                    System.out.print("Ingresa el Id deñ empleado:\t");
                    int buscar = scanner.nextInt();

                    for (empleado empleado : empleados) {
                        if(empleado.getId() == buscar) {
                            System.out.print("Ingresa el porcentaje de aumento:\t");
                            float porcentaje = scanner.nextFloat();
                            empleado.increaseSalary(porcentaje);
                            System.out.println("Salario del empleado " + empleado.getName() + " aumentado a: " + empleado.getSalary() + "\n");
                        }
                    }





                    break;

                case 3:

                    System.out.println("*** Lista de empleados ***");

                    for(empleado empleado : empleados ) {
                        System.out.println(empleado);
                    }

                    break;
            }

            if(option == 4){
                System.out.println("Saliendo del programa...");
                break;
            }

        }

    }
}