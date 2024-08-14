package Menu;

import Util.Verification;
import controller.PassengerController;
import entity.FlightEntity;
import entity.PassengerEntity;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class PassengerMenu {
    public static void PassengerExcution() throws ClassNotFoundException {
        PassengerController controller = new PassengerController();
        boolean session = true;
        while (session) {
            //logica para el menu de vuelos;
            int option = Verification.integer("***** Menu *****\n\t1- Crear Pasajero.\n\t2- Eliminar Pasajero.\n\t3- Editar Pasajero.\n\t4- Buscar.\n\t5- Mostrar Todo.\n\t6- Volver al Menu Principal.");
            switch (option) {
                case 1:
                    String nameCreate = Verification.string("Nombre: ");
                    String lastNameCreate = Verification.string("Apellido: ");
                    String documentCreate = Verification.string("Documento: ");
                    PassengerEntity passengerCreate = new PassengerEntity(nameCreate,lastNameCreate,documentCreate);
                    passengerCreate = controller.CreatePassenger(passengerCreate);
                    if(passengerCreate.getId() != 0){
                        JOptionPane.showMessageDialog(null,"pasajero creado:\n"+passengerCreate);
                    }
                    break;
                case 2:
                    int idDelete = Verification.integer("Ingresa el id del pasajero: ");
                    PassengerEntity passengerDelete = new PassengerEntity(idDelete);
                    ArrayList<PassengerEntity> passengerSearchDelete = new ArrayList<>();
                    passengerSearchDelete = controller.ReadPassenger(passengerDelete);
                    if(passengerSearchDelete.size() > 0) {
                        int confirmDelete = JOptionPane.showConfirmDialog(null, "Deseas Eliminar el pasajero:\n" + passengerSearchDelete, "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
                        if (confirmDelete == 0) {
                            controller.DeletePassenger(passengerDelete);
                        }
                    }
                    break;
                case 3:
                    int idUpdate = Verification.integer("Ingresa el id del pasajero: ");
                    PassengerEntity passengerUpdate = new PassengerEntity(idUpdate);
                    ArrayList<PassengerEntity> passengerSearch = new ArrayList<>();
                    passengerSearch = controller.ReadPassenger(passengerUpdate);
                    if(passengerSearch.size() > 0){
                        int confirmUpdate = JOptionPane.showConfirmDialog(null,"Deseas actualizar el pasajero:\n"+passengerSearch,"Confirmacion", JOptionPane.OK_CANCEL_OPTION);
                        if(confirmUpdate == 0){
                            boolean update = true;
                            while(update) {
                                int Update = Verification.integer("*** Actualizar ***\n\t1- Nombre y Apellido.\n\t2- Documento.\n\t3- Volver.");
                                switch (Update) {
                                    case 1:
                                        String nameUpdate = Verification.string("Nombre:");
                                        String lastNameUpdate = Verification.string("Apellido:");
                                        passengerSearch.get(0).setName(nameUpdate);
                                        passengerSearch.get(0).setLastName(lastNameUpdate);
                                        passengerUpdate = controller.UpdatePassenger(passengerSearch.get(0));
                                        if (passengerUpdate != null) {
                                            JOptionPane.showMessageDialog(null, "Pasajero actualizado:\n" + passengerUpdate);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El pasajero No Fue Actuializado...");
                                        }
                                        break;
                                    case 2:
                                        String documentIdUpdate = Verification.string("Documento:");
                                        passengerSearch.get(0).setDocumentId(documentIdUpdate);
                                        passengerUpdate = controller.UpdatePassenger(passengerSearch.get(0));
                                        if (passengerUpdate != null) {
                                            JOptionPane.showMessageDialog(null, "Pasajero actualizado:\n" + passengerUpdate);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El pasajero No Fue Actuializado...");
                                        }
                                        break;
                                    case 3:
                                        update = false;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null,"Opcion Invalida.");
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    ArrayList<PassengerEntity> flightRead = new ArrayList<>();
                    boolean readPassenger =true;
                    while(readPassenger) {
                        int optionRead = Verification.integer("***** Busqueda *****\n\t1- id.\n\t2- Nombre.\n\t3- Apellido.\n\t4- Documento.\n\t5- Volver al Menu de Vuelos.");
                        PassengerEntity entityRead = new PassengerEntity();
                        switch (optionRead) {
                            case 1:
                                int idRead = Verification.integer("Ingresa el id del pasajero: ");
                                entityRead.setId(idRead);
                                flightRead = controller.ReadPassenger(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"pasajero encontrado:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontro al pasajero.");
                                }
                                break;
                            case 2:
                                String NameRead = Verification.string("Ingresa el Nombre del Pasajero: ");
                                entityRead.setName(NameRead);
                                flightRead = controller.ReadPassenger(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Pasajeros encontrados:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron pasajeros.");
                                }
                                break;
                            case 3:
                                String lastNameRead = Verification.string("Ingresa Apellidos del pasajero");
                                entityRead.setLastName(lastNameRead);
                                flightRead = controller.ReadPassenger(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"pasajeros encontrados:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron pasajeros.");
                                }
                                break;
                            case 4:
                                String documentIdRead = Verification.string("Ingresa el Documento del pasajero:");
                                entityRead.setDocumentId(documentIdRead);
                                flightRead = controller.ReadPassenger(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Pasajeros encontrados:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron pasajerosos.");
                                }
                                break;
                            case 5:
                                readPassenger = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    }
                    break;
                case 5:
                    ArrayList<PassengerEntity> passengerlist = new ArrayList<PassengerEntity>();
                    passengerlist = controller.ReadAllPassenger();
                    if(passengerlist.size() > 0) {
                        JOptionPane.showMessageDialog(null,"Todos los Pasajeros:\n"+ passengerlist);
                    }else {
                        JOptionPane.showMessageDialog(null,"No hay Pasajeros.");
                    }
                    break;
                case 6:
                    session = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
