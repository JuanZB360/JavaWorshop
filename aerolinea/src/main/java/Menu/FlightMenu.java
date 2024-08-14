package Menu;

import Util.Verification;
import controller.FlightController;
import controller.PlaneController;
import entity.FlightEntity;
import entity.PlaneEntity;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class FlightMenu {
    public static void FlightExcution() throws ClassNotFoundException {
        FlightController controller = new FlightController();
        PlaneController controllerPlane = new PlaneController();
        boolean session = true;
        while (session) {
            //logica para el menu de vuelos;
            int option = Verification.integer("***** Menu *****\n\t1- Crear vuelo.\n\t2- Eliminar vuelo.\n\t3- Editar vuelo.\n\t4- Buscar.\n\t5- Mostrar Todo.\n\t6- Volver al Menu Principal.");
            switch (option) {
                case 1:
                    String destination = Verification.string("Ingresa el destino del vuelo: ");
                    Date date = Verification.date();
                    Time time = Verification.time();
                    int planeId = Verification.integer("Ingresa el Id del avión: ");
                    FlightEntity flight = new FlightEntity(destination,date,time,planeId);
                    flight = controller.CreateFlight(flight);
                    if(flight.getId() != 0){
                        JOptionPane.showMessageDialog(null,"Vuelo creado:\n"+flight);
                    }
                    break;
                case 2:
                    int idDelete = Verification.integer("Ingresa el id del vuelo: ");
                    FlightEntity flightDelete = new FlightEntity(idDelete);
                    ArrayList<FlightEntity> flightSearchDelete = new ArrayList<>();
                    flightSearchDelete = controller.ReadFlight(flightDelete);
                    if(flightSearchDelete.size() > 0) {
                        int confirmDelete = JOptionPane.showConfirmDialog(null, "Deseas Eliminar el vuelo:\n" + flightSearchDelete, "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
                        if (confirmDelete == 0) {
                            controller.DeleteFlight(flightDelete);
                        }
                    }
                    break;
                case 3:
                    int idUpdate = Verification.integer("Ingresa el id del vuelo: ");
                    FlightEntity flightUpdate = new FlightEntity(idUpdate);
                    ArrayList<FlightEntity> flightSearch = new ArrayList<>();
                    flightSearch = controller.ReadFlight(flightUpdate);
                    if (flightSearch.size() > 0) {
                        int confirmUpdate = JOptionPane.showConfirmDialog(null, "Deseas actualizar el vuelo:\n" + flightSearch, "Confirmacion", JOptionPane.OK_CANCEL_OPTION);

                        boolean update = true;
                        while(update) {
                            if (confirmUpdate == 0) {
                                FlightEntity entity = new FlightEntity();
                                int optionUpdate = Verification.integer("*** Actualizar ***\n\t1-Destino.\n\t2- Fecha.\n\t3- Hora.\n\t4- Avion.\n\t5- Avion.");
                                switch (optionUpdate) {
                                    case 1:
                                        String destinationUpdate = Verification.string("Destino del vuelo");
                                        flightSearch.get(0).setDestination(destinationUpdate);
                                        flightUpdate = controller.UpdateFlight(flightSearch.get(0));
                                        if (flightUpdate != null) {
                                            JOptionPane.showMessageDialog(null, "Vuelo actualizado:\n" + flightUpdate);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El Vuelo No Fue Actuializado...");
                                        }
                                        break;
                                    case 2:
                                        Date departureDateUpdate = Verification.date();
                                        flightSearch.get(0).setDepartureDate(departureDateUpdate);
                                        flightUpdate = controller.UpdateFlight(flightSearch.get(0));
                                        if (flightUpdate != null) {
                                            JOptionPane.showMessageDialog(null, "Vuelo actualizado:\n" + flightUpdate);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El Vuelo No Fue Actuializado...");
                                        }
                                        break;
                                    case 3:
                                        Time departureTimeUpdate = Verification.time();
                                        flightSearch.get(0).setDepartureTime(departureTimeUpdate);
                                        flightUpdate = controller.UpdateFlight(flightSearch.get(0));
                                        if (flightUpdate != null) {
                                            JOptionPane.showMessageDialog(null, "Vuelo actualizado:\n" + flightUpdate);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El Vuelo No Fue Actuializado...");
                                        }
                                        break;
                                    case 4:
                                        while (true) {
                                            int planeIdUpdate = Verification.integer("Id del avión");
                                            PlaneEntity checkPlane = new PlaneEntity(planeIdUpdate);
                                            ArrayList<PlaneEntity> checkPlaneResponse = new ArrayList<>();
                                            checkPlaneResponse = controllerPlane.ReadPlane(checkPlane);
                                            if (checkPlaneResponse.size() > 0) {
                                                flightUpdate.setPlaneId(checkPlaneResponse.get(0).getId());
                                                flightUpdate = controller.UpdateFlight(flightSearch.get(0));
                                                if (flightUpdate != null) {
                                                    JOptionPane.showMessageDialog(null, "Vuelo actualizado:\n" + flightUpdate);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "El Vuelo No Fue Actuializado...");
                                                }
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "El Avión No Existe...");
                                            }
                                        }
                                        break;
                                    case 5:
                                        update = false;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion Invalida...");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Cancelado...");
                            }
                        }
                    } else {
                            JOptionPane.showMessageDialog(null, "El Vuelo No Existe...");
                    }
                    break;
                case 4:
                    ArrayList<FlightEntity> flightRead = new ArrayList<>();
                    boolean readflight =true;
                    while(readflight) {
                        int optionRead = Verification.integer("***** Busqueda *****\n\t1- id.\n\t2- destino.\n\t3- fecha.\n\t4- hora.\n\t5- Volver al Menu de Vuelos.");
                        FlightEntity entityRead = new FlightEntity();
                        switch (optionRead) {
                            case 1:
                                int idRead = Verification.integer("Ingresa el id del vuelo: ");
                                entityRead.setId(idRead);
                                flightRead = controller.ReadFlight(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Vuelos encontrados:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron vuelos.");
                                }
                                break;
                            case 2:
                                String destinationRead = Verification.string("Ingresa el destino del vuelo: ");
                                entityRead.setDestination(destinationRead);
                                flightRead = controller.ReadFlight(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Vuelos encontrados:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron vuelos.");
                                }
                                break;
                            case 3:
                                Date dateRead = Verification.date();
                                entityRead.setDepartureDate(dateRead);
                                flightRead = controller.ReadFlight(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Vuelos encontrados:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron vuelos.");
                                }
                                break;
                            case 4:
                                Time timeRead = Verification.time();
                                entityRead.setDepartureTime(timeRead);
                                flightRead = controller.ReadFlight(entityRead);
                                if(flightRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Vuelos encontrados:\n"+flightRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron vuelos.");
                                }
                                break;
                            case 5:
                                readflight = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    }
                    break;
                case 5:
                    ArrayList<FlightEntity> flightlist = new ArrayList<FlightEntity>();
                    flightlist = controller.ReadAllFlight();
                    if(flightlist.size() > 0) {
                        JOptionPane.showMessageDialog(null,"Todos los Vuelos:\n"+flightlist);
                    }else {
                        JOptionPane.showMessageDialog(null,"No hay vuelos.");
                    }
                    break;
                case 6:
                    session = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                    break;
            }
        }
    }
}
