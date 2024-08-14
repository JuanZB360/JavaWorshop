package Menu;

import Util.Verification;
import controller.PlaneController;
import entity.FlightEntity;
import entity.PassengerEntity;
import entity.PlaneEntity;

import javax.swing.*;
import java.util.ArrayList;

public class PlaneMenu {
    public static void PlaneExcution() throws ClassNotFoundException {
        PlaneController controller = new PlaneController();
        boolean session = true;
        while (session) {
            //logica para el menu de vuelos;
            int option = Verification.integer("***** Menu *****\n\t1- Crear Avion.\n\t2- Eliminar Avion.\n\t3- Editar Avion.\n\t4- Buscar.\n\t5- Mostrar todos.\n\t6- Volver al Menu Principal.");
            switch (option) {
                case 1:
                    String modelCreate = Verification.string("Model: ");
                    int capacityCreate = Verification.integer("capacidad: ");
                    PlaneEntity planeCreate = new PlaneEntity(modelCreate,capacityCreate);
                    planeCreate = controller.CreatePlane(planeCreate);
                    if(planeCreate.getId() != 0){
                        JOptionPane.showMessageDialog(null,"Avion creado:\n"+planeCreate);
                    }
                    break;
                case 2:
                    int idDelete = Verification.integer("Ingresa el id del avion: ");
                    PlaneEntity planeDelete = new PlaneEntity(idDelete);
                    ArrayList<PlaneEntity> planeSearchDelete = new ArrayList<>();
                    planeSearchDelete = controller.ReadPlane(planeDelete);
                    if(planeSearchDelete.size() > 0) {
                        int confirmDelete = JOptionPane.showConfirmDialog(null, "Deseas Eliminar el avion:\n" + planeSearchDelete, "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
                        if (confirmDelete == 0) {
                            controller.DeletePlane(planeDelete);
                        }else{
                            JOptionPane.showMessageDialog(null, "Cancelado...");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No se Encontro el avion que buscabas.");
                    }
                    break;
                case 3:
                    int idUpdate = Verification.integer("Ingresa el id del avion: ");
                    PlaneEntity planeUpdate = new PlaneEntity(idUpdate);
                    ArrayList<PlaneEntity> planeSearch = new ArrayList<>();
                    planeSearch = controller.ReadPlane(planeUpdate);
                    if(planeSearch.size() > 0){
                        int confirmUpdate = JOptionPane.showConfirmDialog(null,"Deseas actualizar el avion:\n"+planeSearch,"Confirmacion", JOptionPane.OK_CANCEL_OPTION);
                        if(confirmUpdate == 0){
                            boolean update = true;
                            while(update) {
                                int optionUpdate = Verification.integer("***** Actualizar *****\n\t1- Modelo.\n\t2- Capacidad.\n\t3- Volver.");
                                switch(optionUpdate) {
                                    case 1:
                                        String modelUpdate = Verification.string("Modelo:");
                                        planeSearch.get(0).setModel(modelUpdate);
                                        planeUpdate = controller.UpdatePlane(planeSearch.get(0));
                                        if (planeUpdate != null) {
                                            JOptionPane.showMessageDialog(null, "Avion actualizado:\n" + planeUpdate);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El avion No Fue Actuializado...");
                                        }
                                        break;
                                    case 2:
                                        int capacityUpdate = Verification.integer("Capacidad:");
                                        planeSearch.get(0).setCapacity(capacityUpdate);
                                        planeUpdate = controller.UpdatePlane(planeSearch.get(0));
                                        if (planeUpdate != null) {
                                            JOptionPane.showMessageDialog(null, "Avion actualizado:\n" + planeUpdate);
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El avion No Fue Actuializado...");
                                        }
                                        break;
                                    case 3:
                                        update = false;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion Invalida...");
                                        break;
                                }
                            }
                        }

                    }
                    break;
                case 4:
                    ArrayList<PlaneEntity> planeRead = new ArrayList<>();
                    boolean readPlane =true;
                    while(readPlane) {
                        int optionRead = Verification.integer("***** Busqueda *****\n\t1- id.\n\t2- Modelo.\n\t3- Capacidad.\n\t4- Volver al Menu de Vuelos.");
                        PlaneEntity entityRead = new PlaneEntity();
                        switch (optionRead) {
                            case 1:
                                int idRead = Verification.integer("Ingresa el id del avion: ");
                                entityRead.setId(idRead);
                                planeRead = controller.ReadPlane(entityRead);
                                if(planeRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"avion encontrado:\n"+planeRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontro al avion.");
                                }
                                break;
                            case 2:
                                String modelRead = Verification.string("Ingresa el modelo del Avion: ");
                                entityRead.setModel(modelRead);
                                planeRead = controller.ReadPlane(entityRead);
                                if(planeRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Aviones encontrados:\n"+planeRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron aviones.");
                                }
                                break;
                            case 3:
                                int capacityRead = Verification.integer("Ingresa la Capacidad del Avion: ");
                                entityRead.setCapacity(capacityRead);
                                planeRead = controller.ReadPlane(entityRead);
                                if(planeRead.size() > 0) {
                                    JOptionPane.showMessageDialog(null,"Aviones encontrados:\n"+ planeRead);
                                }else {
                                    JOptionPane.showMessageDialog(null,"No se encontraron aviones.");
                                }
                                break;
                            case 4:
                                readPlane = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    }
                    break;
                case 5:
                    ArrayList<PlaneEntity> planelist = new ArrayList<PlaneEntity>();
                    planelist = controller.ReadAllPlanes();
                    if(planelist.size() > 0) {
                        JOptionPane.showMessageDialog(null,"Todos los Aviones:\n"+ planelist);
                    }else {
                        JOptionPane.showMessageDialog(null,"No hay Aviones.");
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
