package RegistroEmpleados;
import java.util.Scanner;

public class IngresoEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionEmpleados gestionEmpleados = new GestionEmpleados();
        int id = 0;

        System.out.println("*** Gestion de Empleados ***");
        boolean sesion = true;
        while (sesion) {
            System.out.println("Menu:\n\t1- Agregar Empleado\n\t2- Mostrar Empleados\n\t3- Eliminar Empleado\n\t4- Salir");
            System.out.print("Ingrese su opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("*** Agregar Empleado ***");
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Salario: ");
                    float salario = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Tipo de Contrato:\n\t1- Temporal\n\t2- Permanente");
                    int tipoContrato = scanner.nextInt();
                    boolean verificacion = true;
                    while(verificacion) {
                        if (tipoContrato == 1) {
                            EmpleadoTemporal temporal = new EmpleadoTemporal(id, nombre, edad, salario);
                            gestionEmpleados.agragarEmpleado(temporal);
                            verificacion = false;
                        } else if (tipoContrato == 2) {
                            EmpleadoPermanente permanente = new EmpleadoPermanente(id, nombre, edad, salario);
                            gestionEmpleados.agragarEmpleado(permanente);
                            verificacion = false;
                        } else {
                            System.out.println("Ingresa una opcion valida....");
                        }
                    }
                    id += 1;
                    break;
                case 2:
                    System.out.println("*** Mostrar Empleados ***");
                    gestionEmpleados.mostrarEmpleados();
                    break;
                case 3:
                    System.out.println("*** Eliminar empleado ***");
                    System.out.print("Ingresa id del empleado: ");
                    int idEmpleadoEliminar = scanner.nextInt();
                    gestionEmpleados.eliminarEmpleado(idEmpleadoEliminar);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    sesion = false;
                    break;
                default:
                    System.out.println("Ingresa una opcion valida...");
                    break;
            }
        }
    }
}
