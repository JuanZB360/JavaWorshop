package CuentaBancaria;
import java.util.Scanner;
import java.util.ArrayList;


public class MovimientoBancario {
    public static void main(String[] args) {
        // Crear Array
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        // Instanciar metodo Scanner
        Scanner scanner = new Scanner(System.in);

        // Inicio del programa
        boolean aplicacion = true;

        while (aplicacion) {
            System.out.println("*** Cuenta Bancaria ***");
            System.out.println("MENU:\n\t1- Crear Cuenta.\n\t2- Iniciar Secion\n\t3- Cerrar Aplicacion");
            String option = scanner.nextLine();
            switch (option) {
                case "1":

                    // Crear objeto de tipo cuentaBancaria
                    CuentaBancaria cuentaBancaria = new CuentaBancaria();

                    System.out.print("Nombre del Titular: ");
                    String nombreTitular = scanner.nextLine();
                    cuentaBancaria.setTitular(nombreTitular);
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    cuentaBancaria.setContrasena(contrasena);
                    cuentas.add(cuentaBancaria);
                    for (CuentaBancaria cuenta : cuentas) {
                        System.out.println(cuenta);
                    }

                    break;

                case "2":

                    System.out.print("Nombre del Titular: ");
                    String ingresoNombreTitular = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String ingresoContrasena = scanner.nextLine();

                    for(CuentaBancaria cuentasBancarisas: cuentas){
                        if(cuentasBancarisas.getTitular().equals(ingresoNombreTitular) && cuentasBancarisas.berificar(ingresoContrasena)){
                            boolean inicioSesion = true;
                            System.out.println("Bienvenido " + cuentasBancarisas.getTitular());
                            while(inicioSesion){
                                System.out.println("Menu:\n\t1- Depositar.\n\t2- Retirar.\n\t3- Mostrar Balance\n\t4- Ver Saldo\n\t5- Cerrar sesion.");
                                option = scanner.nextLine();
                                switch (option){
                                    case "1":

                                        System.out.println("*** Depositar ***");
                                        System.out.print("Monto a depositar: ");
                                        float montoDeposito = scanner.nextFloat();
                                        cuentasBancarisas.DepositoDinero(montoDeposito);
                                        scanner.nextLine();

                                        break;
                                    case "2":

                                        System.out.println("*** Retirar ***");
                                        System.out.print("Monto a Retirar: ");
                                        float montoRetiro = scanner.nextFloat();
                                        cuentasBancarisas.RetirarDinero(montoRetiro);
                                        scanner.nextLine();

                                        break;

                                    case "3":
                                        cuentasBancarisas.Balance();
                                        break;

                                    case "4":
                                        System.out.println("Saldo Actual: ");
                                        cuentasBancarisas.verSaldo();
                                        break;
                                    case "5":
                                        inicioSesion = false;
                                        break;

                                    default:
                                        System.out.println("Ingresa una opcion valida...");
                                        break;
                                }
                            }
                        }
                    }

                    break;

                case "3":
                    scanner.close();
                    aplicacion = false;
                    break;

                default:
                    System.out.println("Ingresa una opcion valida...");
                    break;

            }

        }


    }
}
