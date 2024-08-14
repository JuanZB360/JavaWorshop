package ExecuteMenu;

import Util.Utils;
import controller.AuthorController;
import entity.AuthorEntity;

import javax.swing.*;
import java.util.ArrayList;

public class AuthorExecute {
    public static void AuthorMenu() throws ClassNotFoundException {
        AuthorController authorController = new AuthorController();
        AuthorEntity request = new AuthorEntity();

        boolean session = true;
        while(session){
            int option = Utils.integer("MENU:\n\t1- Crear un Autor.\n\t2- Mostrar todos los Autores.\n\t3- Buscar por Id.\n\t4- Actualizar un autor.\n\t5- Eliminar.\n\t6- Salir.");

            switch (option) {
                case 1:
                    //create
                    String name = Utils.string("Ingresa el nombre: ");
                    String nationality = Utils.string("Ingresa la nacionalidad: ");

                    AuthorEntity author = new AuthorEntity(name, nationality);
                    request = authorController.CreateAuthor(author);
                    JOptionPane.showMessageDialog(null, "Autor creado con éxito:\n " + request);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Lista de autores:\n"+authorController.ReadAll());
                    break;
                case 3:
                    //read by id
                    int idReadByid = Utils.integer("Ingresa el Id de autor que deseas buscar: ");
                    AuthorEntity readById = new AuthorEntity();
                    request.setId(idReadByid);
                    readById = authorController.ReadById(request);
                    if(readById.getName() != null) {
                        JOptionPane.showMessageDialog(null, "Autor leído:\n " + request);
                    }else{
                        JOptionPane.showMessageDialog(null, "El autor no existe.");
                    }
                    break;
                case 4:
                    //Update
                    int intUpdate = Utils.integer("Ingresa el Id del autor que deseas Actualizar: ");
                    AuthorEntity update = new AuthorEntity(intUpdate);
                    request = authorController.ReadById(update);
                    if(request.getName() != null) {
                        String nameUpdate = Utils.string("Ingresa el nuevo nombre: ");
                        String nationalityUpdate = Utils.string("Ingresa la nueva nacionalidad: ");
                        update.setName(nameUpdate);
                        update.setNationality(nationalityUpdate);
                        request = authorController.UpdateAuthor(update);
                        JOptionPane.showMessageDialog(null, "Autor actualizado con éxito:\n " + request);
                    }else{
                        JOptionPane.showMessageDialog(null, "El autor no existe.");
                    }
                    break;
                case 5:
                    //delete
                    AuthorEntity listDelete = new AuthorEntity();
                    int idDelete = Utils.integer("Ingresa eel Id del autor: ");
                    AuthorEntity delete = new AuthorEntity(idDelete);
                    delete = authorController.ReadById(delete);
                    if(delete.getName()!= null) {
                        authorController.DeleteAuthor(delete);
                    }else{
                        JOptionPane.showMessageDialog(null, "El autor que deseas eliminar no existe en la base de datos...");
                    }
                    break;
                case 6:
                    session = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Option Incorrect...");
                    break;
            }
        }
    }
}
