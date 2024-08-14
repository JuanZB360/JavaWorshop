import Menu.FlightMenu;
import Menu.PassengerMenu;
import Menu.PlaneMenu;
import Menu.ReservationMenu;
import Util.Verification;
import controller.FlightController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean session = true;
        while(session){
            int option = Verification.integer("***** Menu *****\n\t1- avion\n\t2- vuelo\n\t3- pasajero\n\t4- reservacion\n\t5- salir");
            switch(option){
                case 1:
                    PlaneMenu.PlaneExcution();
                    break;
                case 2:
                    FlightMenu.FlightExcution();
                    break;
                case 3:
                    PassengerMenu.PassengerExcution();
                    break;
                case 4:
                    ReservationMenu.ReservationExcution();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null,"Cerrando session...");
                    session = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion invalida...");
            }
        }
    }
}
