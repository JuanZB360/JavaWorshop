import controller.AuthorController;
import entity.AuthorEntity;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        AuthorController authorController = new AuthorController();
        AuthorEntity request = new AuthorEntity();

        boolean session = true;
        while(session){
            int option = Integer.parseInt(JOptionPane.showInputDialog("MENU:\n\t1- Crear un Autor.\n\t2- Mostrar todos los Autores.\n\t3- Buscar por Id.\n\t4- Actualizar un autor.\n\t5- Eliminar.\n\t6- Salir."));

            switch (option) {
                case 1:
                    //create
                    String name = JOptionPane.showInputDialog("Ingresa el nombre: ");
                    String nationality = JOptionPane.showInputDialog("Ingresa la nacionalidad: ");

                    AuthorEntity author = new AuthorEntity(name, nationality);
                    request = authorController.CreateAuthor(author);
                    JOptionPane.showMessageDialog(null, "Autor creado con éxito:\n " + request);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Lista de autores:\n"+authorController.ReadAll());
                    break;
                case 3:
                    //read by id
                    int idReadByid = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Id de autor que deseas buscar: "));
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
                    int intUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Id del autor que deseas Actualizar: "));
                    AuthorEntity update = new AuthorEntity(intUpdate);
                    request = authorController.ReadById(update);
                    if(request.getName() != null) {
                        String nameUpdate = JOptionPane.showInputDialog("Ingresa el nuevo nombre: ");
                        String nationalityUpdate = JOptionPane.showInputDialog("Ingresa la nueva nacionalidad: ");
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
                    int idDelete = Integer.parseInt(JOptionPane.showInputDialog("Ingresa eel Id del autor: "));
                    AuthorEntity delete = new AuthorEntity();
                    delete.setId(idDelete);
                    AuthorEntity delete1 = new AuthorEntity();
                    authorController.DeleteAuthor(delete);
                    break;
                case 6:
                    session = false;
                    JOptionPane.showMessageDialog(null, "Closing Session...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Option Incorrect...");
                    break;
            }
        }





    }
}
