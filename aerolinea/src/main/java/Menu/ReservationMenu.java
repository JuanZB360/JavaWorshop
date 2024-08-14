package Menu;

import Util.Verification;
import controller.FlightController;
import controller.PassengerController;
import controller.PlaneController;
import controller.ReservationController;
import entity.FlightEntity;
import entity.PassengerEntity;
import entity.PlaneEntity;
import entity.ReservationEntity;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ReservationMenu {
    public static void ReservationExcution() throws ClassNotFoundException {
        ReservationController controllerReservation = new ReservationController();
        PassengerController controllerPassenger = new PassengerController();
        FlightController controllerFlight = new FlightController();
        PlaneController controllerPlane = new PlaneController();

        boolean session = true;
        while (session) {
            //logica para el menu de vuelos;
            int option = Verification.integer("***** Menu *****\n\t1- Crear Reservacion.\n\t2- Eliminar Reservacion.\n\t3- Editar Reservacion.\n\t4- Buscar.\n\t5- Mostrar Todos.\n\t6- Volver al Menu Principal.");
            switch (option) {
                case 1:
                    ReservationEntity reservation = new ReservationEntity();
                    while(true) {
                        ArrayList<PassengerEntity>  passengerEntity = new ArrayList<PassengerEntity>();
                        int id = Verification.integer("Id del pasajero: ");
                        PassengerEntity passenger = new PassengerEntity (id);
                        passengerEntity = controllerPassenger.ReadPassenger(passenger);
                        if(passengerEntity.size() > 0){
                            reservation.setPassengerId(passenger.getId());
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null,"El pasajero no existe...");
                        }
                    }
                    while(true) {
                        ArrayList<FlightEntity>  flightEntity = new ArrayList<FlightEntity>();
                        int id = Verification.integer("id del vuelo:");
                        FlightEntity flight = new FlightEntity (id);
                        flightEntity = controllerFlight.ReadFlight(flight);
                        if(flightEntity.size() > 0){
                            reservation.setFlightId(flight.getId());
                            while(true) {
                                ArrayList<PlaneEntity> planelist = new ArrayList<>();
                                PlaneEntity planeEntity = new PlaneEntity(flightEntity.get(0).getPlaneId());
                                planelist = controllerPlane.ReadPlane(planeEntity);
                                if(planelist.size() > 0) {
                                    int optionSeat = Verification.integer("El vuelo tiene una capacidad de " + planelist.get(0).getCapacity() + " Ingresa tu asiento: ");
                                    if(optionSeat <= planelist.get(0).getCapacity()) {
                                        ReservationEntity reservationlist = new ReservationEntity();
                                        reservation.setSeat(String.valueOf(optionSeat));
                                        reservationlist = controllerReservation.ReadUnique(reservation);
                                        if(reservationlist != null){
                                            JOptionPane.showMessageDialog(null,"El asiento ya esta ocupado...");
                                        }else{
                                            reservation = controllerReservation.CreateReservation(reservation);
                                            JOptionPane.showMessageDialog(null,"Reservacion creada:\n"+reservation);
                                            break;
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Ingresa un valor de asiento valido...");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null,"El avion no existe...");
                                }
                            }
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null,"El vuelo no existe...");
                        }
                    }
                    break;
                case 2:
                    int idDelete = Verification.integer("Ingresa el id de la reservacion: ");
                    ReservationEntity reservationDelete = new ReservationEntity(idDelete);
                    ArrayList<ReservationEntity> reservationSearchDelete = new ArrayList<>();
                    reservationSearchDelete = controllerReservation.ReadReservation(reservationDelete);
                    if(reservationSearchDelete.size() > 0) {
                        int confirmDelete = JOptionPane.showConfirmDialog(null, "Deseas Eliminar la reservacion:\n" + reservationSearchDelete, "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
                        if (confirmDelete == 0) {
                            controllerReservation.DeleteReservation(reservationDelete);
                        }
                    }
                    break;
                case 3:
                    int idUpdate = Verification.integer("Ingresa el id de la reservacion: ");
                    ReservationEntity reservationUpdate = new ReservationEntity(idUpdate);
                    ArrayList<ReservationEntity> reservationSearch = new ArrayList<>();
                    reservationSearch = controllerReservation.ReadReservation(reservationUpdate);
                    if(reservationSearch.size() > 0){
                        reservationUpdate.setFlightId(reservationSearch.get(0).getFlightId());
                        reservationUpdate.setPassengerId(reservationSearch.get(0).getPassengerId());
                        reservationUpdate.setDepartureDate(reservationSearch.get(0).getDepartureDate());
                        reservationUpdate.setSeat(reservationSearch.get(0).getSeat());

                        int confirmUpdate = JOptionPane.showConfirmDialog(null, "Deseas actualizar la reservacion:\n" + reservationSearch, "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
                        if (confirmUpdate == 0) {
                            boolean confirmMenu = true;
                            while (confirmMenu) {
                                int menuUpdate = Verification.integer("*** Actualizar ***\n\t1- Pasajero.\n\t2- Vuelo.\n\t3- Asiento.\n\t4- Volver.");
                                switch (menuUpdate) {
                                    case 1:
                                        ArrayList<PassengerEntity> passenger = new ArrayList<PassengerEntity>();
                                        int passengerIdUpdate = Verification.integer("Id del pasajero:");
                                        PassengerEntity passengerUpdate = new PassengerEntity(passengerIdUpdate);
                                        passenger = controllerPassenger.ReadPassenger(passengerUpdate);
                                        if (passenger.size() == 1) {
                                            reservationUpdate.setPassengerId(passengerIdUpdate);
                                            reservationUpdate = controllerReservation.UpdateReservation(reservationUpdate);
                                            if (reservationUpdate != null) {
                                                JOptionPane.showMessageDialog(null, "Reservacion actualizada:\n" + reservationUpdate);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "La reservacion no Fue Actuializado...");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El pasajero no existe...");
                                        }
                                        break;
                                    case 2:
                                        ArrayList<FlightEntity> flight = new ArrayList<FlightEntity>();
                                        int flightIdUpdate = Verification.integer("Id del vuelo:");
                                        FlightEntity flightUpdate = new FlightEntity(flightIdUpdate);
                                        flight = controllerFlight.ReadFlight(flightUpdate);
                                        if (flight.size() > 0) {
                                            reservationUpdate.setFlightId(flightIdUpdate);
                                            reservationUpdate = controllerReservation.UpdateReservation(reservationUpdate);
                                            if (reservationUpdate != null) {
                                                JOptionPane.showMessageDialog(null, "Reservacion actualizada:\n" + reservationUpdate);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "La reservacion no Fue Actuializado...");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El vuelo no existe...");
                                        }
                                        break;
                                    case 3:
                                        ArrayList<FlightEntity> flightEntity = new ArrayList<FlightEntity>();
                                        FlightEntity flightsearch = new FlightEntity(reservationUpdate.getFlightId());
                                        flightEntity = controllerFlight.ReadFlight(flightsearch);
                                        if (flightEntity.size() > 0) {
                                            boolean optionUpdate = true;
                                            while (optionUpdate) {
                                                ArrayList<PlaneEntity> planelist = new ArrayList<>();
                                                PlaneEntity planeEntity = new PlaneEntity(flightEntity.get(0).getPlaneId());
                                                planelist = controllerPlane.ReadPlane(planeEntity);
                                                if (planelist.size() > 0) {
                                                    int optionSeat = Verification.integer("El vuelo tiene una capacidad de " + planelist.get(0).getCapacity() + " Ingresa tu asiento: ");
                                                    if (optionSeat <= planelist.get(0).getCapacity()) {
                                                        ReservationEntity reservationlist = new ReservationEntity();
                                                        reservationlist.setSeat(String.valueOf(optionSeat));
                                                        reservationlist.setFlightId(reservationUpdate.getFlightId());
                                                        reservationlist = controllerReservation.ReadUnique(reservationlist);
                                                        if (reservationlist != null) {
                                                            JOptionPane.showMessageDialog(null, "El asiento ya esta ocupado...");
                                                        } else {
                                                            reservationUpdate.setSeat(String.valueOf(optionSeat));
                                                            reservationUpdate = controllerReservation.UpdateReservation(reservationUpdate);
                                                            JOptionPane.showMessageDialog(null, "Reservacion Actualizada:\n" + reservationUpdate);
                                                            optionUpdate = false;
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Ingresa un valor de asiento valido...");
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "El avion no existe...");
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El vuelo no existe...");
                                        }
                                        break;
                                    case 4:
                                        confirmMenu = false;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion invalida...");
                                        break;
                                }
                            }
                        }

                    }else{
                        JOptionPane.showMessageDialog(null,"La reservacion no existe...");
                    }

                    break;
                case 4:
                    ArrayList<ReservationEntity> reservationRead = new ArrayList<>();
                    boolean readReservation =true;
                    while(readReservation) {
                        int optionRead = Verification.integer("***** Busqueda *****\n\t1- id.\n\t2- Pasajero.\n\t3- Vuelo.\n\t4- Fecha.\n\t5- Asiento\n\t6- Volver al Menu de Reservas.");
                        ReservationEntity entityRead = new ReservationEntity();
                        switch (optionRead) {
                            case 1:
                                int idRead = Verification.integer("Ingresa el id de la reservacion: ");
                                entityRead.setId(idRead);
                                reservationRead = controllerReservation.ReadReservation(entityRead);
                                if(reservationRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Reservacion encontrada:\n"+ reservationRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontro reservacion.");
                                }
                                break;
                            case 2:
                                int passengerRead = Verification.integer("Ingresa el id del pasajero que realizo la reservacion: ");
                                entityRead.setPassengerId(passengerRead);
                                reservationRead = controllerReservation.ReadReservation(entityRead);
                                if(reservationRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Reservaciones encontradas:\n"+ reservationRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron reservaciones.");
                                }
                                break;
                            case 3:
                                int flightRead = Verification.integer("Ingresa el id del vuelo de la reservacion: ");
                                entityRead.setFlightId(flightRead);
                                reservationRead = controllerReservation.ReadReservation(entityRead);
                                if(reservationRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Vuelos encontrados:\n"+reservationRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron vuelos.");
                                }
                                break;
                            case 4:
                                Date dateRead = Verification.date();
                                entityRead.setDepartureDate(dateRead);
                                reservationRead = controllerReservation.ReadReservation(entityRead);
                                if(reservationRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"reservaciones encontrades:\n"+reservationRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron reservaciones.");
                                }
                                break;
                            case 5:
                                String seatRead = Verification.string("Ingresa ");
                                entityRead.setSeat(seatRead);
                                reservationRead = controllerReservation.ReadReservation(entityRead);
                                if(reservationRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"reservaciones encontradas:\n" + reservationRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron reservaciones.");
                                }
                                break;
                            case 6:
                                readReservation = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    }
                    break;
                case 5:
                    ArrayList<ReservationEntity> reservationlist = new ArrayList<ReservationEntity>();
                    reservationlist = controllerReservation.ReadAllReservations();
                    if(reservationlist.size() > 0) {
                        JOptionPane.showMessageDialog(null,"Todas las Reservaciones:\n"+ reservationlist);
                    }else {
                        JOptionPane.showMessageDialog(null,"No hay Reservaciones.");
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
